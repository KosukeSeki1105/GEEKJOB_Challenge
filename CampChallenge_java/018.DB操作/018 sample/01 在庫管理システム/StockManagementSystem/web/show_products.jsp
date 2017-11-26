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
        <!-- CSSを使用 -->
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>商品一覧</title>
    </head>
    <body>
        <div id="container">
        
            <!-- ヘッダー -->
            <div id="header">
                <h1>在庫管理システム</h1>
                
                <div id="login">
                    ログイン名：${name}
                </div>
            </div>
        
            <!-- メインコンテンツ -->
            <div id="main">
                <table border="1" cellspacing="0">
                    <tr>
                        <th>商品ID</th>
                        <th>商品名</th>
                        <th>単価</th>
                        <th>在庫</th>
                        <th>最終更新日時</th>
                    </tr>
                    <c:forEach var="product" items="${bean}" varStatus="status">
                        <tr id="product">
                            <td>${product.productID}</td>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>${product.stock}</td>
                            <td>${product.updateTime}</td>
                        </tr>
                    </c:forEach>
                </table>
                <br>
                <br>
                &raquo;<a href="manegement_option.jsp">商品情報登録・一覧</a>
                <br>
                &raquo;<a href="Logout">ログアウト</a>
            </div>
        
            <!-- フッター -->
            <div id="footer">
                &copy; StockManagementSystem 在庫管理システム
            </div>
        
        </div>
    </body>
</html>
