<%-- 
    Document   : for1
    Created on : 2017/09/30, 21:43:13
    Author     : k-seki
--%>

<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--for文を利用して、8を20回掛ける処理を実現してください。（8の20乗）-->
<%
    // カンマ区切り形式のフォーマットを生成
    NumberFormat nf = NumberFormat.getNumberInstance();
    
    long num = 1;
    for( int i = 1; i <= 20; i++ ) {
        num *= 8;
        out.print( "8の" + i + "乗：" + nf.format( num ) + "<br>" );
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>for文1</title>
    </head>
    <body>
    </body>
</html>
