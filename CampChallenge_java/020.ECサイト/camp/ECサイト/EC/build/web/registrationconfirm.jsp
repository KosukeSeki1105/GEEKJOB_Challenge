<%-- 
    Document   : registrationconfirm
    Created on : 2017/08/08, 18:51:57
    Author     : seki-k
--%>
<%@page import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"
        import="java.util.HashMap"
        import="jums.UserData"
        import="jums.JumsHelper"%>

<%
    HttpSession hs             = request.getSession();
    ArrayList<String> al       = (ArrayList<String>)hs.getAttribute("nullData");
    HashMap<String, String> rc = (HashMap<String, String>)hs.getAttribute("resultConfirm");
    UserData ud                = (UserData)hs.getAttribute("registration");
    JumsHelper jh              = JumsHelper.getInstance();
%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員登録（確認画面）</title>
    </head>
    <body>
        <h1>会員登録情報確認</h1>
        
        <!--if(未入力項目がある場合)
        <!--入力が不足していた場合はどの項目のデータが不足しているのかを表示。-->
        <!--loginに値を保持したまま遷移するリンクを表示。-->
        <!--else if(既に使用されているデータがある場合)-->
        <!--項目名およびフォームで入力された文字を出力-->
        <!--loginに値を保持したまま遷移するリンクを表示。-->
        <!--else-->
        <!--以上の内容で登録いたします。よろしいですか？-->
        <%if(al.size() != 0){ %>
            <h1>未入力項目</h1>
            <%for(String value:al){ %>
                <b><%=value%></b>が未入力です。<br><br>
            <% }%>
            <br><%= jh.registrationBack()%>
        <% } else if(rc.size() != 0){ %>
            <h1>データ重複</h1>
            <% if(rc.get("name") != null) {%>
                ユーザー名：<b><%= rc.get("name")%></b>は既に使われています！<br>
            <% }%>
            <% if(rc.get("password") != null){ %>
                パスワード：<b><%= rc.get("password")%></b>は既に使われています！<br>
            <% }%>
            <% if(rc.get("mail") != null){ %>
                メールアドレス：<b><%= rc.get("mail")%></b>は既に使われています！<br>
            <% }%>
            <br><%= jh.registrationBack()%>    
        <% } else{ %>
        ユーザー名：<%= ud.getName()%><br>
        パスワード：<%= ud.getPassword()%><br>
        メールアドレス：<%= ud.getMail()%><br>
        住所：<%= ud.getAddress()%><br><br>        
        以上の内容で登録いたします。よろしいですか？<br>
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="submit" value="はい"><br>
        </form>
        <form action="registration.jsp" method="POST">
            <input type="submit" name="submit" value="いいえ">
        </form>
        <%}%>
    </body>
</html>
