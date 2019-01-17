package com.haole.haolecloud.service.impl;

import com.haole.haolecloud.constant.AccountType;
import com.haole.haolecloud.constant.DepositType;
import com.haole.haolecloud.constant.IssueStatus;
import com.haole.haolecloud.dto.Account;
import com.haole.haolecloud.dto.CardAccount;
import com.haole.haolecloud.service.AccountService;
import com.haole.haolecloud.stub.CardStubService;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CardStubService cardStubService;

    @Override
    public List<Account> findAccountByUser(String userNo) {
        List<Account> list = new ArrayList<>();
        Cache<String, Account> accountCache = getAccountCache();
        accountCache.forEach((entry) -> {
            if (userNo.equals(entry.getValue().getUserNo())) {
                list.add(entry.getValue());
            }
        });
        return list;
    }

    @Override
    public Account addAccount(String userNo, AccountType accountType, DepositType depositType) {
        Cache<String, Account> accountCache = getAccountCache();
        Account account = new Account();
        account.setAccountNo(Account.generateUserNo());
        account.setUserNo(userNo);
        account.setAccountType(accountType);
        account.setDepositType(depositType);
        account.setBalance(BigDecimal.ZERO);
        account.setPreassignBalance(BigDecimal.ZERO);
        account.setServiceFeeBalance(BigDecimal.ZERO);
        account.setCreditMoney(BigDecimal.ZERO);
        account.setLowMoney(BigDecimal.ZERO);
        account.setIssueStatus(IssueStatus.PrePaid);
        accountCache.put(account.getAccountNo(), account);
        return account;
    }

    @Override
    public Account updateMainCard(String accountNo, String mainCardNo) {
        Cache<String, Account> accountCache = getAccountCache();
        Account account = accountCache.get(accountNo);
        account.setMainCardNo(mainCardNo);
        accountCache.put(account.getAccountNo(), account);
        return account;
    }

    @Override
    public Account updateAccountBalance(String accountNo, BigDecimal amount) {
        Cache<String, Account> accountCache = getAccountCache();
        Account account = accountCache.get(accountNo);
        account.setBalance(account.getBalance().add(amount));
        accountCache.put(account.getAccountNo(), account);
        return account;
    }

    @Override
    public CardAccount addCardAccount(String userNo, String accountNo, String cardNetNo, String cardNo, Integer cardType, String bindPlateNumber) {
        return cardStubService.addCardAccount(userNo, accountNo, cardNetNo, cardNo, cardType, bindPlateNumber);
    }

    private Cache<String, Account> getAccountCache() {
        return cacheManager.getCache("account", String.class, Account.class);
    }
}
