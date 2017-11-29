<%-- 
    Document   : search
    Created on : 2017/08/08, 18:10:24
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
        <title>結果一覧</title>
    </head>
    <body>
        <h1>ここに結果が表示されます。</h1>
        
        <%= jh.login()%>
    </body>
</html>
