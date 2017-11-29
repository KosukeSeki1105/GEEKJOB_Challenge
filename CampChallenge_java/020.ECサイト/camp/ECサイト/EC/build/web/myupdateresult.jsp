<%-- 
    Document   : myupdateresult
    Created on : 2017/08/08, 19:52:26
    Author     : guest1Day
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="java.util.HashMap"
        import="jums.UserData"
        import="jums.JumsHelper"%>

<%
    HttpSession hs             = request.getSession();
    ArrayList<String> al       = (ArrayList<String>)hs.getAttribute("nullData");
    HashMap<String, String> ur = (HashMap<String, String>)hs.getAttribute("updateresult");
    UserData ud                = (UserData)hs.getAttribute("userDetail");
    JumsHelper jh              = JumsHelper.getInstance();
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報（更新完了画面）</title>
    </head>
    <body>
        <!--if(未入力項目がある場合)
        <!--入力が不足していた場合はどの項目のデータが不足しているのかを表示。-->
        <!--loginに値を保持したまま遷移するリンクを表示。-->
        <!--else if(既に使用されているデータがある場合)-->
        <!--項目名およびフォームで入力された文字を出力-->
        <!--loginに値を保持したまま遷移するリンクを表示。-->
        <!--else-->
        <!--フォームの情報を出力-->
        <!--以上の内容で更新しました。-->
        <% if(al.size() != 0){ %>
            <h1>未入力項目</h1>
            <% for(String value:al){ %>
            <b><%= value%></b>が未入力です。<br><br>
            <% }%>
            <%= jh.myupdateBack()%>
        <% }else if(ur.size() != 0){ %>
            <h1>データ重複</h1>
            <% if(ur.get("name") != null){ %>
                ユーザー名：<b><%= ur.get("name")%></b>は既に使われています！<br>
            <% }%>
            <% if(ur.get("password") != null){ %>
                パスワード：<b><%= ur.get("password")%></b>は既に使われています！<br>
            <% }%>
            <% if(ur.get("mail") != null){ %>
                メールアドレス：<b><%= ur.get("mail")%></b>は既に使われています！<br>
            <% } %>
            <%= jh.myupdateBack()%>
        <% }else { %>
        <h1>会員情報変更完了</h1>
        ユーザー名：<%= ud.getName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        住所：<%= ud.getAddress()%><br><br>
        以上の内容で更新しました。<br><br>
        <%= jh.top()%>
        <% }%>
    </body>
</html>
