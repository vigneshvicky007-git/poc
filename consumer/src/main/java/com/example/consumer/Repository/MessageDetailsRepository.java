package com.example.consumer.Repository;

import com.example.consumer.Entity.MessageDetails;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface MessageDetailsRepository extends CassandraRepository<MessageDetails, UUID> {
//    List<MessageDetails> getByMsgId(UUID msgId);

}
