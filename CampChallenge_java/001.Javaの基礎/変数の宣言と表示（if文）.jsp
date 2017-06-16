<%-- 
    Document   : 変数の宣言と表示（if文）
    Created on : 2017/06/16, 17:05:39
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int num = 2;
    
    if(num==1){
        out.print("1です！");
    }else if(num==2){
        out.print("プログラミングキャンプ！");
    }else {
        out.print("その他です！");
    }
    
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    </body>
</html>
