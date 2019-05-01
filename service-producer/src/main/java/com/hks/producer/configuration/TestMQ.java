package com.hks.producer.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestMQ {

    String OUTPUT = "SpringCloudTest";

    @Output(TestMQ.OUTPUT)
    MessageChannel output();

}
