package com.controller.Appointment;

import com.services.AppointmentManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

@WebServlet(name = "OrdAppointment")
public class OrdAppointment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String coAcc=(String)session.getAttribute("coAcc");
        String usAcc=(String)session.getAttribute("UserAccount");
        String date=request.getParameter("date");
        String date2=request.getParameter("date2");
        System.out.println(coAcc+date+date2);
        AppointmentManagement ap=new AppointmentManagement();
        int flag = 2;
        try {
            flag=ap.ordAppointment(coAcc,usAcc,date,date2);
        } catch (SQLException | ParseException e) { System.out.println(e); }
        PrintWriter out = response.getWriter();
        String f=Integer.toString(flag);
        out.write(f);
    }
}
