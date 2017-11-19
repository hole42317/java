package com.lui.servlet;

import java.io.IOException;
import java.sql.Connection;
import com.lui.conn.conn;
import com.lui.service.login;
import com.lui.modle.user;
import javax.servlet.http.HttpSession;

/**
 * Created by lui on 2017/11/3.
 */
public class ServletLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        user user = new user();
        user.setUserName(userName);
        user.setUserPassword(userPassword);

        try {
           if(new login().validLogin(userName,userPassword)){
               HttpSession session = request.getSession();
               session.setMaxInactiveInterval(1800);
               session.setAttribute("user",user);
               session.setAttribute("userName",userName);
               session.setAttribute("userPassword",userPassword);
               System.out.print(session.getAttribute("userName"));
               response.sendRedirect("../main.jsp");
           }
            else {
               response.sendRedirect("../login.jsp");
           }
        }
        catch (Exception e){
            response.sendRedirect("../login.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
