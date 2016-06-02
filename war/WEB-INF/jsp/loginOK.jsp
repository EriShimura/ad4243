<%-- 
    Document   : loginOK
    Created on : 2015/01/19, 13:33:02
    Author     : g13943se
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
String userName = (String) session.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_GAME - ログイン完了</title>
    </head>
    <body>
        <p>ようこそ、<%=userName%>さん</p>
        <a href="/ad4243/WelcomeServlet">TOPへ</a>
    </body>
</html>
