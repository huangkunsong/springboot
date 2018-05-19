package com.hks.ribbonconsumer.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "homeFallback")
    public String getUsers() {
        return restTemplate.getForEntity("http://springboot/home",
            String.class).getBody();
    }

    public String homeFallback(){
        return "获取服务失败";
    }
}
