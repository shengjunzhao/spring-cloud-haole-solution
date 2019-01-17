package com.haole.haolecloud.service;

import com.haole.haolecloud.constant.AccountType;
import com.haole.haolecloud.constant.DepositType;
import com.haole.haolecloud.dto.Account;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/17
 */
public interface AccountService {

    List<Account> findAccountByUser(String userNo);
    Account addAccount(String userNo, AccountType accountType, DepositType depositType);
    Account updateMainCard(String accountNo,String mainCardNo);
    Account updateAccountBalance(String accountNo, BigDecimal amount);

}
