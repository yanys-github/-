package com.entities;

import java.math.BigDecimal;

public class User {
    private String UserAccount;//账号.
    private String UserPassword;//密码.
    private String UserPhone;//手机.
    private String UserName;//真实姓名
    private String UserID;//身份证号
    private double UserAmount;//账户余额

    public User(){

    }
    public User(String UserAccount,String UserPassword,String UserPhone,String UserName,String UserID,double UserAmount){
        this.UserAccount=UserAccount;
        this.UserPassword=UserPassword;
        this.UserPhone=UserPhone;
        this.UserName=UserName;
        this.UserID=UserID;
        this.UserAmount=UserAmount;
    }
    public User(String UserAccount,String UserPassword,String UserPhone)
    {
        this.UserAccount=UserAccount;
        this.UserPassword=UserPassword;
        this.UserPhone=UserPhone;
    }
    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public double getUserAmount() {
        return UserAmount;
    }

    public void setUserAmount(double userAmount) {
        UserAmount = userAmount;
    }
}