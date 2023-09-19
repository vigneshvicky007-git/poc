//package com.example.consumer.Service;
//
//import com.example.consumer.Dto.CustomerDto;
//import com.example.consumer.Dto.ItemDto;
//import com.example.consumer.Dto.OrderdetailsDto;
//import com.example.consumer.Entity.Item;
//import com.example.consumer.Entity.Order;
//import com.example.consumer.Entity.Orderdetails;
//import com.example.consumer.Repository.ItemRepository;
//import com.example.consumer.Repository.OrderRepository;
//import com.example.consumer.Repository.OrderdetailsRepository;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderdetailsService {
//    @Autowired
//    OrderdetailsRepository orderdetailsRepository;
//    @Autowired
//    OrderRepository orderRepository;
//
//    @Autowired
//    ItemRepository itemRepo;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @KafkaListener(topics = "orderDetailsJsonTopic", groupId = "consumerGroup")
////    public void listenerToOrderDetailsJsonTopic(String orderDetails){
//    public void listenerToOrderDetailsJsonTopic(String orderDto) {
//        System.out.println("Json msg for Item received from kafka Topic" + orderDto);
//
////        try {
////        ObjectMapper objectMapper = new ObjectMapper();
//////            OrderdetailsDto order1 = objectMapper.readValue(orderDetails, OrderdetailsDto.class);
////
////        OrderdetailsDto orderdetails = new OrderdetailsDto();
////
////        CustomerDto customerDto = orderDto.getCustomerDto();
////        List<ItemDto> itemsDto = orderDto.getItemDto();
////
////        String customerId = String.valueOf(customerDto.getCustId());
////        String customerEmail = customerDto.getEmailid();
////
////        for (ItemDto item : itemsDto) {
////            String itemId = String.valueOf(item.getItemId());
////            String itemName = item.getItemName();
//////                int itemQty = item.getItemQty();
////            double itemCost = item.getItemCost();
////
////            String orderId = String.valueOf(orderDto.getOrderId());
////            String orderCreateTs = orderDto.getOrderCreateTs();
////            String orderStatus = orderDto.getOrderStatus();
////
////            // Create and return the order
////            // ...
////
////            return orderDto;
////
//////            orderdetails.setOrderId(order1.getOrderId());
//////            orderdetails.setOrderCreateTs(order1.getOrderCreateTs());
//////            orderdetails.setOrderStatus(order1.getOrderStatus());
//////            orderdetails.setCustomerDto(order1.getCustomerDto());
////
////        }
//////            catch (JsonProcessingException e) {
//////            throw new RuntimeException(e);
//////        }
//////    }
////
////        return orderdetails;
//////        repository.save(orderdetails);
//        Order order = null;
//        try {
//            order = mapper.readValue(orderDto, Order.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Received message: " + order);
//        orderRepository.save(order);
//        Orderdetails orderDetails = new Orderdetails();
//        orderDetails.setOrderId(order.getOrderId());
//        Optional<Item> byId = itemRepo.findById(order.getItemId());
//        orderDetails.setItemQty(byId.get().getItemId());
//        orderDetails.setItemName(byId.get().getItemName());
//        orderDetails.setOrderDetailsId(order.getOrderId());
//        orderDetails.setItemId(order.getItemId());
//        orderdetailsRepository.save(orderDetails);
//        System.out.println("message" + orderDetails);
//    }
//}
