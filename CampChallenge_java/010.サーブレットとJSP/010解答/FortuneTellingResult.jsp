<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/09/30, 23:42:09
    Author     : k-seki
--%>
<%@page import="org.camp.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>占い結果</title>
    </head>
    <body>
        <h3>（・ω・）/ あなたの ${DATA.d} の運勢（・ω・）/</h3>
        ${DATA.message}
        <font color="RED"><b>${DATA.luck}！！</b></font> 
    </body>
</html>
