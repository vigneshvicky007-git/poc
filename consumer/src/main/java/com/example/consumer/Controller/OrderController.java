package com.example.consumer.Controller;

import com.example.consumer.Dto.CustomerResponseDto;
import com.example.consumer.Dto.ItemResponseDto;
import com.example.consumer.Entity.Messages;
import com.example.consumer.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("getItemDetailsByItemId")
    public ItemResponseDto getItemDetails(@RequestParam int itemid) {
        return orderService.getItemDetailsByItemId(itemid);
    }

    @GetMapping("/getOrderDetailsByCustomerId")
    private List<CustomerResponseDto> getByCustomerId(@RequestParam int customerId) {
        return orderService.getOrderDetailsBycustomerId(customerId);
    }
    @GetMapping("/getMessageDetailsById")
    private Optional<Messages> getMessageById(@RequestParam int msgId){
        return orderService.getMessageDetailsBymsgId(msgId);
    }
}