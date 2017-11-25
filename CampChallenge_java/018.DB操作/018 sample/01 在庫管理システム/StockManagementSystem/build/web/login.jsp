<%-- 
    Document   : login
    Created on : 2017/11/22, 21:49:43
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--MVCモデルに則りJSTLを使用-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログインページ</title>
    </head>
    <body>
        <div>ログイン</div>
        
        <!--messageというプロパティ名のスコープに値がある場合-->
        <c:if test="${not empty message}">
            ${message}
        </c:if>
        
        <form action="Login" method="POST">
            <p>ユーザー名：<input type="text" name="name" size="15" value="${name}"></p>
            <p>パスワード：<input type="password" name="password" size="15" value=""></p>
            <input type="submit" value="ログイン">
        </form>
        
    </body>
</html>
