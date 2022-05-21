package com.controller.User;

import com.entities.User;
import com.services.UserManagement;
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

@WebServlet(name = "LoadStudent")
public class LoadStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session=request.getSession();
        String Account=(String)session.getAttribute("UserAccount");

        PrintWriter out=response.getWriter();
        System.out.println(Account);
        UserManagement check = new UserManagement();
        ArrayList<User> list= check.ReturnUser(Account);
        JSONArray test=JSONArray.fromObject(list);
        System.out.println(test.toString());
        out.write(test.toString());
        out.close();
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
