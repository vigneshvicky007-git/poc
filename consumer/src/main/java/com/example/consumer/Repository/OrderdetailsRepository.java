package com.example.consumer.Repository;

import com.example.consumer.Entity.Orderdetails;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;


public interface OrderdetailsRepository extends CassandraRepository<Orderdetails,Integer> {
//    @AllowFiltering
    @Query("SELECT * FROM order_details WHERE orderid = ?0 ALLOW FILTERING")
    List<Orderdetails> findByorderid(int orderid);
//    @AllowFiltering
    @Query("SELECT * FROM order_details WHERE itemid = ?0 ALLOW FILTERING")
    List<Orderdetails> findByitemid(int itemid);

}
