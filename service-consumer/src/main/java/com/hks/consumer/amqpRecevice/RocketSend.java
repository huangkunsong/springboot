package com.hks.consumer.amqpRecevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * output example
 */
@EnableBinding(Source.class)
public class RocketSend {

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel outputChannel;

    @Autowired
    @Output(Sink.INPUT)
    private MessageChannel inputChannel;

    public void sendOutputMessage() {
        outputChannel.send(MessageBuilder.withPayload("output输出").build());
    }

    public void sendInputMessage() {
        inputChannel.send(MessageBuilder.withPayload("消息输出")
            .setHeader("aaa", "bbbb").build());
    }
}
