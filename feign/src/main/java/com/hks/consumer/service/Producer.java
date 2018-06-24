package com.hks.consumer.service;

import com.hks.consumer.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-producer")
public interface Producer {

    @RequestMapping(path = "/producer/findUsers", method = RequestMethod.GET)
    List<UserVO> findUsers(@RequestParam("userIds") List<String> userIds);
}
