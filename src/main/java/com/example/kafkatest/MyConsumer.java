package com.example.kafkatest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    // kafka Consumer 생성하기
    @KafkaListener(
            id = "mygroup5",// consumer  그룹 아이디
            topics = "mytest3"// topic
    )
    public void listen(String message) {

        System.out.println("================= mytest3 topic의 partition에 있는 데이터 시작 ================");

        System.out.println(message);

        System.out.println("================= mytest3 topic의 partition에 있는 데이터 끝 ================");


    }







}
