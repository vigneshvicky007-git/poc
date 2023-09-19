package com.example.consumer.Service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.example.consumer.Dto.*;
import com.example.consumer.Entity.Messages;
import com.example.consumer.Entity.Order;
import com.example.consumer.Entity.Orderdetails;
import com.example.consumer.Repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderdetailsRepository orderdetailsRepository;
    @Autowired
    MessageDetailsRepository messageDetailsRepository;
    @Autowired
    MessagesRepository messagesRepository;

    @KafkaListener(topics = "orderJsonTopic", groupId = "consumerGroup")
    public void listenerToOrderJsonTopic(String orderMsg) {
        System.out.println("Json msg for Item received from kafka Topic" + orderMsg);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            OrderDto orderDto = objectMapper.readValue(orderMsg, OrderDto.class);

            Order order = new Order();
            ItemDto itemDto = new ItemDto();
            order.setOrderId(orderDto.getOrderid());
            order.setCustId(orderDto.getCustomer().getCustid());
            order.setItemQty(orderDto.getItem().size());
            order.setOrderCost(orderDto.getOrderCost());
            order.setOrderStatus(orderDto.getOrderStatus());
            order.setOrderCreateTs(orderDto.getOrderCreateTs());
            order.setOrderUpdateTs(orderDto.getOrderUpdateTs());
            orderRepository.save(order);
            System.out.println("Json msg for order saved to order table");


            Messages messages= new Messages();
            messages.setEntityId(3);
            messages.setMsgCreatedAt(LocalDateTime.now());
            messages.setMessage(orderMsg);
            messagesRepository.save(messages);
            System.out.println("Customer saved to the database: " + order);


            orderDto.getItem().forEach(itemDto1 -> {
                Orderdetails orderdetails = new Orderdetails();
                orderdetails.setOrderdetailsid(UUID.randomUUID());
                orderdetails.setOrderid(orderDto.getOrderid());
                orderdetails.setItemid(itemDto1.getItemId());
                orderdetails.setItemname(itemDto1.getItemName());
                orderdetails.setItemqty(itemDto1.getItemQty());
                orderdetails.setCustid(orderDto.getCustomer().getCustid());
                orderdetailsRepository.save(orderdetails);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CustomerResponseDto> getOrderDetailsBycustomerId(int customerId) {
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();

        try (CqlSession cqlSession = CqlSession.builder().build()) {
            List<Order> orders = orderRepository.findAllByCustId(customerId);

            for (Order order : orders) {
                CustomerResponseDto customerResponseDto = new CustomerResponseDto();
                customerResponseDto.setOrderId(order.getOrderId());
                customerResponseDto.setOrderCost(order.getOrderCost());
                customerResponseDto.setOrderStatus(order.getOrderStatus());

                String query = "SELECT itemqty FROM my_keyspace.order_details WHERE orderid = ? ALLOW FILTERING";
                PreparedStatement preparedStatement = cqlSession.prepare(query);
                BoundStatement boundStatement = preparedStatement.bind(order.getOrderId());
                ResultSet resultSet = cqlSession.execute(boundStatement);

                int totalNoOfItems = 0;
                for (Row row : resultSet) {
                    totalNoOfItems += row.getInt("itemqty");
                }

                customerResponseDto.setNoOfItems(totalNoOfItems);
                customerResponseDtoList.add(customerResponseDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerResponseDtoList;
    }


    //
public ItemResponseDto getItemDetailsByItemId(int itemid) {
    ItemResponseDto itemResponseDto = new ItemResponseDto();
    List<String> itemName = new ArrayList<>();
    int totalQtyOrders = 0;

    try (CqlSession session = CqlSession.builder().build()) {
        String query = "SELECT itemname, itemqty FROM my_keyspace.order_details WHERE itemid = ? ALLOW FILTERING";
        SimpleStatement statement = SimpleStatement.builder(query).addPositionalValue(itemid).build();
        ResultSet resultSet = session.execute(statement);

        for (Row row : resultSet) {
            itemName.add(row.getString("itemname"));
            totalQtyOrders += row.getInt("itemqty");
        }
    }

    itemResponseDto.setItemName(itemName);
    itemResponseDto.setTotalQtyOrders(totalQtyOrders);
    itemResponseDto.setTotalNumberOfOrders(itemName.size());

    return itemResponseDto;
}

    public Optional<Messages> getMessageDetailsBymsgId(int msgId) {
        return messagesRepository.findById(msgId);
    }
}

