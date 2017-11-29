<%-- 
    Document   : registrationcomplete
    Created on : 2017/08/08, 19:09:42
    Author     : guest1Day
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="jums.UserDataDTO"
        import="jums.JumsHelper"%>

<%
    UserDataDTO udd    = (UserDataDTO)request.getAttribute("registComp");
    JumsHelper jh  = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録（完了画面）</title>
    </head>
    <body>
        <h1>会員登録完了</h1>
        ユーザー名：<%= udd.getName()%><br>
        パスワード：<%= udd.getPassword()%><br>
        メールアドレス：<%= udd.getMail()%><br>
        住所：<%= udd.getAddress()%><br><br>
        
        以上の内容で登録しました。<br>
        <!--「トップページへ戻る」のリンクが、目立つ場所に設置されている-->
        <h1><%= jh.top()%></h1>
    </body>
</html>
