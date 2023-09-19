package com.example.consumer.Entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table("message_details")
public class MessageDetails {
    //    msgid, orderId, msgcreate_ts, msgString
    @PrimaryKey
    private UUID msgId;
    private int EntityId;
    private LocalDateTime msgCreatedAt;
    private String message;
}
