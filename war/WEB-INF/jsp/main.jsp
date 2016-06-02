<%-- 
    Document   : main
    Created on : 2015/01/19, 13:33:10
    Author     : g13943se
--%>


<%--
■2015/01/26 原山変更
画像URLを変更
ad4243/build/web/WEB-INF に保存したファイルは、「○○.png」と書くだけでアクセス可能
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userName = (String) session.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - mypage</title>
    </head>
    <body>
        <h1>DEADLINE CARDGAME</h1>
        <h2>userName: <%=userName%></h2>
        <p>Main Content</p>
        <li>
            <ul><a href="/ad4243/MainServlet?do=getpoint">PT付与(coming soon)</a></ul>
            <ul><a href="/ad4243/MainServlet?do=gacha">ガチャをまわす！</a></ul>
            <ul><a href="/ad4243/MainServlet?do=deadline">締切閲覧・登録(coming soon)</a></ul>
            <ul><a href="/ad4243/MainServlet?do=cardlist">所持カード一覧</a></ul>
        </li>
        <p><a href="/ad4243/LogoutServlet">ログアウト</a></p>
    </body>
</html>
