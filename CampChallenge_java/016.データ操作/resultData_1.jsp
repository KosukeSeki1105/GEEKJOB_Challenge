<%-- 
    Document   : resultData_1
    Created on : 2017/06/30, 10:30:52
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
    request.setCharacterEncoding("UTF-8");
    out.print(request.getParameter("txtName") + "<br>");
    out.print(request.getParameter("rdoSample") + "<br>");
    out.print(request.getParameter("mulText") + "<br>");
    %>
    </body>
</html>
