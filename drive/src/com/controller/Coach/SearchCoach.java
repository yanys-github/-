package com.controller.Coach;

import com.entities.Coach;
import com.services.CoachManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SearchCoach")
public class SearchCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        CoachManagement cm=new CoachManagement();
        ArrayList<Coach> c= null;
        try {
            c = cm.searchCoach();
        } catch (SQLException e) { System.out.println(e); }
        JSONArray ja=JSONArray.fromObject(c);
        PrintWriter out = response.getWriter();
        out.println(ja.toString());
    }
}
