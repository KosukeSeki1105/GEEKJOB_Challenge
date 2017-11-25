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
        <title>商品情報登録</title>
    </head>
    <body>
        <p>ログイン名：${name}</p>
        
        <!--messageというプロパティ名のスコープに値がある場合-->
        <c:if test="${not empty message}">
            ${message}
        </c:if>
        
        
        <p>商品を新規に登録する場合はこちら</p>
        <p>商品名・単価を入力してください。在庫の入力は任意です。</p>
        <p>在庫の入力がない場合デフォルトは0になります。</p>
        
        <form action="InsertProduct" method="Post">
            <input type="hidden" name="loginCheck" value="${loginCode}">
            <p>商品名：<input type="text" name="productName" size="50" value="${productName}"></p>
            <p>単価：<input type="text" name="price" size="4" value="${price}">円</p>
            <p>在庫数：<input type="text" name="stock" size="4" value="${stock}"></p>
            <p><input type="submit" value="商品登録"></p><br>
        </form>
        
        <p>登録済みの商品情報を更新する場合はこちら</p>
        <p>商品名を選択し、単価・在庫を入力してください。</p>
        <form action="UpdateProduct" method="Post">
            <input type="hidden" name="loginCheck" value="${loginCode}">
            
            <p>商品名：
            <select name="productID">
                <c:forEach var="productName" items="${productNames}" varStatus="status">
                    <option value="${productName.productID}">${productName.productName}</option>
                </c:forEach>
            </select>
            </p>
            
            <p>単価：<input type="text" name="price" size="4" value="${priceU}">円</p>
            <p>在庫数：<input type="text" name="stock" size="4" value="${stockU}"></p>
            <p><input type="submit" value="更新"></p>
        </form>
        
    </body>
</html>
