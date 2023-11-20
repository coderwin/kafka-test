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


}