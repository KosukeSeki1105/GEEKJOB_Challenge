<%-- 
    Document   : db_12
    Created on : 2017/07/11, 17:30:54
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>複合検索</title>
    </head>
    <body>
        <form action="./Result_db_12" method="post">
            <u>データ検索</u><br><br>
            名前<br>
            <input type="text" name="name"><br>
            年齢<br>
            <input type="text" name="age"><br>
            生年月日<br>
            <input type="text" name="birthday"><br><br>
            <input type="radio" name="and_or" value="and">AND検索<br>
            <input type="radio" name="and_or" value="or">OR検索<br>
            <input type="submit" name="submit" value="検索">
        </form>
    </body>
</html>
