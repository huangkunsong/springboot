package com.hks.producer.event;


import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
@Configuration
public class StartEventListener {

    @EventListener({ApplicationStartingEvent.class})
    public void handlerStart(ApplicationEvent event) {
        System.out.println("-------------------------");
    }
}
