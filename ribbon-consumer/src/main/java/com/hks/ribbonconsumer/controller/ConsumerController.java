package com.hks.ribbonconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "/getUsers", method = RequestMethod.GET)
    public String getAllUsers() {
        return restTemplate.getForEntity("http://springboot/home",
            String.class).getBody();
    }
}
