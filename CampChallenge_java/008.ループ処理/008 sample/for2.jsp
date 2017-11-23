<%-- 
    Document   : for2
    Created on : 2017/09/30, 21:50:35
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--for文を利用して、適当な変数へ文字連結を行い、中に"A"が30個入った状態にしてください。-->
<%
    // 変数宣言
    String name = "（・ω・）/";
    
    for( int i = 1; i <= 30; i++ ) {
        name += "A";
        out.print( i + "個目：" + name + "<br>" );
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文2</title>
    </head>
    <body>
    </body>
</html>
