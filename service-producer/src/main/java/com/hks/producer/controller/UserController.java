package com.hks.producer.controller;

import com.hks.producer.common.NotResultWrap;
import com.hks.producer.entity.UserVO;
import com.hks.producer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "用户账户操作API", description = "用户账户操作API")
@RestController
@RequestMapping(path = "/producer", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    DiscoveryClient client;

    @NotResultWrap
	@ApiOperation(value = "获取所有用户", notes = "根据用户获取所有")
    @RequestMapping(value = "/findUsers", method = RequestMethod.GET)
    public List<UserVO> findUsers(@RequestParam(name = "userIds", required = false) List<String> userIds){
        return userService.findUsersById(userIds);
    }

    @ApiOperation(value = "获取单个用户信息", notes = "获取单个用户信息")
    @RequestMapping(value = "/findUser/{userId}", method = RequestMethod.GET)
    public UserVO findUser(@PathVariable String userId){
	    //throw new NullPointerException();
        return userService.findUserById(userId);
    }
}