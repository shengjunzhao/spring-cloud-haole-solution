package com.haole.haoleCloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by shengjunzhao on 2019/1/6.
 */
@SpringBootApplication
public class AccountApplication {
    private static final Logger logger = LoggerFactory.getLogger(AccountApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
