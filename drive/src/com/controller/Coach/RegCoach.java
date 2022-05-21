package com.controller.Coach;

import com.entities.Coach;
import com.services.CoachManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegCoach")
public class RegCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        int CoAccount= Integer.parseInt(request.getParameter("CoAccount"));
        String CoPassword=request.getParameter("CoPassword");
        String CoPhone=request.getParameter("CoPhone");
        String CoName=request.getParameter("CoName");
        String CoID=request.getParameter("CoID");
        String CoSex=request.getParameter("CoSex");
        String CoProvince=request.getParameter("CoProvince");
        String CoCity=request.getParameter("CoCity");
        double CoPrice=Integer.parseInt(request.getParameter("CoPrice"));
        String CoInfo=request.getParameter("CoInfo");
        int CoWork= Integer.parseInt(request.getParameter("CoWork"));

        PrintWriter out=response.getWriter();
        CoachManagement creat=new CoachManagement();
        Coach u=new Coach(CoAccount,CoPassword,CoPhone,CoName,CoID,CoSex,CoProvince,CoCity,CoPrice,CoInfo,CoWork);
        if(creat.addCoach(u)){
            HttpSession session=request.getSession();
            session.setAttribute("CoAccount",CoAccount);
            out.write("ok");
        }else{
            out.write("err");
        }
    }
}
