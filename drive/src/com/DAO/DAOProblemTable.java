package com.DAO;

import com.controller.Problem.KnoProblemList;
import com.entities.Problem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOProblemTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    //查找全部
    public ArrayList<Problem> getProblemAll(){
     ArrayList<Problem> list=new ArrayList<Problem>();
     conn=DBConnection.getConnection();
     if(conn==null)return list;
     String sql="select * from FormProblem";
     try {
         pst=conn.prepareStatement(sql);
         rs=pst.executeQuery();
         while(rs.next()){
             Problem row=new Problem(rs.getInt("Num"),rs.getString("Problem"),
                     rs.getString("OptionA"),rs.getString("OptionB"),
                     rs.getString("OptionC"),rs.getString("OptionD"),
                     rs.getString("Answer"),rs.getString("Note"),
                     rs.getInt("Rank"),rs.getInt("Kno"),rs.getInt("Subj"));
             list.add(row);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }finally {
         DBConnection.close(conn,pst,rs);
     }
     return list;
 }
 //分页查找全部
    public List<Problem> getPageByProblem(int pageNum,int pageSize,int Subj){//当前页和每页行数
        List<Problem> list=new ArrayList<Problem>();
        conn = DBConnection.getConnection();
        if(conn==null)return list;
        String sql="select * from FormProblem where Subj=? limit ? , ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Subj);
            pst.setInt(2, (pageNum-1)*pageSize);
            pst.setInt(3, pageSize);
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
    //分页查找根据Kno专项类别
    public List<Problem> getPageByProblemKno(int pageNum,int pageSize,int Kno){//当前页和每页行数+Kno专项练习
        List<Problem> list=new ArrayList<Problem>();
        conn = DBConnection.getConnection();
        if(conn==null)return list;
        String sql="select * from FormProblem where Kno=? limit ? , ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Kno);
            pst.setInt(2, (pageNum-1)*pageSize);
            pst.setInt(3, pageSize);
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
    //分页查找根据Rank难度
    public List<Problem> getPageByProblemRank(int pageNum,int pageSize,int Rank,int Subj){//当前页和每页行数+Kno专项练习
        List<Problem> list=new ArrayList<Problem>();
        conn = DBConnection.getConnection();
        if(conn==null)return list;
        String sql="select * from FormProblem where Rank=? and Subj=? limit ? , ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Rank);
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
    //查询数据总数
    public int getAllNum(int Subj){
        int count=0;
        conn=DBConnection.getConnection();
        if(conn==null)return count;
        String sql="select count(*) from FormProblem where Subj=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Subj);
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
    //查询Kno专题练习总数
    public int getKnoNum(int Kno){
        int count=0;
        conn=DBConnection.getConnection();
        if(conn==null)return count;
        String sql="select count(*) from FormProblem where Kno=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Kno);
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
    //查询Rank难度练习总数
    public int getRankNum(int Rank,int Subj){
        int count=0;
        conn=DBConnection.getConnection();
        if(conn==null)return count;
        String sql="select count(*) from FormProblem where Rank=? and Subj=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Rank);
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
    //生成试卷随机
    public List<Problem> getTestPage(int pageSize,int Subj){
        List<Problem> list=new ArrayList<Problem>();
        conn = DBConnection.getConnection();
        if(conn==null)return list;
        String sql="select * from FormProblem where Subj=? order by rand() limit ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setInt(1, Subj);
            pst.setInt(2, pageSize);
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
}
