<%-- 
    Document   : switch文2
    Created on : 2017/06/16, 17:45:57
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    char name = 'あ';
    switch(name){
        case 'A':
            out.print("英語");
            break;
        case 'あ':
            out.print("日本語");
            break;
        default:
            break;
        
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
