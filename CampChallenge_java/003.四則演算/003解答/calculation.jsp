<%-- 
    Document   : calculation
    Created on : 2017/09/30, 20:33:07
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--定数と変数を宣言し、それぞれに数値を入れて四則演算を行い、四則演算の結果をそれぞれ表示してください。-->
<%
    // 定数
    final int BASENUM = 100;
    
    // 変数
    int num = 10;
    
    // 四則演算
    out.print( "100 ＋ 10 = " + ( BASENUM + num ) + "<br>" );
    out.print( "100 － 10 = " + ( BASENUM - num ) + "<br>" );
    out.print( "100 × 10 = " + ( BASENUM * num ) + "<br>" );
    out.print( "100 ÷ 10 = " + ( BASENUM / num ) + "<br>" );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>四則演算</title>
    </head>
    <body>
    </body>
</html>
