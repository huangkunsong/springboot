package com.hks.producer.dao;

import com.hks.producer.entity.UserVO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ITestDao {
    /**
     * @return
     */
    @Cacheable("sqlCache")
    int test123();

    @Cacheable(value = "sqlCache", key = "#a0.id")
    List<UserVO> findAllUser(UserVO user);
}
