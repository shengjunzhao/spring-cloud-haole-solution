package com.haole.haolecloud.constant;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
public enum AccountType {

    /**
     * 储值
     */
    PrePaid(22,"储值"),
    /**
     * 记账
     */
    Charge(23,"记账");

    private int code;
    private String name;

    private AccountType(int code, String name) {
        this.code=code;
        this.name=name;
    }

    public static AccountType getAccountTypeByCode(int code) {
        for (AccountType status : AccountType.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
