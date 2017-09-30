<%-- 
    Document   : if
    Created on : 2017/09/30, 20:53:10
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--変数を宣言し、その変数の中身によって以下の表示を行ってください-->
<!--1. 値が 1 なら「１です！」-->
<!--値が 2 なら「プログラミングキャンプ！」-->
<!--それ以外なら「その他です！」-->
<%
    out.print("変数を宣言し、その変数の中身によって以下の表示を行います。<br>");
    out.print("値が 1 なら「１です！」<br>");
    out.print("値が 2 なら「プログラミングキャンプ！」<br>");
    out.print("それ以外なら「その他です！」<br><br>");
    
    int num = 3;
    
    if(num == 1) {
        out.print("1です!");
    } else if(num == 2) {
        out.print("プログラミングキャンプ!");
    } else {
        out.print("その他です!");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>変数の宣言と表示(if文)</title>
    </head>
    <body>
    </body>
</html>
