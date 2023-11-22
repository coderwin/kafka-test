package com.example.kafkatest.producer;

import com.example.kafkatest.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@RequiredArgsConstructor
@Service
public class JsonKafkaProducer {

    private final KafkaTemplate<String, ChatMessage> kafkaTemplate;

    public void send(ChatMessage chatMessage) {

        System.out.println("chatMessage : " + chatMessage);// 확인 ok

        String topic = "springexam";
        ListenableFuture<SendResult<String, ChatMessage>> listenableFuture = kafkaTemplate.send(topic, chatMessage);

        listenableFuture.addCallback(
                new KafkaSendCallback<String, ChatMessage>() {
                    @Override
                    public void onSuccess(SendResult<String, ChatMessage> result) {

                        System.out.println("======= success producer send start ========");;
                        System.out.println("======= producer send ======== : " + result);;
                        System.out.println("======= success producer send end ========");;
                    }

                    @Override
                    public void onFailure(KafkaProducerException ex) {

                        ProducerRecord<Object, Object> record = ex.getFailedProducerRecord();

                        System.out.println("======= producer send failed ======== : " );;
                        System.out.println("======= producer send failed ======== : " + record);;
                        System.out.println("======= producer send failed ======== : ");;

                    }

                }
        );

    }



}
