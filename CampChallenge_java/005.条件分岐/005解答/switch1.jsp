<%-- 
    Document   : switch1
    Created on : 2017/09/30, 21:02:41
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--switch文を利用して、以下の処理を実現してください。-->
<!--1. 値が1なら「one」-->
<!--値が2なら「two」-->
<!--それ以外は「想定外」と表示する処理-->
<%
    out.print("switch文を利用して、以下の処理を実現します。<br>");
    out.print("値が1なら「one」<br>");
    out.print("値が2なら「two」<br>");
    out.print("それ以外は「想定外」と表示する処理<br><br>");

    int num = 1;
    
    switch(num) {
        case 1: 
            out.print("one");
            break;
        case 2:
            out.print("two");
            break;
        default:
            out.print("想定外");
            break;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>switch文1</title>
    </head>
    <body>
    </body>
</html>
