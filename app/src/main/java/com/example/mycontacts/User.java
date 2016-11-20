package com.example.mycontacts;

/**
 * Created by 茹丽盈 on 2016/10/24.
 */

public class User {
    public final static String NAME="name";
    public final static String MOBILE="mobile";
    public final static String DANWEI="danwei";
    public final static String QQ="qq";
    public final static String ADDRESS="address";

    private String name;
    private String mobile;
    private String danwei;
    private String qq;
    private String address;
    private int id_DB=-1;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public int getId_DB() {
        return id_DB;
    }

    public void setId_DB(int id_DB) {
        this.id_DB = id_DB;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
