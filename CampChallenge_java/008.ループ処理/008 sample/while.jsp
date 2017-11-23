<%-- 
    Document   : while
    Created on : 2017/09/30, 22:05:25
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--while文を利用して、以下の処理を実現してください。-->
<!--1. 1000を2で割り続け、100より小さくなったらループを抜ける処理-->
<%
    // 変数宣言
    int num   = 1000;

    // カウンタ
    int count = 0;
    
    while( num > 100 ) {
        out.print(num + " ÷ 2 = ");
        num /= 2;
        out.print( num + "<br>" );
        count++;
    }
    out.print( count + "回でループを抜けました。" );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>while文</title>
    </head>
    <body>
    </body>
</html>
