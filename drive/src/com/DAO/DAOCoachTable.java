package com.DAO;

import com.entities.Coach;

import java.sql.*;
import java.util.ArrayList;

public class DAOCoachTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    //注册教练
    public boolean addCoach(Coach u){
        boolean flag=true;
        conn = DBConnection.getConnection();
        if(conn==null)return false;
        String sql="insert into TableCoach(CoAccount,CoPassword,CoPhone,CoName,CoID,CoSex,CoProvince,CoCity,CoPrice,CoInfo,CoWork) values(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            pst= conn.prepareStatement(sql);
            pst.setInt(1,u.getCoAccount());
            pst.setString(2,u.getCoPassword());
            pst.setString(3,u.getCoPhone());
            pst.setString(4,u.getCoName());
            pst.setString(5,u.getCoID());
            pst.setString(6,u.getCoSex());
            pst.setString(7,u.getCoProvince());
            pst.setString(8,u.getCoCity());
            pst.setDouble(9,u.getCoPrice());
            pst.setString(10,u.getCoInfo());
            pst.setInt(11,u.getCoWork());
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
    //检测教练是否存在
    public boolean isCoach(int CoAccount){
        boolean flag=true;
        Coach u=null;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        String sql="SELECT * FROM TableCoach WHERE CoAccount=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setInt(1, CoAccount);
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
    public boolean checkCoach(int CoAccount,String CoPassword){//判断登录是否成功
        boolean flag=true;
        Coach u=null;
        conn=DBConnection.getConnection();
        if(conn==null)
            return false;
        String sql="SELECT * FROM TableCoach WHERE CoAccount=? and CoPassword=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1,CoAccount);
            pst.setString(2,CoPassword);
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
    public ArrayList<Coach> ReturnCoach(int CoAccount){
        ArrayList<Coach> list=new ArrayList<>();
        conn=DBConnection.getConnection();
        if(conn==null)
            return list;
        String sql="SELECT * FROM TableCoach WHERE CoAccount=? ";
        try{
            pst=conn.prepareStatement(sql);
            pst.setInt(1, CoAccount);
            rs=pst.executeQuery();
            while(rs.next()){
                Coach row=new Coach(rs.getInt("CoAccount"),rs.getString("CoPassword"),
                        rs.getString("CoPhone"), rs.getString("CoName"),
                        rs.getString("CoID"),rs.getString("CoSex"),
                        rs.getString("CoProvince"),rs.getString("CoCity"),
                        rs.getDouble("CoPrice"),rs.getString("CoInfo"),
                        rs.getInt("CoWork"));
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
    public boolean updateCoach(Coach u){
        boolean flag=true;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        try {
            pst= conn.prepareStatement("update TableCoach set  CoPassword=?, CoPhone=? ,CoSex=? where CoAccount=? ");

            pst.setString(1,u.getCoPassword());
            pst.setString(2,u.getCoPhone());
            pst.setString(3,u.getCoSex());
            pst.setInt(4,u.getCoAccount());
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
    //返回教练列表
    public ArrayList<Coach> searchCoach() throws SQLException {
        ArrayList<Coach> list=new ArrayList<Coach>();
        conn = DBConnection.getConnection();
        String sql="select * from TableCoach where CoWork=1";
        pst= conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next())
        {
            Coach c=new Coach(
                    rs.getInt("CoAccount"),
                    rs.getString("CoPassword"),
                    rs.getString("CoPhone"),
                    rs.getString("CoName"),
                    rs.getString("CoID"),
                    rs.getString("CoSex"),
                    rs.getString("CoProvince"),
                    rs.getString("CoCity"),
                    rs.getDouble("CoPrice"),
                    rs.getString("CoInfo"),
                    rs.getInt("CoWork")
            );
            list.add((Coach)c);
        }
        rs.close();
        return list;
    }
    //返回教练信息
    public Coach getCoach(int CoAccount) throws SQLException {
        conn = DBConnection.getConnection();
        String sql="select * from TableCoach where CoAccount=?";
        assert conn != null;
        pst= conn.prepareStatement(sql);
        pst.setInt(1,CoAccount);
        rs = pst.executeQuery();
        Coach c = null;
        while(rs.next())
        {
            c=new Coach(
                    rs.getInt("CoAccount"),
                    rs.getString("CoPassword"),
                    rs.getString("CoPhone"),
                    rs.getString("CoName"),
                    rs.getString("CoID"),
                    rs.getString("CoSex"),
                    rs.getString("CoProvince"),
                    rs.getString("CoCity"),
                    rs.getDouble("CoPrice"),
                    rs.getString("CoInfo"),
                    rs.getInt("CoWork")
            );
        }
        rs.close();
        return c;
    }
}
