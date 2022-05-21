package com.entities;

public class Wrong {
    private String UserAccount;//用户账号
    private int Num;//题号
    private String WrongAnswer;//错误答案

    public Wrong() {
    }
    public Wrong(String UserAccount,int Num,String WrongAnswer) {
        this.UserAccount=UserAccount;
        this.Num=Num;
        this.WrongAnswer=WrongAnswer;
    }

    public String getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(String userAccount) {
        UserAccount = userAccount;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getWrongAnswer() {
        return WrongAnswer;
    }

    public void setWrongAnswer(String wrongAnswer) {
        WrongAnswer = wrongAnswer;
    }
}
