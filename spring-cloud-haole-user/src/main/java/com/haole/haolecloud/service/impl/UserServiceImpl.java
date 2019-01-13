package com.haole.haolecloud.service.impl;

import com.haole.haolecloud.dto.User;
import com.haole.haolecloud.service.UserService;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/12.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CacheManager cacheManager;

    @Override
    public User addUser(String userName) {
        Cache<String, User> cache = getUserCache();
        User user = new User();
        user.setUserNo(User.generateUserNo());
        user.setUserName(userName);
        cache.put(user.getUserNo(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Cache<String, User> cache = getUserCache();
        cache.forEach((entry) -> list.add(entry.getValue()));
        return list;
    }


    private Cache<String, User> getUserCache() {
        return cacheManager.getCache("user", String.class, User.class);
    }
}
