package com.example.kafkatest.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : Producer 생성하기
 */
public class KafkaTemplateConfigV2 {

    /**
     * 기능 : Producer 생성하기
     * comment : KafkaTemplate 객체 생성
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplateV2() {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        return kafkaTemplate;
    }

    /**
     * 기능 : KafkaTemplateFacotry 객체 생성
     */
    private ProducerFactory<String, String> producerFactory() {
        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(producerProps());
        return producerFactory;
    }

    /**
     * 기능 : KafkaTemplateFactory에 사용될 props(설정정보) 객체 생성
     */
    public Map<String, Object> producerProps() {

        Map<String, Object> props = new HashMap<>();

        // serverIp 설정하기
        String serverIp = "192.168.0.211:9092";
        // kafak 설정 만들기
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverIp);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }







}
