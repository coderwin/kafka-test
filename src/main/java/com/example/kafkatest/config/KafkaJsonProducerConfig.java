package com.example.kafkatest.config;

import com.example.kafkatest.model.ChatMessage;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : Producer 생성 위한 config
 */
@Configuration
public class KafkaJsonProducerConfig {


    /**
     * 기능 : KafkaTemplate 객체 생성
     */
    @Bean
    public KafkaTemplate<String, ChatMessage> getJsonKafkaTemplate() {
        KafkaTemplate<String, ChatMessage> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        return kafkaTemplate;
    }

    /**
     * 기능 : ProducerFactory 객체 생성
     */
    private ProducerFactory<String, ChatMessage> producerFactory() {
        ProducerFactory<String, ChatMessage> producerFactory =
                new DefaultKafkaProducerFactory<>(properties());

        return producerFactory;
    }

    /**
     * 기능 : Producer Properties 객체 생성
     */
    private Map<String, Object> properties() {

        Map<String, Object> props = new HashMap<>();

        String serverIp = "192.168.0.211:9092";
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverIp);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return props;


    }













}
