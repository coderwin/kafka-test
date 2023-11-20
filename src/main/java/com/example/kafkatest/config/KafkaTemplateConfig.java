package com.example.kafkatest.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTemplateConfig {

    /**
     * 기능 : Producer 객체를 생성하기
     *       -> KafkaTemplate 이용한다.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        return kafkaTemplate;
    }


    /**
     * 기능 : Producer 객체를 만들 수 있도록 ProducerFactory객체 생성
     */
    private ProducerFactory<String, String> producerFactory() {

       ProducerFactory<String, String> producerFactory  = new DefaultKafkaProducerFactory<>(producerProps());

       return producerFactory;
    }



    /**
     * 기능 : 카프카 Producer에 대한 설정정보
      */
    private Map<String, Object> producerProps() {

        Map<String, Object> props = new HashMap<>();

        String serverIp = "192.168.0.211:9092";
        // 카프카가 기본으로 제공하는 설정 이용
        // 서버
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverIp);// --bootstrap-server [serverIp]
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);// 직렬화 한다는 말인가? OK
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);//

        return props;
    }




}
