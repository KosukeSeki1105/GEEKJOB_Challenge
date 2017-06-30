<%-- 
    Document   : Query_String_2
    Created on : 2017/06/30, 14:39:36
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
        <form action="./Result_QS_2.jsp" method="get">
            素因数分解を行います!<br>
            数値入力：
            <input type="text" name="num" maxlength=16><br>
            
            <input type="submit" name="btnSubmit" value="送信">
            
        </form>
        
    </body>
</html>
