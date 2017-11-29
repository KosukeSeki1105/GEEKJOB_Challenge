<%-- 
    Document   : add
    Created on : 2017/08/08, 18:25:13
    Author     : seki-k
--%>
<%@page import="jums.JumsHelper"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カートへ商品を追加</title>
    </head>
    <body>
        <h1>カートに追加しました。</h1><br>
        <%= jh.login()%>
    </body>
</html>
