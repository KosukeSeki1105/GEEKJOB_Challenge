<%-- 
    Document   : hashmap
    Created on : 2017/09/30, 21:34:43
    Author     : k-seki
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--以下の順で、連想配列を作成してください。-->
<!--"1"に"AAA", "hello"に"world", "soeda"に"33", "20"に"20"-->
<%
    // HashMapの作成
    HashMap<String, String> data = new HashMap<String, String>();
    
    // 要素の追加
    data.put( "1", "AAA" );
    data.put( "hello", "world" );
    data.put( "soeda", "33" );
    data.put( "20", "20" );
    
    /**
     * 要素が格納されたかどうかの確認
     */
    // HashMapの要素を表示
    out.print( "1： " + data.get( "1" ) + "<br>" );
    out.print( "hello： " + data.get( "hello" ) + "<br>" );
    out.print( "soeda： " + data.get( "soeda" ) + "<br>" );
    out.print( "20： " + data.get( "20" ) + "<br>" );
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>連想配列の作成</title>
    </head>
    <body>
    </body>
</html>
