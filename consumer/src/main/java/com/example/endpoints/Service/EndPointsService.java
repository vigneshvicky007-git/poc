package com.example.endpoints.Service;

import com.example.consumer.Entity.Item;
import com.example.endpoints.ItemRepo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndPointsService {

    @Autowired
    ItemRepo itemRepo;
//    public String getItemDetails() {
//
//    }
    public Item getItemDetails(int id) {

        return itemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
    }
}
