package com.haole.haolecloud.constant;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
public enum CardType {

    /**
     * 储值卡
     */
    Purse(22,"储值卡"),
    /**
     * 记账卡
     */
    Deposit(23,"记账卡");

    private int code;
    private String name;

    private CardType(int code, String name) {
        this.code=code;
        this.name=name;
    }

    public static CardType getCardTypeByCode(int code) {
        for (CardType status : CardType.values()) {
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
