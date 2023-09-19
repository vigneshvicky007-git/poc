package com.example.consumer.Repository;

import com.example.consumer.Entity.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface ItemRepository extends CassandraRepository<Item,Integer> {

//    Optional<Item> findById(int itemId);
}
