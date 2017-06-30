<%-- 
    Document   : Data_1
    Created on : 2017/06/30, 9:59:29
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
        <form action="./resultData_1.jsp" method="post">
        名前
           <input type="text"name="txtName"><h1></h1>
        
            <input type="radio"name="rdoSample"value="男">男
            <input type="radio"name="rdoSample"value="女">女<h1></h1>
        趣味
            <textarea name="mulText"></textarea><h1></h1>
            <input type="submit"name="btnSubmit" value="送信">
        </form>
    </body>
</html>
