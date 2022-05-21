package com.services;

import com.DAO.DAOCoachTable;
import com.entities.Coach;

import java.sql.SQLException;
import java.util.ArrayList;

public class CoachManagement {
    //注册教练
    public static boolean addCoach(Coach c){
        DAOCoachTable dao=new DAOCoachTable();
        return dao.addCoach(c);
    }
    //检测教练是否存在
    public static boolean isCoach(int CoAccount){
        DAOCoachTable dao=new DAOCoachTable();
        return dao.isCoach(CoAccount);
    }
    public static boolean checkCoach(int CoAccount,String CoPassword){
        DAOCoachTable dao=new DAOCoachTable();
        return dao.checkCoach(CoAccount,CoPassword);
    }
    public static ArrayList<Coach> ReturnCoach(int CoAccount){
        DAOCoachTable dao=new DAOCoachTable();
        return dao.ReturnCoach(CoAccount);
    }
    public static boolean updateCoach(Coach u){
        DAOCoachTable dao=new DAOCoachTable();
        return dao.updateCoach(u);
    }
    public static ArrayList<Coach> searchCoach() throws SQLException, SQLException {
        DAOCoachTable dao=new DAOCoachTable();
        return dao.searchCoach();
    }
    public static Coach getCoach(int CoAccount) throws SQLException {
        DAOCoachTable dao=new DAOCoachTable();
        return dao.getCoach(CoAccount);
    }
}
