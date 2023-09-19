package com.example.consumer.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ItemDto {
    private int itemId;
    private String itemName;
    private String itemDesc;
    private Double itemCost;
//    private int itemqty;
    private int itemQty;
    private Date createTs;
    private Date updateTs;

}
