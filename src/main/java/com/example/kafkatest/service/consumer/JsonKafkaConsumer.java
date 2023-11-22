package com.example.kafkatest.service.consumer;

import com.example.kafkatest.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @KafkaListener(
//            id = "hello2",
            topics = "springexam",
//            groupId = "jsontest2",
            containerFactory = "getJsonKafkaListenerContainerFactory"
    )
    public void listener(ChatMessage responseChatMessage) {

        System.out.println("============== get message start ===============");

        System.out.println(responseChatMessage);
        System.out.println(responseChatMessage.getRoomId());
        System.out.println(responseChatMessage.getSender());
        System.out.println(responseChatMessage.getMessage());

        System.out.println("============== get message end ===============");

    }





}
