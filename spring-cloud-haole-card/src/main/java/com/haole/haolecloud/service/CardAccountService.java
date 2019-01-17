package com.haole.haolecloud.service;

import com.haole.haolecloud.constant.CardType;
import com.haole.haolecloud.dto.CardAccount;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
public interface CardAccountService {

    CardAccount addCardAccount(String userNo, String accountNo, String cardNetNo, String cardNo, CardType cardType,
                               Date cardSignedDate, Date cardExpiredDate, String bindPlateNumber);

    List<CardAccount> findCardAccountByAccount(String accountNo);

    CardAccount updateMainCardNo(String accountNo, String cardNo, String mainCardNo);

    CardAccount updateCardAccountBalance(String accountNo, String cardNo, BigDecimal amount);

    CardAccount updateCardAccountAssignBalance(String accountNo, String cardNo, BigDecimal amount);


}
