<%-- 
    Document   : for3
    Created on : 2017/09/30, 21:57:31
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--for文を利用して、0から100を全部足す処理を実現してください。-->
<%
    out.print("for文を利用して、0から100を全部足す処理を実現します。<br><br>");
    
    int num = 0;
    for(int i = 0; i <= 100; i++) {
        out.print(num + " + " + i + " = ");
        num += i;
        out.print(num + "<br>");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文3</title>
    </head>
    <body>
    </body>
</html>
