<%-- 
    Document   : for文1
    Created on : 2017/06/21, 11:33:24
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    long total = 1;
    for (int i = 1; i <= 20; i++){
        total = total * 8;
        out.print(total);
        out.print("<br>");
    }
    
   
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
