<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper"%>
<%@page import="jums.InsertResult"%>
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.UserDataDTO"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    UserDataDTO userdata = (UserDataDTO)hs.getAttribute("userdata");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= userdata.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= userdata.getType()%><br>
        電話番号:<%= userdata.getTell()%><br>
        自己紹介:<%= userdata.getComment()%><br>
        以上の内容で登録しました。<br>
    </body>
    <%
    //セッションの破棄
    hs.removeAttribute("ac");
    hs.removeAttribute("udb");
    hs.removeAttribute("userdata");
    %>
        <br>
        <%=JumsHelper.getInstance().home()%>
</html>
