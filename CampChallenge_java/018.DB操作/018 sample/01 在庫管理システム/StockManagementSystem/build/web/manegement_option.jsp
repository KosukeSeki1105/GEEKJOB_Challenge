<%-- 
    Document   : manegement_option
    Created on : 2017/11/23, 2:30:40
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.ProductBean"%>
<!--MVCモデルに則りJSTLを使用-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品情報登録・一覧</title>
    </head>
    <body>
        <p>ログイン名：${name}</p>
        
        <c:if test="${not empty processMsg}">
            ${processMsg}
        </c:if>
        
        <form action="SelectProduct" method="POST">
            <input type="hidden" name="select" value="productName">
            <p>
            <input type="submit" value="商品情報登録"><br>
            </p>
        </form>
        <form action="SelectProduct" method="POST">
            <input type="hidden" name="select" value="productAll">
            <p>
            <input type="submit" value="商品一覧">
            </p>
        </form>
        
        <a href="Logout">ログアウト</a>
    </body>
</html>
