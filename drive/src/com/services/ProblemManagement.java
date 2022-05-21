package com.services;

import com.DAO.DAOProblemTable;
import com.entities.Problem;

import java.util.ArrayList;
import java.util.List;

public class ProblemManagement {
    //一次性获取全部数据
    public static ArrayList<Problem> getProblemAll(){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getProblemAll();
    }
    //分页获取全部数据+顺序练习
    public static List<Problem> getPageByProblem(int pageNum,int pageSize,int Subj){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getPageByProblem(pageNum,pageSize,Subj);
    }
    //分页根据Kno获取数据+专项练习
    public static List<Problem> getPageByProblemKno(int pageNum,int pageSize,int Kno){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getPageByProblemKno(pageNum,pageSize,Kno);
    }
    //分页根据Rank获取数据+难度练习
    public static List<Problem> getPageByProblemRank(int pageNum,int pageSize,int Rank,int Subj){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getPageByProblemRank(pageNum,pageSize,Rank,Subj);
    }
    //查询数据总数
    public static int getAllNum(int Subj){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getAllNum(Subj);
    }
    //查询Kno专题数据总数
    public static int getKnoNum(int Kno){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getKnoNum(Kno);
    }
    //查询Rank难度练习数据总数
    public static int getRankNum(int Rank,int Subj){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getRankNum(Rank,Subj);
    }
    //随机生成试卷
    public static List<Problem> getTestPage(int pageSize,int Subj){
        DAOProblemTable dao=new DAOProblemTable();
        return dao.getTestPage(Subj,pageSize);
    }
}
