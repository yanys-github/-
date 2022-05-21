package com.entities;

import java.math.BigDecimal;
import java.sql.Date;

public class Appointment {
    private int AppID;//预约单号
    private String UserAccount;//用户账户
    private int CoAccount;//教练账号
    private Date AppDate;//预约日期
    private boolean AppDate2;//预约时间
    private BigDecimal AppPrice;//总消费

    public Appointment() {
    }
    public Appointment(int AppID,String UserAccount,int CoAccount,Date AppDate,boolean AppDate2,BigDecimal AppPrice) {
        this.AppID=AppID;
        this.UserAccount=UserAccount;
        this.CoAccount=CoAccount;
        this.AppDate=AppDate;
        this.AppDate2=AppDate2;
        this.AppPrice=AppPrice;
    }
    public Appointment(int CoAccount,Date AppDate,boolean AppDate2){
        this.CoAccount=CoAccount;
        this.AppDate=AppDate;
        this.AppDate2=AppDate2;
    }

    public Appointment(int CoAccount, String UserAccount, Date AppDate,boolean AppDate2) {
        this.CoAccount=CoAccount;
        this.UserAccount=UserAccount;
        this.AppDate=AppDate;
        this.AppDate2=AppDate2;
    }

    public int getAppID() {
        return AppID;
    }

    public void setAppID(int appID) {
        AppID = appID;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public int getCoAccount() {
        return CoAccount;
    }

    public void setCoAccount(int coAccount) {
        CoAccount = coAccount;
    }

    public Date getAppDate() {
        return AppDate;
    }

    public void setAppDate(Date appDate) {
        AppDate = appDate;
    }

    public boolean isAppDate2() {
        return AppDate2;
    }

    public void setAppDate2(boolean appDate2) {
        AppDate2 = appDate2;
    }

    public BigDecimal getAppPrice() {
        return AppPrice;
    }

    public void setAppPrice(BigDecimal appPrice) {
        AppPrice = appPrice;
    }
}
