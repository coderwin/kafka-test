package com.example.kafkatest.config;

import com.example.kafkatest.consumer.listener.ConsumerDefaultMessageListener;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    /**
     * 기능 : ConcurrentKafkaListenerContainerFactory 사용
     * comment : -> @KafkaListener 상용하기 위해서
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> concurrentMessageListenerContainer() {

        ConcurrentKafkaListenerContainerFactory<String, String> concurrentFactory =
                new ConcurrentKafkaListenerContainerFactory<>();

        // consumerFactory를 주입한다.
        concurrentFactory.setConsumerFactory(consumerFactory());

        return concurrentFactory;
    }

    /**
     * 기능 : Consumer 객체를 생성하기
     *       => Consumer 객체에서 왜 속성을 다시 정의하나요?
     *       => props에서 하지 않는 이유는 무엇인가요?
     *          => 서로 다른 용도의 Consumer가 있기 때문에?
     * comment : interface인 MessageListener를 사용해서 컨슈머를 등록한다.
     */
    @Bean
    public KafkaMessageListenerContainer<String, String> makeListenerContainer() {

        // container 설정정보
        String topic = "springexam";
        ContainerProperties containerProperties = new ContainerProperties(topic);

        // 설정 정보가 있다면 설정 정보 설정하기
        String groupId = "springexamgroup";
        containerProperties.setGroupId(groupId);// 그룹아이디 설정
        containerProperties.setAckMode(ContainerProperties.AckMode.BATCH);// 단일 처리 or betch로(모아서 한번에 처리) 처리
        containerProperties.setMessageListener(new ConsumerDefaultMessageListener());// 리스터 설정인가?

        // 컨테이너 객체를 생성
        KafkaMessageListenerContainer<String, String> container = new KafkaMessageListenerContainer<>(consumerFactory(), containerProperties);
        // 원하는 시점에 strart하기 위해서 자동으로 start되지 않도록 설정
        // 이건 무엇?????????
        // true랑 차이가 있나?
        container.setAutoStartup(false);

        return container;
    }


    /**
     * 기능 : Consumer를 만들 수 있는 ConsumerFactory 객체 생성
     */
    private ConsumerFactory<String, String> consumerFactory() {
       ConsumerFactory<String, String> consumerFactory  = new DefaultKafkaConsumerFactory<>(consumerProps());
       return consumerFactory;
    }

    /**
     * 기능 : 카프카 Conumser에 대한 설정정보
     */
    private Map<String, Object> consumerProps() {

        Map<String, Object> props = new HashMap<>();

        String serverIp = "192.168.0.211:9092";
        // 카프카가 기본으로 제공하는 설정 이용
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, serverIp);
        // producer는 직열화하여 여러 패킷들을 서버(broker) 보내고
        // consumer는 역질열화하여 여러 패킷들을 푼다
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }



}
