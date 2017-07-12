<%-- 
    Document   : product
    Created on : 2017/07/12, 15:21:00
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品情報管理</title>
    </head>
    <body>
        <form action="Result_product_1" method="post">
            ＊＊選択・記入してください＊＊<br><br>
            <input type="radio" name="see_write" value="see">商品一覧
            <input type="submit" name="submit" value="検索"><br><br><br>

            <input type="radio" name="see_write" value="write">商品登録（以下、すべて記入すること）<br>
            商品コード<br>
            <input type="text" name="code"><br>
            商品名<br>
            <input type="text" name="name"><br>
            単価<br>
            <input type="text" name="price"><br>
            在庫数<br>
            <input type="text" name="stock"><br>
            メーカー名<br>
            <input type="text" name="company"><br>
            <input type="submit" name="submit" value="登録"><br><br><br>
        </form>
        <form action="http://localhost:8080/SampleA/user_login.jsp">
            <input type="submit" name="logout" value="ログアウト">
        </form>
    </body>
</html>
