<%-- 
    Document   : getPoint
    Created on : 2015/01/20, 20:23:04
    Author     : g13943se
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="model.DeadLine" %>
<%
    ArrayList<DeadLine> deadlineList = (ArrayList<DeadLine>)session.getAttribute("deadlineList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - GETPOINT</title>
    </head>
    <body>
        <h1>PT付与</h1>
        <h3>現在締切が過ぎている事項</h3>
        <li>
            <%if(deadlineList!=null) for(DeadLine dl:deadlineList){%>
            <ul><%=dl.getDetails()%></ul>
            <%}%>
        </li>
        <a href="/ad4243/WelcomeServlet">TOPへ</a>
    </body>
</html>
