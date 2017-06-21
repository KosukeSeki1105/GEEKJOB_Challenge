<%-- 
    Document   : while
    Created on : 2017/06/21, 14:05:36
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int key = 1000;
    int count =0;
    while(key >= 100){
        key = key / 2;
        count++;
}
    out.print(count + "回ループしました。");
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
