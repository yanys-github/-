package com.entities;

public class Admin {
    private int AdminID;//账号
    private String AdminPassword;//密码

    public Admin() {
    }
    public Admin(int AdminID,String AdminPassword) {
        this.AdminID=AdminID;
        this.AdminPassword=AdminPassword;
    }

    public int getAdminID() {
        return AdminID;
    }

    public void setAdminID(int adminID) {
        AdminID = adminID;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }
}
