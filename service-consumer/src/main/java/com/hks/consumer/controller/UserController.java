package com.hks.consumer.controller;

import com.hks.consumer.entity.UserVO;
import com.hks.consumer.service.UserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/consumer" , produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    //@Value(value = "${info.a}")
    private String value;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public List<UserVO> findUsers(@RequestParam("userIds") List<String> userIds){
        return userService.findUsersByIds(userIds);
    }

    @RequestMapping(path = "/findUser/{userId}")
    public UserVO getUserByUserName(@PathVariable String userId) {
        return userService.findUserById(userId);
    }

    @RequestMapping(path = "/getValue")
    public String getValue() {
        return this.value;
    }

    @RequestMapping(path = "/sendMessage")
    public void sendMessage() {
        amqpTemplate.convertAndSend("hello", "hello world我");
    }
}
