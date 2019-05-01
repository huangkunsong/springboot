package com.hks.producer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * output example
 */
@EnableBinding(TestMQ.class)
public class RocketSend {

    @Autowired
    @Output(TestMQ.OUTPUT)
    private MessageChannel testMQChannel;

    public void sendOutputMessage() {
        testMQChannel.send(MessageBuilder.withPayload("output输出").build());
    }

}
