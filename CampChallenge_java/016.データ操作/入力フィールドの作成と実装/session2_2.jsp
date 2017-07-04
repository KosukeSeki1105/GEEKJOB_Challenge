<%-- 
    Document   : session2_2
    Created on : 2017/07/03, 11:19:35
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
           request.setCharacterEncoding("UTF-8");
           
            String n = request.getParameter("name");
            String s = request.getParameter("sei");
            String hby = request.getParameter("syumi");
           
            out.print("氏名；" + n + "<br>");
            out.print("性別：" + s + "<br>");
            out.print("趣味：" + hby + "<br>");
           
            HttpSession hs = request.getSession();
            
            hs.setAttribute("Name", n);
            hs.setAttribute("Sei", s);
            hs.setAttribute("Hby", hby);
           
        %>
    </body>
</html>
