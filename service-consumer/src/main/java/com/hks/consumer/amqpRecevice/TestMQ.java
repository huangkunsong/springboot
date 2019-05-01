package com.hks.consumer.amqpRecevice;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TestMQ {

    String INPUT = "SpringCloudTest";

    @Input(TestMQ.INPUT)
    SubscribableChannel output();
}
