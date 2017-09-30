<%-- 
    Document   : create_array
    Created on : 2017/09/30, 21:17:52
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--以下の順番で、要素が格納された配列を作成してください。-->
<!--"10", "100", "soeda", "hayashi", "-20", "118", "END"-->
<%
    out.print("以下の順番で、要素が格納された配列を作成します。<br>");
    out.print("\"10\", \"100\", \"soeda\", \"hayashi\", \"-20\", \"118\", \"END\"<br><br>");

    String[] data = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};    
    
    int count = 0;
    out.print("配列の中身を表示<br>");
    for(String value:data) {
        count++;
        out.print(count + "番目：" + value + "<br>");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>配列の作成</title>
    </head>
    <body>
    </body>
</html>
