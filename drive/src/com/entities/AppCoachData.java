package com.entities;

public class AppCoachData {
    private int AppID;//预约单号
    private String UserAccount;
    private String UserName;
    private String AppDate;//预约日期
    private boolean AppDate2;//预约时间判断
    private String AppDate3;//预约时间
    public AppCoachData(){}
    public AppCoachData(int AppID,String UserAccount,String UserName,String AppDate,boolean AppDate2)
    {
        this.AppID=AppID;
        this.UserAccount=UserAccount;
        this.UserName=UserName;
        this.AppDate=AppDate;
        this.AppDate2=AppDate2;
        if(AppDate2==true)
            AppDate3 ="上午";
        else
            AppDate3 ="下午";
    }

    public int getAppID() {
        return AppID;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public String getAppDate() {
        return AppDate;
    }

    public String getAppDate3() {
        return AppDate3;
    }

    public String getUserName() {
        return UserName;
    }

    public boolean isAppDate2() {
        return AppDate2;
    }
}
