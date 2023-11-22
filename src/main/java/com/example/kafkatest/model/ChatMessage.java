package com.example.kafkatest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 설명 : 채팅 entity
 */
@ToString
@Getter
public class ChatMessage {

    private String roomId;
    private String sender;
    private String message;




}
