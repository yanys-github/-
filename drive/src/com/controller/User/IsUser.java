package com.controller.User;

import com.services.UserManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IsUser")
public class IsUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String UserAccount=request.getParameter("UserAccount");
        PrintWriter out=response.getWriter();
        UserManagement check=new UserManagement();
        if(check.isUser(UserAccount)){
            out.write("ok");
        }else{
            out.write("err");
        }
    }
}
