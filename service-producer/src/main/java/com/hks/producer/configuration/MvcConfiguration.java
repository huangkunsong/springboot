package com.hks.producer.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {


    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    }
}
