package com.example.consumer.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int msgId;
    private int EntityId;
    private LocalDateTime msgCreatedAt;
    @Lob
    private String message;
}
