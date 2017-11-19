package com.lui.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import com.lui.service.announce;
/**
 * Created by lui on 2017/11/5.
 */
@WebServlet(name = "ServletAnnounce")
public class ServletAnnounce extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean isLogin=(session.getAttribute("user")!=null);
        if(isLogin){
            String userName = session.getAttribute("userName").toString();
            String topic = request.getParameter("topic");
            String announcesBody = request.getParameter("announcesBody");
            Timestamp time = new Timestamp(System.currentTimeMillis());
            int announcsState = 1;
            int announcesClass = 1;
            if(new announce().announceResult(userName,topic,announcesBody,time,announcsState,announcesClass)){
                response.sendRedirect("../");
            }
            else {
//                发帖失败
            }
        }
        else {
//            未登录
            response.sendRedirect("../login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
