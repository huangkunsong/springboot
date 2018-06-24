package com.hks.consumer.controller;

import com.hks.consumer.entity.UserVO;
import com.hks.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/consumer" , produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

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

}
