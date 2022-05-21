package com.controller.Appointment;

import com.services.AppointmentManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "CancelAppointment")
public class CancelAppointment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String appid=request.getParameter("AppID");
        AppointmentManagement ap=new AppointmentManagement();
        boolean flag= false;
        try {
            flag = ap.cancelAppointment(appid);
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(flag==true)
            out.write(1);
    }
}
