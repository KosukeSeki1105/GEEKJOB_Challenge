<%-- 
    Document   : mydeleteresult
    Created on : 2017/08/08, 19:58:41
    Author     : guest1Day
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
        <title>会員情報（削除完了画面）</title>
    </head>
    <body>
        <h1>会員情報削除完了</h1>
        削除しました。<br>
        ご利用ありがとうございました。<br><br>
        <%= jh.top()%>        
    </body>
</html>
