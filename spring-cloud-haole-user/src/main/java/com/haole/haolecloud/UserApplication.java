package com.haole.haolecloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/6
 */
@SpringBootApplication(scanBasePackages = {"com.haole.haolecloud"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.haole.haolecloud.stub")
public class UserApplication {
    private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


}
