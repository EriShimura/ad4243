<%-- 
    Document   : regist
    Created on : 2015/01/19, 13:33:18
    Author     : g13943se
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - ユーザー登録</title>
    </head>
    <body>
        <p>新しく登録する情報を入力してください</p>
        <form action="/ad4243/RegistServlet" method="post">
            ユーザー名:<input type="text" name="userName"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="登録">
        </form>
        <br>
        <a href = "/ad4243/WelcomeServlet">戻る</a>
    </body>
</html>
