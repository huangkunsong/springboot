package com.hks.consumer.amqpRecevice;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class StreamLisener {

    @StreamListener(Sink.INPUT)
    public void process(Object payload) {
        System.out.println(payload);
    }
}
