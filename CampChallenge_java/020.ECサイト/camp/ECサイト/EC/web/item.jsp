<%-- 
    Document   : item
    Created on : 2017/08/08, 18:18:25
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpServletRequest" 
        import="javax.servlet.http.HttpSession"
        import="jums.UserData"
        import="jums.JumsHelper"%>
<%
    //文字コードをUTF-8に変更
    //Code番号を格納する変数codeを作成
    //セッションに商品codeを格納
    request.setCharacterEncoding("UTF-8");
    String code = request.getParameter("Code");
    HttpSession hs = request.getSession();
    hs.setAttribute("code", code);
    
    //cart.jspからの遷移に対応するためにセッション取得
    String cart = (String)hs.getAttribute("cartPage");
    
    hs.setAttribute("pageCheck", "item.jsp");
    String loginState = (String)hs.getAttribute("loginState");
    UserData userSearch = (UserData)hs.getAttribute("userSearch");
    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品詳細ページ</title>
    </head>
    <body>
        <%if(loginState != null){ %>
            ようこそ<a href="mydata.jsp"><%= userSearch.getName()%></a>さん！
        <% }%>
        
        <h1>商品詳細</h1>
        <script src="https://s.yimg.jp/images/yjdn/js/bakusoku-jsonp-v1-min.js"
           data-url="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup"
           data-p-appid="dj00aiZpPXd5b2dXaGpMQ1EyRSZzPWNvbnN1bWVyc2VjcmV0Jng9Mjk-"
           data-p-itemcode=<%= code%>
           data-p-responsegroup=medium
        >
        {{#ResultSet.0.Result}}
            {{#0}}
                <img src="{{Image.Medium}}"> <br>
                商品名<br>{{Name}} <br><br>
                商品説明<br>{{Description}} <br><br>
                    {{#Review}}
                        レビュー平均評価：{{Rate}} <br>
                        レビュー保持数： {{Count}} <br><br>
                    {{/Review}}
                        {{#PriceLabel}}
                                税抜きメーカ希望小売価格： {{DefaultPrice}}円<br>
                                税抜き通常販売価格： {{BaseDefaultPrice}}円<br><br>
                                在庫数：{{Point.Amount}}
                        {{/PriceLabel}}
            {{/0}}
        {{/ResultSet.0.Result}}
         </script>

        <!--「カートに追加する」ボタンがあり、クリックするとaddに遷移する。
             cart.jspから遷移してきたかどうかの表示分岐-->
            <%= jh.add()%><br><br>
        <%if(loginState != null){ %>
            <%= jh.logout()%><br>            
        <% }else{ %>
            <%= jh.login()%>
        <% }%>
    </body>
</html>
