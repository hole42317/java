<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lui
  Date: 2017/11/4
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<jsp:useBean id="user" class="com.lui.modle.user"></jsp:useBean>--%>
<body>

<%
    List<List> articleReply = (List) session.getAttribute("articleReply");
    out.print(articleReply);
%>
<form action="user/reply" method="post">
    <input type="hidden" name="AID" value="<%out.print(articleReply.get(0).get(0));%>" >
    <input type="text" name="reply">
    <input type="submit">
</form>
</body>
</html>
