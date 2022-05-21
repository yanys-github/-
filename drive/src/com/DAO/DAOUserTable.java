package com.DAO;

import com.entities.User;

import java.sql.*;
import java.util.ArrayList;

public class DAOUserTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    //判断用户登录是否成功
  
    //注册用户
    public boolean addUser(User u){//增加学生信息
        boolean flag=true;
        conn = DBConnection.getConnection();
        if(conn==null)return false;
        String sql="insert into TableUser(UserAccount,UserPassword,UserPhone,UserName,UserID,UserAmount) values(?,?,?,?,?,?)";

        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1,u.getUserAccount());
            pst.setString(2,u.getUserPassword());
            pst.setString(3,u.getUserPhone());
            pst.setString(4,u.getUserName());
            pst.setString(5,u.getUserID());
            pst.setDouble(6,u.getUserAmount());
            pst.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            DBConnection.close(conn, pst, rs);
        }
        return flag;

    }
    //检查是否存在用户
    public boolean isUser(String UserAccount){
        boolean flag=true;
        User u=null;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        String sql="SELECT * FROM TableUser WHERE UserAccount=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            rs = pst.executeQuery();
            if(!rs.next()) flag=false;
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            DBConnection.close(conn, pst, rs);
        }
        return flag;
    }
    public boolean checkUser(String UserAccount,String UserPassword){//判断登录是否成功
        boolean flag=true;
        User u=null;
        conn =DBConnection.getConnection();
        if(conn==null)
            return false;
        String sql="SELECT * FROM TableUser WHERE UserAccount=? and UserPassword=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            pst.setString(2, UserPassword);
            rs = pst.executeQuery();
            if(!rs.next()) flag=false;
        } catch (SQLException e) {
            e.printStackTrace();
            flag=false;
        } finally {
            DBConnection.close(conn, pst, rs);
        }
        return flag;


    }
    public ArrayList<User> ReturnUser(String UserAccount){
        ArrayList<User> list=new ArrayList<>();
        conn=DBConnection.getConnection();
        if(conn==null)
            return list;
        String sql="SELECT * FROM TableUser WHERE UserAccount=? ";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            rs=pst.executeQuery();
            while(rs.next()){
                User row=new User(rs.getString("UserAccount"),rs.getString("UserPassword"),
                        rs.getString("UserPhone"), rs.getString("UserName"),
                        rs.getString("UserID"),rs.getDouble("UserAmount"));
                list.add(row);
            }


        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            DBConnection.close(conn,pst,rs);
        }
        return list;
    }
    public boolean updateUser(User u){
        boolean flag=true;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        try {
            pst= conn.prepareStatement("update TableUser set  UserPassword=?, UserPhone=? where UserAccount=? ");

            pst.setString(1,u.getUserPassword());
            pst.setString(2,u.getUserPhone());
            pst.setString(3,u.getUserAccount());
            pst.executeUpdate();
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            flag=false;
        } finally {
            DBConnection.close(conn, pst, rs);
        }
        return flag;
    }
}
