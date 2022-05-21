package com.controller.User;//用户登录

import com.services.UserManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginUser")
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Account = request.getParameter("Account");
        String Password = request.getParameter("Password");
        String Picked = request.getParameter("picked");
        PrintWriter out = response.getWriter();

        UserManagement check = new UserManagement();
        if (check.checkUser(Account, Password)) {
            HttpSession session = request.getSession();
            session.setAttribute("UserAccount", Account);
            out.write("ok");

        } else {
            out.write("err");

        }

    }
}