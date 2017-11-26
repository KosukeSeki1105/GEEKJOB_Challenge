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
        <!-- CSSを使用 -->
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>商品情報登録・一覧</title>
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

            <!-- 処理成功メッセージ -->
            <!-- processMsgというプロパティ名のスコープに値がある場合 -->
            <c:if test="${not empty processMsg}">
                <div class="messageNotice">
                    ${processMsg}
                </div>
            </c:if>
        
            <!--メインコンテンツ-->
            <div id="main">
                <p>新規に商品情報を登録、もしくは既に登録済みの商品情報を更新する場合はこちら</p>                
                <form action="SelectProduct" method="POST">
                    <input type="hidden" name="select" value="productIDName">
                    &raquo;<input type="submit" value="商品情報登録・更新">
                </form>
                <br>
                <p>全ての商品情報を閲覧したい場合はこちら</p>
                <form action="SelectProduct" method="POST">
                    <input type="hidden" name="select" value="productAll">
                    &raquo;<input type="submit" value="商品一覧">
                </form>
                <br>
                <br>
                &raquo;<a id="logout" href="Logout">ログアウト</a>
            </div>

            <!-- フッター -->
            <div id="footer">
                &copy; StockManagementSystem 在庫管理システム
            </div>
            
        </div>
    </body>
</html>
