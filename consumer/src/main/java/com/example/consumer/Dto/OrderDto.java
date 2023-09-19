package com.example.consumer.Dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDto {

    private int orderid;

//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Double orderCost;
    private Date orderCreateTs;
    private Date orderUpdateTs;

    private String orderStatus;

    private CustomerDto customer;

    private List<ItemDto> item;
    private int orderDetailsId;
}
