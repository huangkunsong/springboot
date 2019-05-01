package com.hks.consumer.amqpRecevice;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

@EnableBinding(TestMQ.class)
public class TestMQListener {

    @StreamListener(TestMQ.INPUT)
    public void process(Message message, @Headers Map<String, Object> headers) {
        System.out.println(message.getPayload());
        System.out.println(headers);
    }
}
