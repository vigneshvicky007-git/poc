package com.example.consumer.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponseDto {
    private List<String> itemName;
    private int totalNumberOfOrders;
    private int totalQtyOrders;

}
