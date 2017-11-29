<%-- 
    Document   : top
    Created on : 2017/08/08, 17:53:08
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpSession"        
        import="jums.UserData"
        import="jums.JumsHelper"%>

<%    
    HttpSession hs = request.getSession();
    hs.setAttribute("pageCheck", "top.jsp");
    String loginState = (String)hs.getAttribute("loginState");
    UserData userSearch = (UserData)hs.getAttribute("userSearch");
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>トップページ</title>
    </head>
    <body>
        <%if(loginState != null){ %>
            ようこそ<a href="MyData"><%= userSearch.getName()%></a>さん！                        
        <% }%>
        <h1>かごゆめ</h1>
        『金銭取引が絶対に発生しない』<br>
        『いくらでも、どんなものでも購入できる(気分になれる)』<br>
        『ECサイト』<br><br>
        
        <form action="search.jsp" method="GET">
            <input type="text" name="search">            
            <input type="submit" name="submit" value="検索"><br><br>            
        </form>
        <%if(loginState != null){ %>
            <%= jh.cart()%><br><br>
            <%= jh.logout()%><br>            
        <% }else{ %>
            <%= jh.login()%>
        <% }%>        
    </body>
</html>
