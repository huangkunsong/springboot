package com.hks.feign.controller;

import com.hks.feign.entity.UserVO;
import com.hks.feign.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/feign" , produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    Producer producer;

    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public List<UserVO> findUsers(@RequestParam("userIds") List<String> userIds){
        return producer.findUsers(userIds);
    }

}
