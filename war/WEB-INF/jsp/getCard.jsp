<%-- 
    Document   : getCard
    Created on : 2015/02/09, 20:34:15
    Author     : g13943se
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Card"%>
<%
    Card newCard = (Card) request.getAttribute("newCard");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEADLINE_CARDGAME - GET CARD!!</title>
    </head>
    <body>
        <h1>カードをゲットしました！</h1>
        <table border="1" cellpacing="1" cellpadding="5">
            <tr>
                <th><img src="card_pict/<%=newCard.getCardAddress()%>" width="300"></th>
                <th align="left">
                    ID: <%=newCard.getCardId()%><br>
                    Rarity: <%=newCard.getCardRarity()%><br>
                    Name: <%=newCard.getCardName()%><br>
                    Details: <%=newCard.getCardDetails()%><br>
                </th>
            </tr>
        </table>
        <br><a href="/ad4243/WelcomeServlet">TOPへ</a>
    </body>
</html>
