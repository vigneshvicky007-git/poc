package com.example.consumer.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDto {
//    Orderid, cost, number of items, order status
    private int orderId;
//    private int customerId;
    private Double orderCost;
//    private int itemQty;
    private String orderStatus;
    private int noOfItems;

}
