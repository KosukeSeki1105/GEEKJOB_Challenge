<%-- 
    Document   : self_introduction
    Created on : 2017/09/30, 20:20:58
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--自己紹介が入った変数を用意し、それを表示してください-->
<%
    String name = "関皓理";
    int age  = 24;
    String interest = "旅行";
    
    out.print( "はじめまして。" + name + "です。<br>" );
    out.print( age + "歳です。<br>" );
    out.print( interest + "が好きです。<br>" );
    out.print( "よろしくお願いします（・ω・）/" );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>自己紹介</title>
    </head>
    <body>
    </body>
</html>
