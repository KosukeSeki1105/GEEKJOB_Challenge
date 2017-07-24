<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.InsertConfirm" %>
<%@page import="jums.UserDataBeans" %>
<%@page import="java.util.*"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    HashMap<Integer, String> eMsg = (HashMap<Integer, String>)hs.getAttribute("eMsg");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    
    <% if(eMsg.size() == 0){ %>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%= udb.getType()%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac" value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
        <%for(Map.Entry<Integer, String> val: eMsg.entrySet()){ %>
        <br><b><%=val.getValue()%></b><% } %>が未入力です。
    <% } %>
        <form action="insert" method="POST">
            <br><input type="submit" name="no" value="登録画面に戻る">
        </form>
    </body>
        <!--課題１-->
        <br>
        <%=JumsHelper.getInstance().home()%>
</html>
