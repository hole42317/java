package com.lui.servlet;

import com.lui.service.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lui on 2017/11/14.
 */
@WebServlet(name = "ServletAdminLogin")
public class ServletAdminLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String adminPassword = request.getParameter("adminPassword");
        if(new admin().adminLogin(adminName,adminPassword)){
            HttpSession session = request.getSession();
            session.setAttribute("adminName",adminName);
//            Cookie cookie;
            response.sendRedirect("../admin.jsp");
        }
        else {
            response.sendRedirect("../adminLogin.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
