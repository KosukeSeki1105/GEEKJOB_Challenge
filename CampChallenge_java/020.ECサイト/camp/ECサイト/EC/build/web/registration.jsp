<%-- 
    Document   : registration
    Created on : 2017/08/08, 18:42:47
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpServlet;"
        import="jums.UserData"%>

<!--「いいえ」でregistrationconfirmから戻ってきた場合、値を保持して記入済みに-->
<%
    HttpSession hs = request.getSession();
    UserData ud    = (UserData)hs.getAttribute("registration");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録（入力画面）</title>
    </head>
    <body>
        <h1>会員登録フォーム</h1>
        <form action="RegistrationConfirm" method="POST">            
        ユーザー名<br>
        <input type="text" name="name" value=<%if(ud != null){ %><%= ud.getName()%><% }%>><br><br>
        パスワード<br>
        <input type="text" name="password" value=<%if(ud != null){ %><%= ud.getPassword()%><% }%>><br><br>
        メールアドレス<br>
        <input type="text" name="mail" value="<%if(ud != null){ %><%= ud.getMail()%><% }%>"><br><br>
        住所<br>
        <input type="text" name="address" value="<%if(ud != null){ %><%= ud.getAddress()%><% }%>"><br><br>
        <input type="submit" name="submit" value="登録">
        </form>
    </body>
</html>
