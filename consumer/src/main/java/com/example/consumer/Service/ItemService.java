package com.example.consumer.Service;

import com.example.consumer.Dto.ItemDto;
import com.example.consumer.Entity.Item;
import com.example.consumer.Entity.MessageDetails;
import com.example.consumer.Entity.Messages;
import com.example.consumer.Repository.ItemRepository;
import com.example.consumer.Repository.MessageDetailsRepository;
import com.example.consumer.Repository.MessagesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ItemService {

    @Autowired
    ItemRepository repository;

    @Autowired
    ObjectMapper mapper;
    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    MessageDetailsRepository messageDetailsRepository;

    @KafkaListener(topics = "itemJsonTopic", groupId = "consumerGroup")
    public void listenerToItemJsonTopic(String str) {
        System.out.println("Json msg for Item received from kafka Topic" + str);

        try {
            ItemDto[] itemDtos = mapper.readValue(str, ItemDto[].class);

            for (ItemDto itemDto : itemDtos) {
                Item item = new Item();
                item.setItemId(itemDto.getItemId());
                item.setItemName(itemDto.getItemName());
                item.setItemDesc(itemDto.getItemDesc());
                item.setItemCost(itemDto.getItemCost());
                item.setItemQty(itemDto.getItemQty());
                item.setCreateTs(itemDto.getCreateTs());
                item.setUpdateTs(itemDto.getUpdateTs());

                repository.save(item);

                Messages messages=new Messages();
                messages.setEntityId(2);
                messages.setMsgCreatedAt(LocalDateTime.now());
                messages.setMessage(str);
                messagesRepository.save(messages);
                System.out.println("Customer saved to the database: " + item);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

