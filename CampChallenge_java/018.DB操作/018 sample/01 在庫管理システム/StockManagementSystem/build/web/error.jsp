<%-- 
    Document   : error
    Created on : 2017/11/23, 2:24:09
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--MVCモデルに則りJSTLを使用-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- CSSを使用 -->
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>エラーページ</title>
    </head>
    <body>
        <div id="container">
        
            <!-- ヘッダー -->
            <div id="header">
                <h1>在庫管理システム</h1>
            </div>
            
            <!--エラーメッセージ-->
            <!--errorというプロパティ名のスコープに値がある場合-->
            <c:if test="${not empty error}">
                <div class="messageError">
                    ${error}
                </div>
            </c:if>
        
            <!--メインコンテンツ-->
            <div id="main">
                &raquo;<a href="/StockManagementSystem/">トップページ</a>
            </div>
            
            <!-- フッター -->
            <div id="footer">
                &copy; StockManagementSystem 在庫管理システム
            </div>    
            
        </div>
    </body>
</html>
