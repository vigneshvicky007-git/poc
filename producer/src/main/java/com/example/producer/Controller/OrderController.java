package com.example.producer.Controller;

import com.example.producer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("sendOrderJsonDataToTopic")
    private String sendJsonToKafka(@RequestBody String str){
        orderService.sendJsonDataToKafka(str);
        return "msg send to kafka topic";
    }
//    @GetMapping("getOrderDetails")
//    public String getOrdersDetails() {
//        return orderService.getOrdersDetails();
//    }
}
