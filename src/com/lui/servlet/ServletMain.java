package com.lui.servlet;

import com.lui.service.getArticle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

import static com.sun.deploy.si.SingleInstanceManager.getActionName;

/**
 * Created by lui on 2017/11/3.
 */
@WebServlet(name = "ServletMain")
public class ServletMain extends HttpServlet {
//    protected Action action = factory.create(getActionName(request));
    protected void  init(HttpServletRequest request, HttpServletResponse response)throws ServletException{
        System.out.printf("111");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List articles = new getArticle().articleData();
        HttpSession session = request.getSession();
        session.setAttribute("articles",articles);
        response.sendRedirect("main.jsp");
//            response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
