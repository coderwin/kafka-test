package com.example.kafkatest.controller;

import com.example.kafkatest.model.ChatMessage;
import com.example.kafkatest.producer.JsonKafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class JsonKafkaController {


    private final JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/json/chat")
    public void send(@RequestBody ChatMessage chatMessage) {

        jsonKafkaProducer.send(chatMessage);
    }


}
