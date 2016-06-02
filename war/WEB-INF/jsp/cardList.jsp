<%-- 
    Document   : cardList
    Created on : 2015/01/20, 20:23:36
    Author     : g13943se
--%>

<%--
■ 2015/01/26 原山変更
Vector を　ArrayList　に変更
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="model.Card"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Card> cardList = (ArrayList<Card>) session.getAttribute("cardList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDLINE - CARDLIST</title>
    </head>
    <body>
        <h1>カード一覧</h1>
        <table border="1" cellpacing="1" cellpadding="5">
            <%for(Card c:cardList){%>
            <tr>
                <th><img src="card_pict/<%=c.getCardAddress()%>" width="300"></th>
                <th align="left">
                    ID: <%=c.getCardId()%><br>
                    Rarity: <%=c.getCardRarity()%><br>
                    Name: <%=c.getCardName()%><br>
                    Details: <%=c.getCardDetails()%><br>
                </th>
            </tr>
            <%}%>
        </table><br>
        <a href="/ad4243/WelcomeServlet">TOPへ</a>
    </body>
</html>
