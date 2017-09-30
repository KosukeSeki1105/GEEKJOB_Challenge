<%-- 
    Document   : connection
    Created on : 2017/09/30, 20:45:56
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--「groove」「-」「gear」の３つの文字列を連結して表示してください-->
<%
    out.print("「groove」「-」「gear」の３つの文字列を連結して表示します。<br><br>");
    
    String str1 = "groove";
    char str2 = '-';
    String str3 = "gear";
    
    out.print(str1 + str2 + str3);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>groove-gearの表示</title>
    </head>
    <body>
    </body>
</html>
