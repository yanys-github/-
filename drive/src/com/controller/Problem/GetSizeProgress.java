package com.controller.Problem;//获取全部题目的总数

import com.services.ProblemManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetSizeProgress")
public class GetSizeProgress extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        PrintWriter out = response.getWriter();
        int Subj= Integer.parseInt(request.getParameter("Subj"));
        ProblemManagement dao = new ProblemManagement();
        try {
            int count = dao.getAllNum(Subj);
            JSONArray test=JSONArray.fromObject(count);
            out.write(test.toString());
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            out.close();
            out.flush();
        }
    }
}
