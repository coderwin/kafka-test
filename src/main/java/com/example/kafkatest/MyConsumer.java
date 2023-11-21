package com.example.kafkatest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    // kafka Consumer 생성하기

    /**
     * localhost가 아니라 특정 port를 사용하기 위해서는
     * -> KafkaMessageListenerContainer가 아니라
     * -> ConcurrentKafkaListenerContainerFactory를 사용해야 한다.
     */
    @KafkaListener(
            id = "mygroup5",// consumer  그룹 아이디
            topics = "mytest3",// topic
            containerFactory = "concurrentMessageListenerContainer"
    )
    public void listen(String message) {

        System.out.println("================= 1111111 mytest3 topic의 partition에 있는 데이터 시작 ================");

        System.out.println(message);

        System.out.println("================= 1111111 mytest3 topic의 partition에 있는 데이터 끝 ================");


    }







}
