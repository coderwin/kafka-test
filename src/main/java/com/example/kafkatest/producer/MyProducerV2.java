package com.example.kafkatest.producer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : Producer 생성하기
 */
@RequiredArgsConstructor
@Component
public class MyProducerV2 {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 기능 : producer 실행하기
     */
    public void send() {
        kafkaTemplate.send("mytest3", "How can I help you?");
    }







}
