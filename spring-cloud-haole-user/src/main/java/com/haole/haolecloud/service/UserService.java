package com.haole.haolecloud.service;

import com.haole.haolecloud.dto.User;

import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/12.
 */
public interface UserService {

    User addUser(String userName);

    List<User> findAll();
}
