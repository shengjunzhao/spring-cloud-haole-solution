package com.haole.haolecloud.stub;

import com.haole.haolecloud.dto.CardAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
@FeignClient(name = "spring-cloud-haole-card")
public interface CardStubService {


    @GetMapping("/cardAccount/add")
    CardAccount addCardAccount(@RequestParam("userNo") String userNo, @RequestParam("accountNo") String accountNo,
                               @RequestParam("cardNetNo") String cardNetNo, @RequestParam("cardNo") String cardNo,
                               @RequestParam("cardType") Integer cardType, @RequestParam("bindPlateNumber") String bindPlateNumber);


}
