package com.DAO;

import com.entities.Appointment;
import com.entities.CoachTime;
import com.entities.AppUserData;
import com.entities.AppCoachData;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOAppointmentTable {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;

    //显示教练未来一周时间安排
    public ArrayList<CoachTime> getAppointmentTime(int CoAccount) throws SQLException {
        ArrayList<CoachTime> list=new ArrayList<>();
        Date date = new Date(System.currentTimeMillis());
        conn = DBConnection.getConnection();
        String sql="select * from FormAppointment where CoAccount=? and AppDate=?";
        assert conn != null;
        for(int i=0;i<7;i++)
        {
            pst= conn.prepareStatement(sql);
            pst.setInt(1,CoAccount);
            pst.setDate(2,date);
            rs = pst.executeQuery();
            CoachTime coachtime=new CoachTime(date.toString());
            while(rs.next())
            {
                if(rs.getInt("AppDate2")==1)
                    coachtime.setAm(1);
                else if(rs.getInt("AppDate2")==0)
                    coachtime.setPm(1);
            }
            list.add(coachtime);
            //日期递增
            Calendar calendar =new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE, -7);
            java.util.Date utilDate = (java.util.Date)calendar.getTime();
            calendar.add(calendar.DATE, 8);
            utilDate = (java.util.Date)calendar.getTime();
            date=new Date(utilDate.getTime());
        }
        return list;
    }
    public int ordAppointment(String CoAccount,String UserAccount,String date,String date2) throws SQLException, ParseException {
        int flag=0;
        conn = DBConnection.getConnection();
        //设置类型
        int coAcc=Integer.parseInt(CoAccount);//账号
        System.out.println(coAcc);
        java.util.Date utilDate = new java.util.Date();//Date1
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        utilDate=format.parse(date);
        Date d1=new Date(utilDate.getTime());
        boolean d2;//Date2
        if(date2=="true") d2=true;
        else d2=false;
        //录入实体
        Appointment ap=new Appointment(coAcc,UserAccount,d1,d2);

        String sql="insert into FormAppointment(UserAccount,CoAccount,AppDate,Appdate2,AppPrice) values (?,?,?,?,0)";
        pst= conn.prepareStatement(sql);
        pst.setInt(2,ap.getCoAccount());
        pst.setString(1,ap.getUserAccount());
        pst.setDate(3,ap.getAppDate());
        pst.setBoolean(4,ap.isAppDate2());
        try {
            pst.executeUpdate();
            flag=1;
        }catch (SQLException e){System.out.println(e);}
        return flag;
    }
    public ArrayList<AppUserData> searchAppointmentUser(String UserAccount) throws SQLException {
        ArrayList<AppUserData> list=new ArrayList<>();
        conn = DBConnection.getConnection();
        String sql="select AppID,FormAppointment.CoAccount,CoName,AppDate,AppDate2 from FormAppointment,TableCoach where UserAccount=? and FormAppointment.CoAccount=TableCoach.CoAccount";
        pst= conn.prepareStatement(sql);
        pst.setString(1,UserAccount);
        rs = pst.executeQuery();
        while(rs.next())
        {
            String date=rs.getDate("AppDate").toString();
            AppUserData ad=new AppUserData(
                    rs.getInt("AppID"),
                    rs.getInt("CoAccount"),
                    rs.getString("CoName"),
                    date,
                    rs.getBoolean("AppDate2")
            );
            System.out.println(ad.getAppID()+ad.getCoAccount());
            list.add(ad);
        }
        return list;
    }
    public boolean cancelAppointment(String appid) throws SQLException {
        conn=DBConnection.getConnection();
        String sql="delete from FormAppointment where AppID=?";
        pst= conn.prepareStatement(sql);
        pst.setString(1,appid);
        boolean ans=false;
        if(pst.executeUpdate()!=0)ans=true;
        return ans;
    }
    public ArrayList<AppCoachData> searchAppointmentCoach(String CoAccount) throws SQLException {
        ArrayList<AppCoachData> list=new ArrayList<>();
        conn = DBConnection.getConnection();
        String sql="select AppID,FormAppointment.UserAccount,UserName,AppDate,AppDate2 from FormAppointment,TableUser where CoAccount=? and FormAppointment.UserAccount=TableUser.UserAccount";
        pst= conn.prepareStatement(sql);
        pst.setString(1,CoAccount);
        rs = pst.executeQuery();
        while(rs.next())
        {
            String date=rs.getDate("AppDate").toString();
            AppCoachData ad=new AppCoachData(
                    rs.getInt("AppID"),
                    rs.getString("UserAccount"),
                    rs.getString("UserName"),
                    date,
                    rs.getBoolean("AppDate2")
            );
            list.add(ad);
        }
        return list;
    }
}
