package com.services;

import com.DAO.DAOWrongTable;
import com.entities.Problem;
import com.entities.User;
import com.entities.Wrong;

import java.util.List;

public class WrongManagement {
    public static boolean addWrong(Wrong w){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.addWrong(w);
    }
    public static boolean checkWrong(String UserAccount,int Num){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.checkWrong(UserAccount,Num);
    }
    public static boolean updateWrong(Wrong w){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.updateWrong(w);
    }
    public static List<Problem> getPageByWrong(int pageNum, int pageSize, int Subj, String UserAccount){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.getPageByWrong(pageNum,pageSize,Subj,UserAccount);
    }
    public static int getWrongNum(int Subj,String UserAccount){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.getWrongNum(Subj,UserAccount);
    }
    public static boolean deleteWrong(int Num,String UserAccount){
        DAOWrongTable dao=new DAOWrongTable();
        return dao.deleteWrong(Num,UserAccount);
    }
}
