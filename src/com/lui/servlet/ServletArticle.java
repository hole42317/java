package com.lui.servlet;

import com.lui.service.getArticleBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lui on 2017/11/4.
 */
@WebServlet(name = "ServletArticle")
public class ServletArticle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int aid = Integer.parseInt(request.getParameter("aid"));

        List<List> article = new getArticleBody().articleBodyData(aid);
//        PrintWriter out = response.getWriter();
//        out.print("1"+article);
        HttpSession session = request.getSession();
        session.setAttribute("articleReply",article);
        response.sendRedirect("articleBody.jsp");
    }
    public static void main(String[] args){
        
    }
}
