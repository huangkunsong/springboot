package com.hks.consumer.service;

import com.hks.consumer.entity.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand
    public List<UserVO> findUsersByIds(List<String> userIds) {
        String url = "http://producer/producer/findUsers?userIds={userIds}";
        Map<String, Object> param = new HashMap<>();
        param.put("userIds", userIds);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Map> entity = new HttpEntity(header);
        ParameterizedTypeReference<List<UserVO>> reference = new ParameterizedTypeReference<List<UserVO>>(){};
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            reference,
            param).getBody();
    }


    @HystrixCommand
    public UserVO findUserById(String userId) {
        return restTemplate.getForEntity(
            "http://service-producer/producer/findUser/{userId}",
            UserVO.class, userId).getBody();
    }

}
