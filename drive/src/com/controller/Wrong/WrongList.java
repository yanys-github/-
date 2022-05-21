package com.controller.Wrong;

import com.entities.Problem;
import com.services.ProblemManagement;
import com.services.WrongManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WrongList")
public class WrongList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        PrintWriter out = response.getWriter();
        int pageNum= Integer.parseInt(request.getParameter("pageNum"));
        int pageSize= Integer.parseInt(request.getParameter("pageSize"));
        int Subj= Integer.parseInt(request.getParameter("Subj"));
        String UserAccount=request.getParameter("UserAccount");
        WrongManagement dao=new WrongManagement();
        System.out.println("PAGE"+pageNum+pageSize+Subj+UserAccount);
        List<Problem> list=dao.getPageByWrong(pageNum, pageSize,Subj,UserAccount);
        JSONArray test=JSONArray.fromObject(list);
        System.out.println(test.toString());
        out.write(test.toString());

        out.flush();
        out.close();
    }
}
