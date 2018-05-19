package com.hks.ribbonconsumer.services;

import com.hks.ribbonconsumer.entity.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "homeFallback")
    public String getUsers() {
        return restTemplate.getForEntity("http://springboot/home",
            String.class).getBody();
    }

    @HystrixCommand
    public List<UserVO> getUsersByUserNames(List<String> userNames){
        System.out.println(userNames);
        return userNames.stream().map(
            s -> {
                UserVO userVO = new UserVO();
                userVO.setUserName("aaa" + s);
                return userVO;
            }
        ).collect(Collectors.toList());
    }

    /**
     * Scope:
     * REQUEST范围只对一个request请求内的多次服务请求进行合并，
     * GLOBAL是多单个应用中的所有线程的请求中的多次服务请求进行合并。
     * @param userName
     * @return
     */
    @HystrixCollapser(batchMethod = "getUsersByUserNames",
        scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL)
    public UserVO getUserByUserName(String userName) {
        System.out.println(userName);
        UserVO userVO = new UserVO();
        userVO.setUserName(userName);
        return userVO;
    }

    public String homeFallback(){
        return "获取服务失败";
    }
}
