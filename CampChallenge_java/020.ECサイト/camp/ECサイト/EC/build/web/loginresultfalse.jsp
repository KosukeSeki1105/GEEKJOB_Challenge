<%-- 
    Document   : loginresultfalse
    Created on : 2017/08/10, 11:25:38
    Author     : guest1Day
--%>
<%@page import="java.util.ArrayList"
        import="jums.JumsHelper"
        import="jums.UserData"%>

<%
    String msg                  = (String)request.getAttribute("falseLogin");
    ArrayList<String> nullLogin = (ArrayList<String>)request.getAttribute("nullLogin");
    JumsHelper jh               = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン失敗</title>
    </head>
    <body>
        <h1>ログイン失敗</h1>
        <!--ログイン失敗の場合-->
        <% if(msg != null){ %> 
        <%= msg%><br><br>
        <%= jh.loginBack()%>
        <% }%>
        
        <!--フォーム未入力の場合-->
        <%if(nullLogin != null){ %>
        <% for(String value:nullLogin){ %><b><%= value%></b>が未入力です。<br><br><% }%>
        <br><%= jh.loginBack()%>
        <% }%>
    </body>
</html>
