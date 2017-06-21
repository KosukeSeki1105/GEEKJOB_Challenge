<%-- 
    Document   : for3
    Created on : 2017/06/21, 13:52:01
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int total = 0;
    for (int i = 0; i <= 100; i++){
         total = total + i;
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
