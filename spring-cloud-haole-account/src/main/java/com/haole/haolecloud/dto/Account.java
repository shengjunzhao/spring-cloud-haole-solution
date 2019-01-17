package com.haole.haolecloud.dto;

import com.haole.haolecloud.constant.AccountType;
import com.haole.haolecloud.constant.DepositType;
import com.haole.haolecloud.constant.IssueStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengjunzhao
 * @date 2019/1/17
 */
public class Account implements Serializable {

    private static final long serialVersionUID = 3975398295043711596L;

    private static final String prefix = "1101";
    private static AtomicInteger id = new AtomicInteger();

    private String accountNo;
    private String userNo;
    private AccountType accountType;
    private DepositType depositType;
    private String mainCardNo;
    private BigDecimal balance;
    private BigDecimal preassignBalance;
    private BigDecimal serviceFeeBalance;
    private BigDecimal creditMoney;
    private BigDecimal lowMoney;
    private IssueStatus issueStatus;


    public static synchronized String generateUserNo() {
        String str = "00000000";
        str += id.incrementAndGet();
        return prefix + str.substring(str.length() - 8, str.length());
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public String getMainCardNo() {
        return mainCardNo;
    }

    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getPreassignBalance() {
        return preassignBalance;
    }

    public void setPreassignBalance(BigDecimal preassignBalance) {
        this.preassignBalance = preassignBalance;
    }

    public BigDecimal getServiceFeeBalance() {
        return serviceFeeBalance;
    }

    public void setServiceFeeBalance(BigDecimal serviceFeeBalance) {
        this.serviceFeeBalance = serviceFeeBalance;
    }

    public BigDecimal getCreditMoney() {
        return creditMoney;
    }

    public void setCreditMoney(BigDecimal creditMoney) {
        this.creditMoney = creditMoney;
    }

    public BigDecimal getLowMoney() {
        return lowMoney;
    }

    public void setLowMoney(BigDecimal lowMoney) {
        this.lowMoney = lowMoney;
    }

    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(IssueStatus issueStatus) {
        this.issueStatus = issueStatus;
    }
}
