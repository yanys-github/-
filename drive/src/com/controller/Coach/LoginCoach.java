package com.controller.Coach;

import com.services.CoachManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginCoach")
public class LoginCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Account=Integer.parseInt(request.getParameter("Account"));
        String Password = request.getParameter("Password");

        PrintWriter out = response.getWriter();
        CoachManagement check = new CoachManagement();
        if (check.checkCoach(Account, Password)) {
            HttpSession session=request.getSession();
            session.setAttribute("CoAccount",Account);
            out.write("ok");

        } else {
            out.write("err");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
