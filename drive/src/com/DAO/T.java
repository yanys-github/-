package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class T {
    public static void main(String[] args) {
        Connection connection=DBConnection.getConnection();
        Statement statement=null;
        ResultSet resultSet=null;
        int rowCount;
        try {
            statement=connection.createStatement();
            String sql="insert into TableUser(UserAccount,UserPassword,UserPhone,UserName,UserID,UserAmount)value('3170407001','123456','123456','程一','33111100011','10000')";
            rowCount=statement.executeUpdate(sql);
            System.out.println("插入所影响的行数为"+rowCount+"行");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(connection,statement,resultSet);
        }
    }
}
