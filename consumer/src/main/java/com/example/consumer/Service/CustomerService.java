package com.example.consumer.Service;

import com.example.consumer.Entity.Customer;
import com.example.consumer.Entity.MessageDetails;
import com.example.consumer.Entity.Messages;
import com.example.consumer.Repository.CustomerRepository;
import com.example.consumer.Repository.MessageDetailsRepository;
import com.example.consumer.Repository.MessagesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    MessageDetailsRepository messageDetailsRepository;

    @KafkaListener(topics = "kTopic",groupId = "consumerGroup")
    public void listenerToCustomerItemJsonTopic(String str) throws IOException {
        System.out.println("Json msg for Item received from kafka Topic"+ str);

        try {
//            ObjectMapper objectMapper = new ObjectMapper();
            Customer customerItem = mapper.readValue(str, Customer.class);
            repository.save(customerItem);

//            MessageDetails messageLogger = new MessageDetails();
//            messageLogger.setMsgId(UUID.randomUUID());
//            messageLogger.setEntityId(customerItem.getCustId());
//            messageLogger.setMsgCreatedAt(LocalDateTime.now());
//            messageLogger.setMessage(str);
//            messageDetailsRepository.save(messageLogger);
            Messages messages= new Messages();
            messages.setEntityId(1);
            messages.setMsgCreatedAt(LocalDateTime.now());
            messages.setMessage(str);
            messagesRepository.save(messages);
            System.out.println("Customer saved to the database: " + customerItem);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
