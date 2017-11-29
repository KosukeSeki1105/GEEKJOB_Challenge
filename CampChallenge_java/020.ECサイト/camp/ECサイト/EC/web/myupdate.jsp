<%-- 
    Document   : myupdate
    Created on : 2017/08/08, 19:48:22
    Author     : seki-k
--%>

<%@page import="javax.servlet.http.HttpSession"
        import="jums.UserData"%>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("userDetail");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報（更新画面）</title>
    </head>
    <body>
        <h1>会員情報更新フォーム</h1>
        <form action="MyUpdateResult" method="POST">
        ユーザー名<br>
        <input type="text" name="name" value=<%if(ud != null){ %><%=ud.getName()%><% }%>><br><br>
        パスワード<br>
        <input type="text" name="password" value=<%if(ud != null){ %><%= ud.getPassword()%><% }%>><br><br>
        メールアドレス<br>
        <input type="text" name="mail" value=<%if(ud != null){ %><%= ud.getMail()%><% }%>><br><br>
        住所<br>
        <input type="text" name="address" value=<% if(ud != null){ %><%= ud.getAddress()%><% }%>><br><br>
        <input type="submit" name="submit" value="更新">
        </form>
    </body>
</html>
