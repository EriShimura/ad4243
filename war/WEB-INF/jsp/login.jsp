<%-- 
    Document   : login
    Created on : 2015/01/19, 13:32:54
    Author     : g13943se
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - ログイン</title>
    </head>
    <body>
        <form action="/ad4243/LoginServlet" method="post">
            ユーザー名:<input type="text" name="userName"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>
