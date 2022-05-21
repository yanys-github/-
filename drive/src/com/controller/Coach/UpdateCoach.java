package com.controller.Coach;

import com.entities.Coach;
import com.services.CoachManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateCoach")
public class UpdateCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int CoAccount=Integer.parseInt(request.getParameter("CoAccount"));
        String CoPassword=request.getParameter("CoPassword");
        String CoPhone=request.getParameter("CoPhone");
        String CoSex=request.getParameter("CoSex");
        System.out.println(CoSex);
        PrintWriter out=response.getWriter();
        CoachManagement create=new CoachManagement();
        Coach u=new Coach(CoAccount,CoPassword,CoPhone,CoSex);
        if(create.updateCoach(u)){
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
