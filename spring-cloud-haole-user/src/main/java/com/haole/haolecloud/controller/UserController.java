package com.haole.haolecloud.controller;

import com.haole.haolecloud.dto.Account;
import com.haole.haolecloud.dto.User;
import com.haole.haolecloud.service.UserService;
import com.haole.haolecloud.stub.AccountStubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private AccountStubService accountStubService;

    @RequestMapping("add")
    public User addUser(String userName) {
        return userService.addUser(userName);
    }

    @RequestMapping("list")
    public List<User> list() {
        return userService.findAll();
    }


    @GetMapping("/account/add")
    public Account addAccount(String userNo, Integer accountType, Integer depositType) {
        return accountStubService.addAccount(userNo,accountType,depositType);
    }



}
