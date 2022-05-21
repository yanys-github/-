package com.controller.Appointment;

import com.entities.AppUserData;
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

@WebServlet(name = "SearchAppointment-User")
public class SearchAppointmentUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        AppointmentManagement ap = new AppointmentManagement();
        HttpSession session = request.getSession();
        String usAcc = (String) session.getAttribute("UserAccount");
        ArrayList<AppUserData> list = null;
        try {
            list = ap.searchAppointmentUser(usAcc);
        } catch (SQLException e) {
            System.out.println(e);
        }
        JSONArray ja=JSONArray.fromObject(list);
        PrintWriter out = response.getWriter();
        out.println(ja.toString());
    }
}
