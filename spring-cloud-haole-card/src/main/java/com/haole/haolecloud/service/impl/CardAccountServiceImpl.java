package com.haole.haolecloud.service.impl;

import com.haole.haolecloud.constant.CardStatus;
import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.CardAccount;
import com.haole.haolecloud.service.CardAccountService;
import org.apache.commons.lang.StringUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
@Service
public class CardAccountServiceImpl implements CardAccountService {

    private static final Logger log = LoggerFactory.getLogger(CardAccountServiceImpl.class);

    @Autowired
    private CacheManager cacheManager;

    @Override
    public CardAccount addCardAccount(String userNo, String accountNo, String cardNetNo, String cardNo, CardType cardType,
                                      Date cardSignedDate, Date cardExpiredDate, String bindPlateNumber) {
        Cache<String, CardAccount> cardAccountCache = getCardAccountCache();
        CardAccount cardAccount = new CardAccount();
        cardAccount.setCardAccoundId(CardAccount.generateCardAccountId());
        cardAccount.setCardNo(cardNo);
        cardAccount.setCardType(cardType);
        cardAccount.setUserNo(userNo);
        cardAccount.setAccountNo(accountNo);
        cardAccount.setCardNetID(cardNetNo);
        cardAccount.setCardSignedDate(cardSignedDate);
        cardAccount.setCardExpiredDate(cardExpiredDate);
        cardAccount.setAssignBalance(BigDecimal.ZERO);
        cardAccount.setBalance(BigDecimal.ZERO);
        cardAccount.setDeposit(BigDecimal.ZERO);
        cardAccount.setServiceFee(BigDecimal.ZERO);
        cardAccount.setAccountDeposit(BigDecimal.ZERO);
        if (StringUtils.isNotBlank(bindPlateNumber)) {
            cardAccount.setBindingFlag(true);
            cardAccount.setBindPlateNumber(bindPlateNumber);
        } else {
            cardAccount.setBindingFlag(false);
        }
        cardAccount.setCardStatus(CardStatus.Issue);
        cardAccountCache.put(getCacheKey(cardAccount.getAccountNo(), cardAccount.getCardNo()), cardAccount);
        return cardAccount;
    }

    @Override
    public List<CardAccount> findCardAccountByAccount(String accountNo) {
        Cache<String, CardAccount> cardAccountCache = getCardAccountCache();
        List<CardAccount> list = new ArrayList<>();
        cardAccountCache.forEach((entry) -> {
            if (accountNo.equals(entry.getValue())) {
                list.add(entry.getValue());
            }
        });
        return list;
    }

    @Override
    public CardAccount updateMainCardNo(String accountNo, String cardNo, String mainCardNo) {
        Cache<String, CardAccount> cardAccountCache = getCardAccountCache();
        CardAccount cardAccount = cardAccountCache.get(getCacheKey(accountNo, cardNo));
        if (StringUtils.isBlank(mainCardNo)) {
            cardAccount.setPrimaryCard(false);
            cardAccount.setMainCardNo(null);
        } else {
            cardAccount.setPrimaryCard(true);
            cardAccount.setMainCardNo(mainCardNo);
        }
        cardAccountCache.put(getCacheKey(accountNo, cardNo), cardAccount);
        return cardAccount;
    }

    @Override
    public CardAccount updateCardAccountBalance(String accountNo, String cardNo, BigDecimal amount) {
        Cache<String, CardAccount> cardAccountCache = getCardAccountCache();
        CardAccount cardAccount = cardAccountCache.get(getCacheKey(accountNo, cardNo));
        cardAccount.setBalance(cardAccount.getBalance().add(amount));
        cardAccountCache.put(getCacheKey(accountNo, cardNo), cardAccount);
        return cardAccount;
    }

    @Override
    public CardAccount updateCardAccountAssignBalance(String accountNo, String cardNo, BigDecimal amount) {
        Cache<String, CardAccount> cardAccountCache = getCardAccountCache();
        CardAccount cardAccount = cardAccountCache.get(getCacheKey(accountNo, cardNo));
        cardAccount.setAssignBalance(cardAccount.getAssignBalance().add(amount));
        cardAccountCache.put(getCacheKey(accountNo, cardNo), cardAccount);
        return cardAccount;
    }

    private Cache<String, CardAccount> getCardAccountCache() {
        return cacheManager.getCache("cardAccount", String.class, CardAccount.class);
    }

    private String getCacheKey(String accountNo, String cardNo) {
        return accountNo + "\u003A" + cardNo;
    }

}