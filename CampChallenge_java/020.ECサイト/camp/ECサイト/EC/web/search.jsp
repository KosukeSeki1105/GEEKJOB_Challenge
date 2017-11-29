<%-- 
    Document   : search
    Created on : 2017/08/08, 18:10:24
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpServletResponse"
        import="javax.servlet.http.HttpSession"
        import="jums.UserData"
        import="jums.JumsHelper"%>

<%
    //文字コードをUTF-8に変更
    //検索フォームに入力されたデータをString型に格納
    request.setCharacterEncoding("UTF-8");
    String search = request.getParameter("search");    
    
    //クエリストリング生成
    String qURL = "http://localhost:8080/EC/item.jsp?Code=";
    
    //セッションスタート
    //ログイン後用にページ情報を格納
    //ログイン情報を取得
    //「ようこそ○○さん」に対応するようログインしているユーザー名を取得
    HttpSession hs = request.getSession();
    hs.setAttribute("pageCheck", "search.jsp");
    String loginState = (String)hs.getAttribute("loginState");
    UserData userSearch = (UserData)hs.getAttribute("userSearch");
    
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>結果一覧</title>
    </head>
    <body>        
        <%if(loginState != null){ %>
            ようこそ<a href="mydata.jsp"><%= userSearch.getName()%></a>さん！<br><br>
        <% }%>
        
        <%if(loginState != null){ %>
            <%= jh.cart()%><br><br>
            <%= jh.logout()%><br>            
        <% }else{ %>
            <%= jh.login()%>
        <% }%>
        
        <h1>検索結果</h1>上位10件を表示します。
        <script src="https://s.yimg.jp/images/yjdn/js/bakusoku-jsonp-v1-min.js"
           data-url="http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch"
           data-p-appid="dj00aiZpPXd5b2dXaGpMQ1EyRSZzPWNvbnN1bWVyc2VjcmV0Jng9Mjk-"
           data-p-query=<%= search%>
           data-p-sort="-score"
        >
               
            {{#ResultSet.0.Result}}
            <%for(int i = 1; i <= 10; i++){ %>
                {{#<%=i%>}}<li><img src="{{Image.Medium}}" alt="{{Name}}"><a href= <%=qURL%>{{Code}}>{{Name}}{{Price._value}}円（税込）</a></li><br><br>{{/<%=i%>}}                
            <%} %>
            {{/ResultSet.0.Result}}
       
        </script>        
    </body>
</html>
