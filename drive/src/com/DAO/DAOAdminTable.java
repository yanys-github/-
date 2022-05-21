package com.DAO;

import com.entities.Admin;
import java.sql.*;
public class DAOAdminTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    public boolean checkAdmin(String AdminID,String AdminPassword){//判断登录是否成功
        boolean flag=true;
        Admin u=null;
        conn=DBConnection.getConnection();
        if(conn==null)
            return false;
        String sql="SELECT * FROM TableAdmin WHERE AdminID=? and AdminPassword=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,AdminID);
            pst.setString(2,AdminPassword);
            rs=pst.executeQuery();
            if(!rs.next())
                flag=false;
        } catch(SQLException e)
        {
            e.printStackTrace();
            flag=false;

        }finally {
            DBConnection.close(conn, pst, rs);
        }
        return  flag;
    }
}
