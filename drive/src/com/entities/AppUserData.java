package com.entities;

import java.sql.Date;

public class AppUserData {
    private int AppID;//预约单号
    private int CoAccount;//教练账号
    private String CoName;//教练姓名
    private String AppDate;//预约日期
    private boolean AppDate2;//预约时间判断
    private String AppDate3;//预约时间
    public AppUserData(){}
    public AppUserData(int AppID,int CoAccount,String CoName,String AppDate,boolean AppDate2)
    {
        this.AppID=AppID;
        this.CoAccount=CoAccount;
        this.CoName=CoName;
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

    public String getCoName() {
        return CoName;
    }

    public int getCoAccount() {
        return CoAccount;
    }

    public String getAppDate() {
        return AppDate;
    }

    public boolean isAppDate2() {
        return AppDate2;
    }

    public String getAppDate3() {
        return AppDate3;
    }
}
