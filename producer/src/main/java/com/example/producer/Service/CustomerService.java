package com.example.producer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
   private KafkaTemplate<String,String> kafkaTemplate;
    public String sendCustomerJsonDataToKafka(String str) {
        System.out.println("Json msg received from kafka Topic" + str.toString());
        kafkaTemplate.send("kTopic",str);
        return str;
    }
}
