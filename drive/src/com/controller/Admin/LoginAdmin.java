package com.controller.Admin;

import com.services.AdminManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginAdmin")
public class LoginAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Account = request.getParameter("Account");
        String Password = request.getParameter("Password");
        String Picked = request.getParameter("picked");
        PrintWriter out = response.getWriter();
        AdminManagement check = new AdminManagement();
        if (check.checkAdmin(Account, Password)) {
            HttpSession session=request.getSession();
            session.setAttribute("Account",Account);
            out.write("ok");
        } else {
            out.write("err");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
