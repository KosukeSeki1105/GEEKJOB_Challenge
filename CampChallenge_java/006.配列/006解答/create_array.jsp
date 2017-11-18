<%-- 
    Document   : create_array
    Created on : 2017/09/30, 21:17:52
    Author     : k-seki
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--以下の順番で、要素が格納された配列を作成してください。-->
<!--"10", "100", "soeda", "hayashi", "-20", "118", "END"-->
<%
    // ArrayList作成
    ArrayList<String> al = new ArrayList<String>();
    
    // ArrayListに格納する要素
    String[] data = { "10", "100", "soeda", "hayashi", "-20", "118", "END" };    

    // 拡張for文でArrayListに要素を格納
    for( String value : data ) {
        al.add( value );
    }
    
    /**
     * 要素が格納されたかどうかの確認
     */
    // 順番用カウンタ
    int count = 1;

    // 拡張for文でArrayListの要素を表示
    for( String value : al ) {
        out.print( count + "番目：" + value + "<br>" );
        count++;
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
