package com.example.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ProducerConfig {
    @Bean
    public NewTopic createJsonTopic(){
        return TopicBuilder.name("kTopic").build();
    }
//    @Bean
//    public NewTopic createCustomerJsonTopic(){
//        return TopicBuilder.name("customerJsonTopic").build();
//    }
//
    @Bean
    public NewTopic createItemJsonTopic(){
        return TopicBuilder.name("itemJsonTopic").build();
    }
    @Bean
    public NewTopic createOrderJsonTopic(){
        return  TopicBuilder.name("orderJsonTopic").build();
    }
    @Bean
    public NewTopic createOrderDetailsJsonTopic(){
        return  TopicBuilder.name("orderDetailsJsonTopic").build();
    }
}
