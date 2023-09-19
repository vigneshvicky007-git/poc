package com.example.endpoints.ItemRepo;

import com.example.consumer.Entity.Item;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ItemRepo extends CassandraRepository<Item,Integer> {
}
