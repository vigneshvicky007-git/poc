package com.example.producer.Controller;

import com.example.producer.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("sendItemJsonDataToTopic")
    private String sendJsonToKafka(@RequestBody String str){
        itemService.sendItemJsonDataToKafka(str);
        return "msg send to kafka topic";
    }
}
