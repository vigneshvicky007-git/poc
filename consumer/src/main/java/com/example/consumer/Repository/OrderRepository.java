package com.example.consumer.Repository;

import com.example.consumer.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderRepository extends JpaRepository<Order,Integer> {

//    @Query("SELECT * FROM order_details WHERE cust_id = ?")
    List<Order> findAllByCustId(int customerId);



}
