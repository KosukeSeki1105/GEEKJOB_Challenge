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
        <!-- CSSを使用 -->
        <link rel="stylesheet" type="text/css" href="style.css">
        <!--アイコン設定-->
        <link rel="icon" href="kuma.ico">
        <title>在庫管理ログイン</title>
    </head>
    <body>
        <div id="container">
        
            <!-- ヘッダー -->
            <div id="header">
                <h1>在庫管理システム</h1>
            </div>

            <!-- エラーメッセージ -->
            <!--messageというプロパティ名のスコープに値がある場合-->
            <c:if test="${not empty message}">
                <div class="messageError">
                    ${message}
                </div>
            </c:if>

            <!-- メインコンテンツ -->
            <div id="main">
                <p>ユーザー名とパスワードを入力してください。</p>

                <form action="Login" method="POST">
                    <p>ユーザー名：<input type="text" name="name" size="15" value="${name}"></p>
                    <p>パスワード：<input type="password" name="password" size="15"></p>
                    <input type="submit" value="ログイン">
                </form>
            </div>
            
            <!-- フッター -->
            <div id="footer">
                &copy; StockManagementSystem 在庫管理システム
            </div>

        </div>
    </body>
</html>
