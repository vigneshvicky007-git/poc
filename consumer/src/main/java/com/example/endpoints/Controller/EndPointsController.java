package com.example.endpoints.Controller;

import com.example.endpoints.Service.EndPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EndPointsController {

    @Autowired
    EndPointsService service;
    @GetMapping("getItemDetails")
    private String getItemDetails(@RequestParam int id){
        service.getItemDetails(id);
        return getItemDetails(id);
    }
}
