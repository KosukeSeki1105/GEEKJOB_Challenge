<%-- 
    Document   : registrationconfirm
    Created on : 2017/08/08, 18:51:57
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="jums.UserData"%>

<%
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("registration");
%>

<!--もし入力が不足していた場合はどの項目のデータが不足しているのかを表示。-->
<!--if文で条件分岐-->
<!--insertに値を保持したまま遷移するリンクを表示。-->
<!--それ以外-->
<!--以上の内容で登録いたします。よろしいですか？-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録（確認画面）</title>
    </head>
    <body>
        <h1>会員登録情報確認</h1>
        ユーザー名：<%= ud.getUserName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        住所：<%= ud.getAddress()%><br><br>
        
        以上の内容で登録いたします。よろしいですか？<br>
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="submit" value="はい"><br>
        </form>
        <form action="registration.jsp" method="POST">
            <input type="submit" name="submit" value="いいえ">
        </form>
    </body>
</html>
