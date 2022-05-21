package com.services;

import com.DAO.DAOUserTable;
import com.entities.User;

import java.util.ArrayList;

public class UserManagement {
    //判断用户登录成功
    public static boolean checkUser(String UserAccount,String UserPassword){
        DAOUserTable dao=new DAOUserTable();
        return dao.checkUser(UserAccount,UserPassword);
    }
    //注册用户
    public static boolean addUser(User u){
        DAOUserTable dao=new DAOUserTable();
        return dao.addUser(u);
    }
    //检查用户是否存在
    public static boolean isUser(String UserAccount){
        DAOUserTable dao=new DAOUserTable();
        return dao.isUser(UserAccount);
    }

    public static ArrayList<User> ReturnUser(String UserAccount){
        DAOUserTable dao=new DAOUserTable();
        return dao.ReturnUser(UserAccount);
    }
    public static boolean updateUser(User u){
        DAOUserTable dao=new DAOUserTable();
        return dao.updateUser(u);
    }
}
