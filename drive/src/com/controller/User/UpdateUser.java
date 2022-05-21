package com.controller.User;

import com.entities.User;
import com.services.UserManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateUser")
public class UpdateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        String UserAccount=request.getParameter("UserAccount");
        String UserPassword=request.getParameter("UserPassword");
        String UserPhone=request.getParameter("UserPhone");
        System.out.println(UserAccount);
        PrintWriter out=response.getWriter();
        UserManagement create=new UserManagement();
        User u=new User(UserAccount,UserPassword,UserPhone);
        if(create.updateUser(u)){
            out.write("ok");

        }
        else
        {
            out.write("err");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
