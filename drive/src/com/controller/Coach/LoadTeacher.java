package com.controller.Coach;

import com.entities.Coach;
import com.services.CoachManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "LoadTeacher")
public class LoadTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session=request.getSession();
        int Account=(int)session.getAttribute("CoAccount");


        PrintWriter out=response.getWriter();
        System.out.println(Account);
        CoachManagement check = new CoachManagement();
        ArrayList<Coach> list= check.ReturnCoach(Account);
        JSONArray test= JSONArray.fromObject(list);
        System.out.println(test.toString());
        out.write(test.toString());
        out.close();
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
