package com.example.consumer.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class CustomerDto {

    private int custid;
    private String firstname;
    private String lastname;
    private String addressline1;
    private String city;
    private String country;
    private String phno;
    private String emailid;
}
