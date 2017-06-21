<%-- 
    Document   : for2jsp
    Created on : 2017/06/21, 13:32:28
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     String NAME ="数学";
    
    for (int i = 1; i <= 30; i++){
        NAME = NAME + "A";
        out.print(NAME);
        out.print("<br>");
    }    
    /*
    String total = "A";
    out.print(NAME +"A");
    out.print("<br>");
    
    for (int i = 1; i <= 30; i++){
        total = total + "A";
        out.print(NAME + total);
        out.print("<br>");
}
    */
    

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
