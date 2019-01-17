package com.haole.haolecloud.dto;


import com.haole.haolecloud.constant.CardStatus;
import com.haole.haolecloud.constant.CardType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
public class CardAccount implements Serializable {

    private static AtomicLong id = new AtomicLong();

    private Long cardAccoundId;
    private String cardNo;
    private CardType cardType;
    private String accountNo;
    private String userNo;
    private String mainCardNo;
    private boolean primaryCard;
    /**
     * 卡网络号
     */
    private String cardNetId;
    /**
     * 启用日期
     */
    private Date cardSignedDate;
    /**
     * 过期日期
     */
    private Date cardExpiredDate;
    /**
     * 预分配余额
     */
    private BigDecimal assignBalance;
    /**
     * 卡账余额
     */
    private BigDecimal balance;
    /**
     * 购置费
     */
    private BigDecimal deposit;
    /**
     * 服务费
     */
    private BigDecimal serviceFee;
    /**
     * 保证金
     */
    private BigDecimal accountDeposit;

    private boolean bindingFlag;

    /**
     * 绑定车牌
     */
    private String bindPlateNumber;

    private CardStatus cardStatus;


    public static synchronized Long generateCardAccountId() {
        return id.getAndIncrement();
    }

    public Long getCardAccoundId() {
        return cardAccoundId;
    }

    public void setCardAccoundId(Long cardAccoundId) {
        this.cardAccoundId = cardAccoundId;
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

    public String getMainCardNo() {
        return mainCardNo;
    }

    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }

    public boolean isPrimaryCard() {
        return primaryCard;
    }

    public void setPrimaryCard(boolean primaryCard) {
        this.primaryCard = primaryCard;
    }

    public String getCardNetId() {
        return cardNetId;
    }

    public void setCardNetID(String cardNetId) {
        this.cardNetId = cardNetId;
    }

    public Date getCardSignedDate() {
        return cardSignedDate;
    }

    public void setCardSignedDate(Date cardSignedDate) {
        this.cardSignedDate = cardSignedDate;
    }

    public Date getCardExpiredDate() {
        return cardExpiredDate;
    }

    public void setCardExpiredDate(Date cardExpiredDate) {
        this.cardExpiredDate = cardExpiredDate;
    }

    public BigDecimal getAssignBalance() {
        return assignBalance;
    }

    public void setAssignBalance(BigDecimal assignBalance) {
        this.assignBalance = assignBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getAccountDeposit() {
        return accountDeposit;
    }

    public void setAccountDeposit(BigDecimal accountDeposit) {
        this.accountDeposit = accountDeposit;
    }

    public boolean isBindingFlag() {
        return bindingFlag;
    }

    public void setBindingFlag(boolean bindingFlag) {
        this.bindingFlag = bindingFlag;
    }

    public String getBindPlateNumber() {
        return bindPlateNumber;
    }

    public void setBindPlateNumber(String bindPlateNumber) {
        this.bindPlateNumber = bindPlateNumber;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
