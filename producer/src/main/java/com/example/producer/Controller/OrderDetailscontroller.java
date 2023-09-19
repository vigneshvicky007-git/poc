package com.example.producer.Controller;

import com.example.producer.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderDetailscontroller {

    @Autowired
    OrderDetailsService orderDetailsService;

//    @PostMapping("sendOrderDetailsJsonDataToTopic")
//    private String sendOrderDetailsJsonToKafka(@RequestBody String str){
//        orderDetailsService.sendOrderDetailsJsonDataToKafka(str);
//        return "msg send to kafka topic";
//    }
}
