package com.haole.haolecloud.constant;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/17
 */
public enum DepositType {

    /**
     * 预付费
     */
    PrePaid(0,"预付费"),
    /**
     * 后付费
     */
    Charge(1,"后付费");

    private int code;
    private String name;

    private DepositType(int code, String name) {
        this.code=code;
        this.name=name;
    }

    public static DepositType getDepositTypeByCode(int code) {
        for (DepositType status : DepositType.values()) {
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
