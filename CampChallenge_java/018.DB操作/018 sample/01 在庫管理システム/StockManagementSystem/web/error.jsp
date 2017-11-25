<%-- 
    Document   : error
    Created on : 2017/11/23, 2:24:09
    Author     : k-seki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--MVCモデルに則りJSTLを使用-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>エラーページ</title>
    </head>
    <body>
        
        <!--errorというプロパティ名のスコープに値がある場合-->
        <c:if test="${not empty error}">
            ${error}
        </c:if>
    </body>
</html>
