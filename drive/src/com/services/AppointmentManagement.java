package com.services;

import com.DAO.DAOAppointmentTable;
import com.entities.CoachTime;
import com.entities.AppUserData;
import com.entities.AppCoachData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;



public class AppointmentManagement {
    public static ArrayList<CoachTime> getAppointmentTime(int CoAccount) throws SQLException {
        DAOAppointmentTable da=new DAOAppointmentTable();
        return da.getAppointmentTime(CoAccount);
    }
    public static int ordAppointment(String CoAccount,String UserAccount,String date,String date2 ) throws SQLException, ParseException {
        DAOAppointmentTable da=new DAOAppointmentTable();
        return da.ordAppointment(CoAccount,UserAccount,date,date2);
    }
    public static ArrayList<AppUserData> searchAppointmentUser(String UserAccount) throws SQLException {
        DAOAppointmentTable da=new DAOAppointmentTable();
        return da.searchAppointmentUser(UserAccount);
    }
    public static boolean cancelAppointment(String appid) throws SQLException {
        DAOAppointmentTable da=new DAOAppointmentTable();
        return da.cancelAppointment(appid);
    }
    public static ArrayList<AppCoachData> searchAppointmentCoach(String CoAccount) throws SQLException {
        DAOAppointmentTable da=new DAOAppointmentTable();
        return da.searchAppointmentCoach(CoAccount);
    }
}
