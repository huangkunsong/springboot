package com.hks.ribbonconsumer.controller;

import com.hks.ribbonconsumer.entity.UserVO;
import com.hks.ribbonconsumer.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;

@RestController
public class ConsumerController {

    @Autowired
    HomeService homeService;

    @RequestMapping(path = "/getUsers", method = RequestMethod.GET)
    public String getAllUsers() {
        System.out.println(ManagementFactory.getThreadMXBean().getThreadCount());
        return homeService.getUsers();
    }

    @RequestMapping(path = "/getUserByUserName/{userName}")
    public UserVO getUserByUserName(@PathVariable String userName) {
        return homeService.getUserByUserName(userName);
    }

}
