<%-- 
    Document   : calculation
    Created on : 2017/09/30, 20:33:07
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--定数と変数を宣言し、それぞれに数値を入れて四則演算を行い、四則演算の結果をそれぞれ表示してください。-->
<%
    out.print("四則演算をします。<br><br>");
    
    final int BASE = 100;
    int num1 = 10;
    int num2 = 20;
    int num3 = 30;
    int num4 = 40;
    
    out.print("100 + 10 = " + (BASE + num1) + "<br>");
    out.print("100 - 20 = " + (BASE - num2) + "<br>");
    out.print("100 × 30 = " + (BASE * num3) + "<br>");
    out.print("100 ÷ 40 = " + (BASE / num4) + "<br>");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>四則演算</title>
    </head>
    <body>
    </body>
</html>
