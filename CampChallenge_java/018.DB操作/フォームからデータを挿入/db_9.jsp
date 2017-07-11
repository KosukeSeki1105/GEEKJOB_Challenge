<%-- 
    Document   : db_9
    Created on : 2017/07/11, 13:42:34
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DBへデータ挿入</title>
    </head>
    <body>
        <form action="./Result_db_9" method="post">
            <u>データ登録</u><br><br>
            ID<br>
            <input type="text" name="profilesID"><br>
            名前<br>
            <input type="text" name="name"><br>
            電話番号<br>
            <input type="text" name="tell"><br>
            年齢<br>
            <input type="text" name="age"><br>
            生年月日<br>
            <input typoe="text" name="birthday"><br><br>
            <input type="submit" name="submit" value="登録">
            
            
            
        </form>
        
    </body>
</html>
