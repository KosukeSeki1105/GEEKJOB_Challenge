<%-- 
    Document   : register_product
    Created on : 2017/11/23, 11:39:01
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
        <!--アイコン設定-->
        <link rel="icon" href="kuma.ico">
        <title>商品情報登録・更新</title>
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
        
            <!-- エラーメッセージ -->
            <!--messageというプロパティ名のスコープに値がある場合-->
            <c:if test="${not empty message}">
                <div class="messageError">
                    ${message}
                </div>
            </c:if>
        
            <!-- メインコンテンツ -->
            <div id="main">
                <h3>商品を新規に登録する場合はこちら</h3>
                <p>商品名・単価を入力してください。在庫の入力は任意です。<br>
                    ※在庫の入力がない場合、デフォルトは0になります。</p>
                <form action="InsertProduct" method="Post">
                    <input type="hidden" name="loginCheck" value="${loginCode}">
                    <p>商品名：<input type="text" name="productName" size="50" value="${productName}"><br>
                    単価：<input type="text" name="price" size="4" value="${price}">(円)<br>
                    在庫数：<input type="text" name="stock" size="4" value="${stock}"><br>
                    <input type="submit" value="商品登録"></p><br>
                </form>
                
                <h3>登録済みの商品情報を更新する場合はこちら</h3>
                <p>商品名を選択し、単価・在庫を入力してください。</p>
                <form action="UpdateProduct" method="Post">
                    <input type="hidden" name="loginCheck" value="${loginCode}">
                    <p>商品名：
                        <select name="productID">
                            <c:forEach var="product" items="${productsIDName}" varStatus="status">
                                <option value="${product.productID}">${product.productName}</option>
                            </c:forEach>
                        </select><br>
                    単価：<input type="text" name="price" size="4" value="${priceU}">(円)<br>
                    在庫数：<input type="text" name="stock" size="4" value="${stockU}"><br>
                    <input type="submit" value="更新"></p>
                </form>
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
