package com.controller.Wrong;

import com.entities.Wrong;
import com.services.WrongManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateWrong")
public class UpdateWrong extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String WrongAnswer=request.getParameter("WrongAnswer");
        int Num= Integer.parseInt(request.getParameter("Num"));
        String UserAccount=request.getParameter("UserAccount");
        System.out.println("WrongAnswer="+WrongAnswer);
        PrintWriter out=response.getWriter();
        WrongManagement check=new WrongManagement();
        Wrong w=new Wrong(UserAccount,Num,WrongAnswer);
        if(check.updateWrong(w)){
            out.write("ok");
        }else{
            out.write("err");
        }
    }
}
