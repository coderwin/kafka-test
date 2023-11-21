package com.example.kafkatest.producer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyProducerTest {

    @Autowired
    MyProducer myProducer;
    @Autowired
    MyProducerV2 myProducerV2;

    @Test
    public void myProducerTest() {
        myProducer.send();
    }

    @Test
    public void myProducerTest2() {
        myProducerV2.send();
    }

    /**
     * 기능 : kafkaTempalte 비동기 통신 테스트
     */
    @Test
    void producerAsyncTest() {
        myProducer.async("springexam", "callbacktest");
    }

    /**
     * 기능 : kafkaTempalte 동기 통신 테스트
     */
    @Test
    void producerSynctest() {
        myProducer.sync("springexam", "synctest");
    }

    /**
     * 기능 : 외부 consumer로 메시지 전송
     */
    @Test
    void producerAsyncTestV2() {
        myProducer.async("springexam", "hi, ~~~~~");
    }


}