<%@ page import="java.util.List" %>
<%@ page import="com.lui.modle.user" %>
<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/3
  Time: 上午12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//    user user = (user)request.getAttribute("user");
//    if(user!=null){
//        out.print(user.getUserName());
//    }
    user user = (user)session.getAttribute("user");
    if(user==null){
        out.print("<a href=\"login.jsp\">登录</a>\n" +
                "<a href=\"register.html\">注册</a>");
    }
    else {
        out.print(session.getAttribute("userName"));
        out.print("<a href=\"user/logoff\">注销</a>\n");
    }
%>
<%
    List<List> articles = (List) session.getAttribute("articles");
//    out.print(articles.get(0).get(2));
//    String aaa = articles.get(0).get(2).toString();
    for(int i=0,len=articles.size();i<len;i++){
%>
<a href="<%out.print("article?aid="+articles.get(i).get(0));%>"><%out.print(articles.get(i).get(2).toString());%></a>
<%
    }
%>
<form action="user/announce">

    <input type="text" name="topic">topic
    <input type="text" name="announcesBody">body
    <input type="submit">
</form>


</body>
</html>
