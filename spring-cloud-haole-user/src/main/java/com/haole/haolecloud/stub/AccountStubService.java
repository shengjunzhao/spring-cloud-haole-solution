package com.haole.haolecloud.stub;

import com.haole.haolecloud.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/18
 */
@FeignClient(name = "spring-cloud-haole-account")
public interface AccountStubService {

    @GetMapping("/account/add")
    Account addAccount(@RequestParam("userNo")String userNo, @RequestParam("accountType")Integer accountType,
                       @RequestParam("depositType") Integer depositType);
}
