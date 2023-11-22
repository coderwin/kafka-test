package com.example.kafkatest.config;

import com.example.kafkatest.model.ChatMessage;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : json 사용을 위한 Consumer config 작성
 */
@Configuration
public class KafkaJsonConsumerConfig {


    /**
     * 기능 : Consumer Container or ContainerFactory 객체 생성
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ChatMessage> getJsonKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, ChatMessage> containerFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        containerFactory.setConsumerFactory(jsonConsumerFactory());
        // Liseter 사용자가 조절해서 사용(start(), stop()....)
//        containerFactory.setAutoStartup(false);
        return containerFactory;
    }

    /**
     * 기능 : CunsumerFactory 객체 생성
     * comment : <key, value>
     */
    private ConsumerFactory<String, ChatMessage> jsonConsumerFactory() {

        ConsumerFactory<String, ChatMessage> consumerFactory =
                new DefaultKafkaConsumerFactory<>(
                        properties(),
                        new StringDeserializer(),
                        new JsonDeserializer<>(ChatMessage.class)
                        );

        return consumerFactory;
    }

    /**
     * 기능 : Consumer properties 객체 생성
     */
    private Map<String, Object> properties() {
        Map<String, Object> props = new HashMap<>();

        String serverIp = "192.168.0.211:9092";
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverIp);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "jsonConsumer2");

        return props;

    }








}
