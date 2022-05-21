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

@WebServlet(name = "IsCoach")
public class IsCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int CoAccount=Integer.parseInt(request.getParameter("CoAccount"));
        PrintWriter out=response.getWriter();
        CoachManagement check=new CoachManagement();
        if(check.isCoach(CoAccount)){
            out.write("ok");
        }else{
            out.write("err");
        }
    }
}
