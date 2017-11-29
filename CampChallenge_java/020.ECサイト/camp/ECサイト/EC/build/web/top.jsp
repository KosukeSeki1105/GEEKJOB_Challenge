<%-- 
    Document   : top
    Created on : 2017/08/08, 17:53:08
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
        <title>トップページ</title>
    </head>
    <body>
        <h10>かごゆめ</h10><br><br>
        『金銭取引が絶対に発生しない』<br>
        『いくらでも、どんなものでも購入できる(気分になれる)』<br>
        『ECサイト』<br><br>
        
        <form action="Search" method="GET">
            <input type="text" name="search">
            <input type="submit" name="submit" value="検索"><br><br>            
        </form>
            <%= jh.login()%>
    </body>
</html>
