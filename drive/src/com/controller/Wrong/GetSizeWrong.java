package com.controller.Wrong;

import com.services.WrongManagement;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetSizeWrong")
public class GetSizeWrong extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;  charset=utf-8");
        PrintWriter out = response.getWriter();
        int Subj= Integer.parseInt(request.getParameter("Subj"));
        String UserAccount=request.getParameter("UserAccount");
        WrongManagement dao = new WrongManagement();
        try {
            System.out.println(Subj+UserAccount);
            int count = dao.getWrongNum(Subj,UserAccount);
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
