package com.example.kafkatest.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Component
@Slf4j
public class MyProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 기능 : 일반적 비동기 처리
     * comment : 간단한 메시지 보내기 작업
     */
    public void send() {
//        kafkaTemplate.send("mytest3", "new producer by kafka spring test........");
        kafkaTemplate.send("mytest2", "new producer by kafka spring test........");
    }

    /**
     * 기능 : KafkaTemplate 이용해서 콜백 처리
     */
    public void async(String topic, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        future.addCallback(new KafkaSendCallback<>() {

            // 메시지 보내기가 성공하면 콜백으로 호출되는 메서드
            @Override
            public void onSuccess(SendResult<String, String> result) {

                log.info("-------------------- 메시지 전송 성공 시작 success 1 ------------------------");

                log.info("메시지 전송 성공 ======> {}", result);

                log.info("-------------------- 메시지 전송 성공 끝 success 1 -----------------------");


            }


            @Override
            public void onFailure(KafkaProducerException ex) {
                // 메시지 보내기가 실패하는 경우 넘겨받는 객체를 이용해서 정보를 출력
                ProducerRecord<Object, Object> record = ex.getFailedProducerRecord();

                log.info("***************** 메시지 전송 실패 시작 fail 0 *******************");

                log.info("메시지 전송 실패 =====> " + record);

                log.info("***************** 메시지 전송 실패 끝 fail 0 *******************");
            }
        });
    }

    /**
     * Kafka 동기 통신
     * -> 여기서 동기통신이라는 말이 메시지 전송이 끝나고 진행되는 로직을 말하는 것인가?
     */
    public void sync(String topic, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

        try {
            log.info("***************** 메시지 전송 동기 통신 시작 *******************");

            future.get();

            log.info("***************** 메시지 전송 동기 통신 끝 *******************");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }






}
