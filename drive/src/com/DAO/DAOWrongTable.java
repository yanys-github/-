package com.DAO;

import com.entities.Problem;
import com.entities.Wrong;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOWrongTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    //增加错题
    public boolean addWrong(Wrong w){//增加错题
        boolean flag=true;
        conn = DBConnection.getConnection();
        if(conn==null)return false;
        String sql="insert into FormWrong(UserAccount,Num,WrongAnswer) values(?,?,?)";

        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1,w.getUserAccount());
            pst.setInt(2,w.getNum());
            pst.setString(3,w.getWrongAnswer());
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
    //检查存在相同的,账号和题号
    public boolean checkWrong(String UserAccount,int Num){
        boolean flag=true;
        Wrong u=null;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        String sql="SELECT * FROM FormWrong WHERE UserAccount=? and Num=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            pst.setInt(2, Num);
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
    //有相同错题记录更新
    public boolean updateWrong(Wrong w){
        boolean flag=true;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        try {
            pst= conn.prepareStatement("update FormWrong set WrongAnswer=? where UserAccount=? and Num=?");
            pst.setString(1,w.getWrongAnswer());
            pst.setString(2,w.getUserAccount());
            pst.setInt(3,w.getNum());
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
    //按学号查找错题
    public List<Problem> getPageByWrong(int pageNum, int pageSize, int Subj,String UserAccount){//当前页和每页行数
        List<Problem> list=new ArrayList<Problem>();
        conn = DBConnection.getConnection();
        if(conn==null)return list;
        String sql="SELECT FormWrong.Num,Problem,OptionA,OptionB,OptionC,OptionD,Answer,Note,Rank,Kno,Subj from FormWrong,FormProblem WHERE FormWrong.Num=FormProblem.Num and UserAccount=? and Subj=? limit ? , ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            pst.setInt(2, Subj);
            pst.setInt(3, (pageNum-1)*pageSize);
            pst.setInt(4, pageSize);
            rs = pst.executeQuery();
            while(rs.next()){
                Problem row=new Problem(rs.getInt("Num"),rs.getString("Problem"),
                        rs.getString("OptionA"),rs.getString("OptionB"),
                        rs.getString("OptionC"),rs.getString("OptionD"),
                        rs.getString("Answer"),rs.getString("Note"),
                        rs.getInt("Rank"),rs.getInt("Kno"),rs.getInt("Subj"));
                list.add(row);
            }

        } catch (SQLException e) {
            System.out.println("DAO层出错了");
            e.printStackTrace();
        } finally {
            DBConnection.close(conn, st, rs);
        }
        return list;

    }
    //获得当前用户错题数
    public int getWrongNum(int Subj,String UserAccount){
        int count=0;
        conn=DBConnection.getConnection();
        if(conn==null)return count;
        String sql="select count(*) from FormWrong,FormProblem WHERE FormWrong.Num=FormProblem.Num and UserAccount=? and Subj=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, UserAccount);
            pst.setInt(2, Subj);
            rs=pst.executeQuery();
            if(rs.next()){
                count=rs.getInt(1);
                System.out.println("count:"+count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(conn,pst,rs);
        }
        return count;
    }
    //删除错题
    public boolean deleteWrong(int Num,String UserAccount){
        boolean flag=true;
        conn = DBConnection.getConnection();
        if(conn==null)return false;
        String sql="delete from FormWrong where UserAccount=? and Num=?";
        try {
            pst= conn.prepareStatement(sql);
            pst.setString(1,UserAccount);
            pst.setInt(2,Num);
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
}
