<%-- 
    Document   : welcome
    Created on : 2015/01/19, 13:33:44
    Author     : g13943se
--%>

<!-- 
[2016-06-21]
どうやらGoogleのUserServiceを使うとよくわからんメアドでもログインができるようだ。
なのではじめての方はこちらをなくそうと思う…。
以下になくした分のコードを書いておく。もしまた会員登録が必要になったら活用してほしい。
~Mr.Smith~

<li><a href="/ad4243/RegistServlet">はじめての方はこちら</a>(ユーザー登録)</li>
(body-ul内に埋め込み)
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME</title>
    </head>
    <body>
        <ul>
            <li><a href="/ad4243/LoginServlet">ログイン</a></li>
        </ul>
    </body>
</html>
