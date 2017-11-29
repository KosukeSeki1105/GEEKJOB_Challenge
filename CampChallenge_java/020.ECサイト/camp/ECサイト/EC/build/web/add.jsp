<%-- 
    Document   : add
    Created on : 2017/08/08, 18:25:13
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpSession"
        import="jums.UserData"
        import="jums.JumsHelper"%>
<%
    //セッションスタート
    //商品コード番号を格納する変数codeを作成
    //cartページ用に、セッションに商品コード番号を追加
    HttpSession hs = request.getSession();
    String code = (String)hs.getAttribute("code");
    hs.setAttribute("cart", code);
    
    hs.setAttribute("pageCheck", "add.jsp");
    String loginState = (String)hs.getAttribute("loginState");
    UserData userSearch = (UserData)hs.getAttribute("userSearch");
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カートへ商品を追加</title>
    </head>
    <body>
        <%if(loginState != null){ %>
            ようこそ<a href="mydata.jsp"><%= userSearch.getName()%></a>さん！
        <% }%>
        <h1>カートに追加しました。</h1>
        <%if(loginState != null){ %>
            <%= jh.cart()%><br><br>
            <%= jh.logout()%><br>            
        <% }else{ %>
            <%= jh.login()%>
        <% }%>
    </body>
</html>
