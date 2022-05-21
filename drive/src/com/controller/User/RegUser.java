package com.controller.User;//注册用户信息

import com.entities.User;
import com.services.UserManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet(name = "RegistUser")
public class RegUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String UserAccount=request.getParameter("UserAccount");
        String UserPassword=request.getParameter("UserPassword");
        String UserPhone=request.getParameter("UserPhone");
        String UserName=request.getParameter("UserName");
        String UserID=request.getParameter("UserID");
        PrintWriter out=response.getWriter();
        UserManagement creat=new UserManagement();
        User u=new User(UserAccount,UserPassword,UserPhone,UserName,UserID,0);
        if(creat.addUser(u)){
            HttpSession session=request.getSession();
            session.setAttribute("UserAccount",UserAccount);
            out.write("ok");
        }else{
            out.write("err");
        }
    }
}
