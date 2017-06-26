<%-- 
    Document   : 変数の宣言と表示（四則演算）
    Created on : 2017/06/16, 16:21:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    final int BASE = 10;
    int num = 5;
    
    out.print("足し算の結果:");
    int tasu = BASE + num;
    out.print(tasu);
    out.print("<br>");
    
    out.print("引き算の結果:");
    int hiku = BASE - num;
    out.print(hiku);
    out.print("<br>");
    
    out.print("掛け算の結果:");
    int kake = BASE * num;
    out.print(kake);
    out.print("<br>");
    
    out.print("割り算の結果:");
    int wari = BASE / num;
    out.print(wari);
    out.print("<br>");
    
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
    </body>
</html>
