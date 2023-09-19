package com.example.consumer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String firstname;
    private String lastname;
    private String addressline1;
    private String city;
    private String country;
    private String phno;
    private String emailid;
}
