<%-- 
    Document   : db_10
    Created on : 2017/07/11, 15:35:06
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>データ削除</title>
    </head>
    <body>
        <form action="./Result_db_10" method="post">
            <u>データ削除</u><br><br>
            削除するID<br>
            <input type="text" name="profilesID">
            <input type="submit" name="submit" value="送信">
        </form>
    </body>
</html>
