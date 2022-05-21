package com.controller.Problem;

import com.entities.Problem;
import com.services.ProblemManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TestList")
public class TestList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        PrintWriter out = response.getWriter();
        int pageSize= Integer.parseInt(request.getParameter("pageSize"));
        int Subj= Integer.parseInt(request.getParameter("Subj"));
        ProblemManagement dao=new ProblemManagement();
        List<Problem> list=dao.getTestPage( Subj,pageSize);
        JSONArray test=JSONArray.fromObject(list);
        System.out.println(test.toString());
        out.write(test.toString());

        out.flush();
        out.close();
    }
}
