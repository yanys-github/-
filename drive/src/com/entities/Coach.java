package com.entities;

import java.math.BigDecimal;

public class Coach {
    private int CoAccount;//账号。//自动排序100
    private String CoPassword;//密码。
    private String CoPhone;//手机。
    private String CoName;//真实姓名。
    private String CoID;//身份证号。
    private String CoSex;//性别。
    private String CoProvince;//所在省。
    private String CoCity;//所在市。
    private double CoPrice;//可是价格。
    private String CoInfo;//教练信息
    private int CoWork;//是否工作

    public Coach() {
    }
    public Coach(int CoAccount,String CoPassword,String CoPhone,String CoName,String CoID,String CoSex,String CoProvince,String CoCity,double CoPrice,String CoInfo,int CoWork) {
        this.CoAccount=CoAccount;
        this.CoPassword=CoPassword;
        this.CoPhone=CoPhone;
        this.CoName=CoName;
        this.CoID=CoID;
        this.CoSex=CoSex;
        this.CoProvince=CoProvince;
        this.CoCity=CoCity;
        this.CoPrice=CoPrice;
        this.CoInfo=CoInfo;
        this.CoWork=CoWork;
    }
    public Coach(int CoAccount,String CoPassword,String CoPhone,String CoSex)
    {
        this.CoAccount=CoAccount;
        this.CoPassword=CoPassword;
        this.CoPhone=CoPhone;
        this.CoSex=CoSex;
    }
    public int getCoAccount() {
        return CoAccount;
    }

    public void setCoAccount(int coAccount) {
        CoAccount = coAccount;
    }

    public String getCoPassword() {
        return CoPassword;
    }

    public void setCoPassword(String coPassword) {
        CoPassword = coPassword;
    }

    public String getCoPhone() {
        return CoPhone;
    }

    public void setCoPhone(String coPhone) {
        CoPhone = coPhone;
    }

    public String getCoName() {
        return CoName;
    }

    public void setCoName(String coName) {
        CoName = coName;
    }

    public String getCoID() {
        return CoID;
    }

    public void setCoID(String coID) {
        CoID = coID;
    }

    public String getCoSex() {
        return CoSex;
    }

    public void setCoSex(String coSex) {
        CoSex = coSex;
    }

    public String getCoProvince() {
        return CoProvince;
    }

    public void setCoProvince(String coProvince) {
        CoProvince = coProvince;
    }

    public String getCoCity() {
        return CoCity;
    }

    public void setCoCity(String coCity) {
        CoCity = coCity;
    }

    public double getCoPrice() {
        return CoPrice;
    }

    public void setCoPrice(double coPrice) {
        CoPrice = coPrice;
    }

    public String getCoInfo() {
        return CoInfo;
    }

    public void setCoInfo(String coInfo) {
        CoInfo = coInfo;
    }

    public int getCoWork() {
        return CoWork;
    }

    public void setCoWork(int coWork) {
        CoWork = coWork;
    }
}
