package com.haole.haolecloud.dto;

import com.haole.haolecloud.constant.CardType;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
public class Card implements Serializable {

    private static final long serialVersionUID = -561049086389297290L;

    private static final String prefix = "1903";
    private static AtomicInteger id = new AtomicInteger();

    private String owner = "1101";
    private String cardNo;
    private CardType cardType;
    private String accountNo;
    private String userNo;

    public static synchronized String generateUserNo(CardType cardType) {
        String str = "00000000";
        str += id.incrementAndGet();
        return prefix + cardType.getCode() + str.substring(str.length() - 8, str.length());
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
