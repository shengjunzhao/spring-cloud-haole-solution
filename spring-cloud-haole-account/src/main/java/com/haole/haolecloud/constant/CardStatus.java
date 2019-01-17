package com.haole.haolecloud.constant;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
public enum CardStatus {

    /**
     * 新购
     */
    New_Purchase(1, "新购"),
    /**
     * 报废
     */
    Scrap(2, "报废"),
    /**
     * 发行
     */
    Issue(3, "发行"),
    /**
     * 疑似坏卡
     */
    Doubtful_Bad_Card(4, "疑似坏卡"),
    /**
     * 挂失
     */
    Loss(5, "挂失"),
    /**
     * 黑名单
     */
    Back_List(6, "黑名单"),
    /**
     * 注销
     */
    Cancel(7, "注销"),
    /**
     * 回收
     */
    Recovery(8, "回收");

    private int code;
    private String name;

    private CardStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CardStatus getCardStatusByCode(int code) {
        for (CardStatus status : CardStatus.values()) {
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
