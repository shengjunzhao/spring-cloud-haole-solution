package com.haole.haoleCloud.service.controller;

import com.haole.haoleCloud.dto.User;
import com.haole.haoleCloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public User addUser(String userName) {
        return userService.addUser(userName);
    }

    @RequestMapping("list")
    public List<User> list() {
        return userService.findAll();
    }


}
