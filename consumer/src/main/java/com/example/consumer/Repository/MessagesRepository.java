package com.example.consumer.Repository;

import com.example.consumer.Entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages,Integer> {


}
