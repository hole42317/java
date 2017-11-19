package com.lui.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

import com.lui.service.reply;

/**
 * Created by lui on 2017/11/5.
 */
@WebServlet(name = "ServletReply")
public class ServletReply extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        boolean isLogin=(session.getAttribute("user")!=null);
        if(isLogin){
            String replyBody = request.getParameter("reply");
            int AID = Integer.parseInt(request.getParameter("AID"));
            String userName = session.getAttribute("userName").toString();
            Timestamp time = new Timestamp(System.currentTimeMillis());
            if(new reply().replyResult(AID,userName,time,replyBody)){
                response.sendRedirect("../article?aid="+AID);
            }
            else {
                //回帖失败
            }
//            response.setHeader("refresh","3;url=");
        }
        else {
            //未登录
            response.sendRedirect("../login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
