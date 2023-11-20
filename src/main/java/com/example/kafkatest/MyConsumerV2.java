package com.example.kafkatest;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Component;

/**
 * 설명 : Consumer 생성하기
 */
@Component
public class MyConsumerV2 {

    /**
     * 기능 : kafka Consumer 생성하기
     * @param : message : Producer가 topic에 보낸 메시지
     */
    @KafkaListeners(value = {
            @KafkaListener(
                    id = "mygroup6",
                    topics = "mytest3"
            )

    })
    public void listen(String message) {
        System.out.println("======= MyConsumerV2 mytest3 topic의 partition에 있는 데이터 시작 ==================");

        System.out.println(message);

        System.out.println("======= MyConsumerV2 mytest3 topic의 partition에 있는 데이터 끝 ==================");
    }



}
