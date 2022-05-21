package com.controller.Wrong;//加入错题

import com.entities.Wrong;
import com.services.WrongManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddWrong")
public class AddWrong extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String UserAccount=request.getParameter("UserAccount");
        int Num= Integer.parseInt(request.getParameter("Num"));
        String WrongAnswer=request.getParameter("WrongAnswer");
        PrintWriter out=response.getWriter();
        WrongManagement creat=new WrongManagement();
        Wrong u=new Wrong(UserAccount,Num,WrongAnswer);
        try {
            if(creat.addWrong(u)){
                out.write("ok");
            }else{
                out.write("err");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
