<%-- 
    Document   : gacha
    Created on : 2015/01/20, 20:23:12
    Author     : g13943se
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.application.ad4243.model.User"%>
<%
    User user = (User) session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - GACHA</title>
    </head>
    <body>
        <h1><%=user.getName()%>'s POINT: <%=user.getPoint()%></h1>
        <p><a href="/ad4243/GachaServlet">5pointを使ってガチャをひく！</a></p>
        <br><a href="/ad4243/WelcomeServlet">TOPへ</a>
    </body>
</html>
