package com.haole.haolecloud.controller;

import com.haole.haolecloud.constant.AccountType;
import com.haole.haolecloud.constant.DepositType;
import com.haole.haolecloud.dto.Account;
import com.haole.haolecloud.dto.CardAccount;
import com.haole.haolecloud.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
@RestController
@RequestMapping("account")
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @GetMapping("/user")
    public List<Account> findAccountByUser(String userNo) {
        return accountService.findAccountByUser(userNo);
    }

    @GetMapping("add")
    public Account addAccount(String userNo, Integer accountType, Integer depositType) {
        AccountType at = AccountType.getAccountTypeByCode(accountType);
        DepositType dt = DepositType.getDepositTypeByCode(depositType);
        return accountService.addAccount(userNo, at, dt);
    }

    @GetMapping("/cardAccount/add")
    public CardAccount addCardAccount(String userNo, String accountNo, String cardNetNo, String cardNo, Integer cardType,
                                      String bindPlateNumber) {
        return accountService.addCardAccount(userNo, accountNo, cardNetNo, cardNo, cardType, bindPlateNumber);
    }


}
