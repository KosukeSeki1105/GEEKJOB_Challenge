<%-- 
    Document   : update_array
    Created on : 2017/09/30, 21:23:33
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--課題「配列の作成」で作成した配列の"soeda"を"33"に変更してください。-->
<%
    out.print("課題「配列の作成」で作成した配列の\"soeda\"を\"33\"に変更します。<br><br>");
    
    String[] data = {"10", "100", "soeda", "hayashi", "-20", "118", "END"};
    int count = 0;
    out.print("配列の中身を表示<br>");
    for(String value:data) {
        count++;
        out.print(count + "番目：" + value + "<br>");
    }
    
    count = 0;
    out.print("<br>配列の３番目の中身を\"soeda\"から\"33\"に変更<br>");
    data[2] = "33";
    for(String value:data) {
        count++;
        out.print(count + "番目：" + value + "<br>");
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>配列の変更</title>
    </head>
    <body>
    </body>
</html>
