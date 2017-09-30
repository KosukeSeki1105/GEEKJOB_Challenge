<%-- 
    Document   : switch2
    Created on : 2017/09/30, 21:09:15
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--switch文を利用して、以下の処理を実現してください。-->
<!--1. 値が【A】なら「英語」-->
<!--値が【あ】なら「日本語」-->
<!--それ以外は何も表示しない処理-->
<!--※型はcharを使用してください-->
<%
    out.print("switch文を利用して、以下の処理を実現します。<br>");
    out.print("値が【A】なら「英語」<br>");
    out.print("値が【あ】なら「日本語」<br>");
    out.print("それ以外は何も表示しない処理<br>");
    out.print("※型はcharを使用します<br><br>");
    
    char c = 'A';
    
    switch(c) {
        case 'A':
            out.print("英語");
            break;
        case 'あ':
            out.print("日本語");
            break;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>switch文2</title>
    </head>
    <body>
    </body>
</html>
