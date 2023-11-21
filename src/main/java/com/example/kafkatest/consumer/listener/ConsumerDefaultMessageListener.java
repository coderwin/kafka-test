package com.example.kafkatest.consumer.listener;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

@Slf4j
public class ConsumerDefaultMessageListener implements MessageListener<String, String> {

    /**
     * 메시지가 전송되면 onMessage가 호출
     * -> 데이터가 ConsumerRecord로 전달된다.
     * @param data the data to be processed.
     */
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {

        log.info("=============== consumer listener {} ===================", data);
        log.info("=============== consumer listener key : {} ===================", data.key());
        log.info("=============== consumer listener value : {} ===================", data.value());

    }
}
