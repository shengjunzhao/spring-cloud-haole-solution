package com.haole.haolecloud.constant;

/**
 * Created by shengjunzhao on 2019/1/17.
 */
public enum IssueStatus {

    /**
     * 正常
     */
    PrePaid(0,"正常"),
    /**
     * 低值
     */
    Charge(1,"低值"),
    /**
     * 透支
     */
    Overdraft(2,"透支");

    private int code;
    private String name;

    private IssueStatus(int code, String name) {
        this.code=code;
        this.name=name;
    }

    public static IssueStatus getIssueStatusByCode(int code) {
        for (IssueStatus status : IssueStatus.values()) {
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
