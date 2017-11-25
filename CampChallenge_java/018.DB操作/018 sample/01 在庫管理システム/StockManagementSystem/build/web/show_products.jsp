<%-- 
    Document   : show_products
    Created on : 2017/11/26, 0:19:50
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
        <title>商品一覧</title>
    </head>
    <body>
        
        <table border="1">
            <tr>
                <th>商品ID</th>
                <th>商品名</th>
                <th>単価</th>
                <th>在庫</th>
                <th>最終更新日時</th>
            </tr>
            <c:forEach var="product" items="${bean}" varStatus="status"> 
                <tr>
                    <td>${product.productID}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.stock}</td>
                    <td>${product.updateTime}</td>
                </tr>
            </c:forEach>
        </table>
        
        <a href="Logout">ログアウト</a>
    </body>
</html>
