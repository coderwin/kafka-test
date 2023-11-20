package com.example.kafkatest.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MyProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send() {
//        kafkaTemplate.send("mytest3", "new producer by kafka spring test........");
        kafkaTemplate.send("mytest2", "new producer by kafka spring test........");
    }




}
