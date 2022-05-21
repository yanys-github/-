package com.controller.Coach;

import com.entities.Coach;
import com.services.CoachManagement;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetCoach")
public class GetCoach extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        CoachManagement cm=new CoachManagement();
        Coach co = null;
        try{
            String coAcc=(String)session.getAttribute("coAcc");
            //System.out.println(coAcc);
            co=cm.getCoach(Integer.parseInt(coAcc));
        }catch (Exception e){out.write(""+e);}
        JSONArray ja=JSONArray.fromObject(co);
        System.out.println(co.getCoName());
        out.println(ja.toString());
    }
}
