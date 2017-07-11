<%-- 
    Document   : db_11
    Created on : 2017/07/11, 16:38:09
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>情報の更新</title>
    </head>
    <body>
        <form action="./Result_db_11" method="post">
            <u>個人情報の更新</u><br><br>
            ID<br>
            <input type="text" name="profilesID"><br>
            名前<br>
            <input type="text" name="name"><br>
            電話番号<br>
            <input type="text" name="tell"><br>
            年齢<br>
            <input type="text" name="age"><br>
            生年月日<br>
            <input type="text" name="birthday"><br><br>
            <input type="submit" name="submit" value="送信"><br>
        </form>
    </body>
</html>
