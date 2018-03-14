package com.hks.app.dao;

import com.hks.app.entity.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface ITestDao {
    /**
     * @return
     */
    @Cacheable("sqlCache")
    int test();

    @Cacheable(value = "sqlCache", key = "#a0.id")
    List<User> findAllUser(User user);
}
