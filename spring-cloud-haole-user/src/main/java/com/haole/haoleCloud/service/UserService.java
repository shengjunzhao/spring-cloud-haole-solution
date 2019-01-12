package com.haole.haoleCloud.service;

import com.haole.haoleCloud.dto.User;

import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/12.
 */
public interface UserService {

    User addUser(String userName);

    List<User> findAll();
}
