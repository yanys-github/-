package com.DAO;

import java.sql.*;

final public class DBConnection {
    final private static String url="jdbc:mysql://cdb-6rbzo9j6.bj.tencentcdb.com:10238/Practice?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    final private static String user="root";
    final private static String pass="xiao1999";
    final private  static String driverName ="com.mysql.cj.jdbc.Driver";
    private static Connection connection;
    static {
        try {
            Class.forName(driverName);
            System.out.printf("JDBC1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            Connection conn= DriverManager.getConnection(url,user,pass);
            System.out.println("数据库连接成功");
            return conn;
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
            return null;
        }
    }
    public static void close(Connection conn, Statement stm, ResultSet rs){
        try {
            if(rs!=null)
                rs.close();
            if(stm!=null)
                stm.close();
            if(conn!=null){
                conn.close();
                System.out.println("数据库连接成功释放");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
