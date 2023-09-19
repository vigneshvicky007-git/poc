package com.example.consumer.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderdetailsDto {

    private int orderdetailsid;
    private int orderId;
    private Date orderCreateTs;
    private String orderStatus;
    private Double orderCost;
    private CustomerDto customerDto;
    private List<ItemDto> itemDto;
}
