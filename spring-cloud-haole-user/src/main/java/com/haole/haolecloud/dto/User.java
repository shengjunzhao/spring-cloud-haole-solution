package com.haole.haolecloud.dto;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author shengjunzhao
 * @date 2019/1/12
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1626718167226945732L;
    private static final String prefix = "1101";
    private static AtomicInteger id = new AtomicInteger();

    private String userNo;
    private String userName;

    public static synchronized String generateUserNo() {
        String str = "00000000";
        str += id.incrementAndGet();
        return prefix + str.substring(str.length() - 8, str.length());
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public static void main(String[] args) {
//        String str = "00000000";
//        str+=id.incrementAndGet();
//        System.out.println(str.substring(str.length()-8,str.length()));
//    }
}
