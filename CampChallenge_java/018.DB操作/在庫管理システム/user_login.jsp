<%-- 
    Document   : user_login
    Created on : 2017/07/12, 13:44:41
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        ＊＊＊ログインフォーム＊＊＊<br><br>
        
        <%
//        HttpSession session1 = request.getSession(true);
//        
//        //認証失敗から呼び出されたのかどうか
//        Object status = session1.getAttribute("status");
//        
//        if(status != null){
        %>
<!--            認証に失敗しました
            再度ユーザー名とパスワードを入力してください-->
        <%
//            session.setAttribute("status", null);
//            }
//        %>    
        
        <form action="./Result_user_login" method="post">
            ユーザー名<br>
            <input type="text" name="user"><br>
            パスワード<br>
            <input type="text" name="password"><br>
            <input type="submit" name="submit" value="送信">
        </form>
    </body>
</html>
