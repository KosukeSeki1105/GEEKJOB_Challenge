<%-- 
    Document   : login
    Created on : 2017/08/08, 18:39:03
    Author     : seki-k
--%>
<%@page import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"
        import="java.util.HashMap"%>

<%
    HttpSession hs                    = request.getSession();
    HashMap<String, String> loginNull = (HashMap<String, String>)hs.getAttribute("loginNull");
    JumsHelper jh                     = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ログインページ</h1>
        <form action="LoginResult" method="POST">
        ユーザー名<br>
        <input type="text" name="name" value=<%if(loginNull != null){ %><%= loginNull.get("name")%><% }%>><br><br>
        パスワード<br>
        <input type="text" name="password" value=<%if(loginNull != null){ %><%= loginNull.get("password")%><% }%>><br><br>
        <input type="submit" name="submit" value="ログイン"><br><br>
        </form>
        <br><%= jh.registration()%>
        
    </body>
</html>
