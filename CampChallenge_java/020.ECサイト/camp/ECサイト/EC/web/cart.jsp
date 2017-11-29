<%-- 
    Document   : cart
    Created on : 2017/08/08, 19:25:52
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="jums.JumsHelper"%>

<%
    //セッション("cart")の商品コード番号を取得
    HttpSession hs = request.getSession();
    String cart    = (String)hs.getAttribute("cart");
    
    //セッション("cart")を破棄
    hs.removeAttribute("cart");
    
    //セッション("cartplus")を呼び出し
    //if(cartplusがnullでない場合)　＊商品コードが存在する
    //商品コードを既存の配列に追加
    //セッション("cartplus")に格納
    //else　　　　　　　　　　　　　 ＊商品コードが存在しない
    //配列を作成
    //商品コードを追加
    //セッション("cartplus")に格納
//    ArrayList<String> cp = (ArrayList<String>)hs.getAttribute("cartplus");
//    if(cp!= null){
//        cp.add(cart);
//        hs.setAttribute("cartplus", cp);        
//    }else{
//        ArrayList<String> al = new ArrayList<String>();
//        al.add(cart);
//        hs.setAttribute("cartplus", al);
//    }
//    
//    ArrayList<String> cartplus = (ArrayList<String>)hs.getAttribute("cartplus");    
    

    //クエリストリング生成
    //item.jspでの表示の条件分岐のためのセッションを作成
    String qURL = "http://localhost:8080/EC/item.jsp?Code=";
    hs.setAttribute("cartPage", "cart.jsp");

    JumsHelper jh = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>カートページ</title>
    </head>
    <body>        
        <h1>カートの中身</h1><br>
        
        <!--商品の写真と名前(リンクつき)、金額を表示。-->
        <script src="https://s.yimg.jp/images/yjdn/js/bakusoku-jsonp-v1-min.js"
           data-url="https://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemLookup"
           data-p-appid="dj00aiZpPXd5b2dXaGpMQ1EyRSZzPWNvbnN1bWVyc2VjcmV0Jng9Mjk-"
           data-p-itemcode=<%= cart%>
           data-p-responsegroup=small
        >
        {{#ResultSet.0.Result}}
            {{#0}}
            <img src="{{Image.Small}}"><a href=<%=qURL%>{{ItemCode.0.Code}}><li>{{Name}}{{Price._value}}円(税込)</a></li><br><br>
            {{/0}}
        {{/ResultSet.0.Result}}
        </script>
        
        
        <br><br><%= jh.top()%>
    </body>
</html>
