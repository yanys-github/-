package com.controller.Problem;//获取全部题目

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

@WebServlet(name = "GetProblemAll")
public class GetProblemAll extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        List<Problem> list= ProblemManagement.getProblemAll();
        JSONArray test=JSONArray.fromObject(list);
        out.write(test.toString());
        out.flush();
        out.close();
    }
}
