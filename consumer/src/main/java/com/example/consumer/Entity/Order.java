package com.example.consumer.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "order_table")
public class Order {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private Double orderCost;
    private Date orderCreateTs;
    private Date orderUpdateTs;
    private String orderStatus;
//    @OneToOne
//    private Customer custId;

    private int itemQty;

    private int custId;

}
