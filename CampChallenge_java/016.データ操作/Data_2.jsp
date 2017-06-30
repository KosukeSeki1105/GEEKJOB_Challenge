<%-- 
    Document   : Data_2
    Created on : 2017/06/30, 11:34:08
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><i>Hello World!</i></h1>
        <h3><u>Hello World!</u></h3>
        <h8><strike>Hello World!</strike><br></h8>
        
        <h3> H<sub>2</sub>O</h3>
        <h3>x<sup>2</sup>+y<sup>2</sup>=9</h3>
        
        <input type=file name="fname" size=3><br><br>
        <input type=reset value="取り消し"><br><br>
        
        血液型<br>
        <select name="bloodtipe">
            <option value="A">A型
            <option value="O">O型
            <option value="B">B型
            <option value="AB">AB型 
        </select><br><br>
           
           

        好きなくだもの<br>
        <select name="fruits" size=4 multiple>
            <option value="りんご">りんご
            <option value="いちご">いちご
            <option value="もも">もも
            <option value="なし">なし
            <option value="さくらんぼ">さくらんぼ
            <option value="バナナ">バナナ
            <option value="パイナップル">パイナップル
        </select>
    </body>
</html>

