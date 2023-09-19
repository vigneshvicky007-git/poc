package com.example.consumer.Entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@Table("item")
public class Item {
    @PrimaryKey
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;
    private String itemName;
    private String itemDesc;
    private Double itemCost;
    private int itemQty;
    private Date createTs;
    private Date updateTs;

}
