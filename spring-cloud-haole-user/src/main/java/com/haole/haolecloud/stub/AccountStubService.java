package com.haole.haolecloud.stub;

import com.haole.haolecloud.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/18
 */
@FeignClient(name = "spring-cloud-haole-account")
public interface AccountStubService {

    @GetMapping("/account/add")
    Account addAccount(String userNo, Integer accountType, Integer depositType);
}
