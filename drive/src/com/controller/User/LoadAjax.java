package com.controller.User;//加载信息当前登录账号

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoadAjax")
public class LoadAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session=request.getSession();
        String UserAccount=(String)session.getAttribute("UserAccount");
        PrintWriter out=response.getWriter();
        out.write(UserAccount);
        out.close();
        out.flush();
    }
}
