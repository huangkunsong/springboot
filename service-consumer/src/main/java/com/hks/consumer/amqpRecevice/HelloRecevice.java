package com.hks.consumer.amqpRecevice;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloRecevice {

    @RabbitHandler
    public void process(byte[] message) {
        System.out.println(new String(message));
    }
}
