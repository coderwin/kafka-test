package com.example.kafkatest.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

@Slf4j
public class ConsumerDefaultMessageListenerV2 implements MessageListener<String, String> {
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {

        log.info("=========== second application consumer data : {} =============", data);
        log.info("=========== second application consumer data key : {} =============", data.key());
        log.info("=========== second application consumer data value : {} =============", data.value());
        log.info("=========== second application consumer data offset : {} =============", data.offset());
    }
}
