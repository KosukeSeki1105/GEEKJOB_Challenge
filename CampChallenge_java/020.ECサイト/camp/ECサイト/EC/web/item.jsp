<%-- 
    Document   : item
    Created on : 2017/08/08, 18:18:25
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
        <title>商品詳細ページ</title>
    </head>
    <body>
        <h1>ここに商品詳細が表示されます。</h1>
        <!--「カートに追加する」ボタンがあり、クリックするとaddに遷移する。-->
        <%= jh.login()%>
    </body>
</html>
