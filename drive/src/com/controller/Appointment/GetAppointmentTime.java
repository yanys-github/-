package com.controller.Appointment;

import com.entities.Coach;
import com.entities.CoachTime;
import com.services.AppointmentManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "GetAppointmentTime")
public class GetAppointmentTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String coAcc=(String)session.getAttribute("coAcc"); //获取教练账号
        AppointmentManagement ap=new AppointmentManagement();
        ArrayList<CoachTime> list = null;
        try {
            list= ap.getAppointmentTime(Integer.parseInt(coAcc));
        } catch (SQLException e) {
            System.out.println(e);
        }
        JSONArray ja=JSONArray.fromObject(list);
        System.out.println(list);
        PrintWriter out = response.getWriter();
        out.println(ja.toString());
    }
}
