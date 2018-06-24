package com.hks.producer.service;

import com.hks.producer.dao.ITestDao;
import com.hks.producer.entity.UserVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    ITestDao iTestDao;

    @HystrixCommand
    public List<UserVO> findUsersById(List<String> userId) {
        return iTestDao.findAllUser(new UserVO());
    }

    /**
     * Scope:
     * REQUEST范围只对一个request请求内的多次服务请求进行合并，
     * GLOBAL是多单个应用中的所有线程的请求中的多次服务请求进行合并。
     * @param userId
     * @return
     */
    @HystrixCollapser(batchMethod = "findUsersById",
        scope = com.netflix.hystrix.HystrixCollapser.Scope.GLOBAL)
    public UserVO findUserById(String userId) {
        return null;
    }
}
