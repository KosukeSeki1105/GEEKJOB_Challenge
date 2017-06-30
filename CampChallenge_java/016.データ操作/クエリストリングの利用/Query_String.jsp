<%-- 
    Document   : Query_String
    Created on : 2017/06/30, 12:07:38
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>入力フィールド</title>
    </head>
    <body>
        <form action="./Result_QS.jsp" method="get">
            総額：
            <select name="total">
                <option value="1500">1500円
                <option value="3000">3000円
                <option value="4500">5000円
            </select>
            <br>
            
            個数；
            <select name="count">
                <option value="5">5個
                <option value="10">10個
                <option value="30">30個
            </select>
            <br>
            
            商品種別：
            <input type=radio name=type value="1">雑貨
            <input type=radio name=type value="2">生鮮食品
            <input type=radio name=type value="3">その他
            <br>
            
            <input type="submit"name="btnSubmit" value="送信">

        </form>
    </body>
</html>
