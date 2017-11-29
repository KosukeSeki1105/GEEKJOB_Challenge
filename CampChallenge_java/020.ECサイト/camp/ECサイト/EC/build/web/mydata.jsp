<%-- 
    Document   : mydata
    Created on : 2017/08/08, 19:42:25
    Author     : seki-k
--%>

<%@page import="javax.servlet.http.HttpSession"
        import="jums.UserData"
        import="java.text.SimpleDateFormat"
        import="jums.JumsHelper"%>

<%
    HttpSession hs       = request.getSession();
    UserData userDetail  = (UserData)hs.getAttribute("userDetail");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分");
    JumsHelper jh        = JumsHelper.getInstance();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会員情報（閲覧画面）</title>
    </head>
    <body>
        <h1>会員情報詳細</h1>
        <table border="1">
            <tr>
                <th>ユーザ名</th>
                <th>パスワード</th>
                <th>メールアドレス</th>
                <th>住所</th>
                <th>総購入金額</th>
                <th>登録日時</th>                
            </tr>
            <tr>
                <td align=center><%= userDetail.getName()%></td>
                <td align=center><%= userDetail.getPassword()%></td>
                <td align=center><%= userDetail.getMail()%></td>
                <td align=center><%= userDetail.getAddress()%></td>
                <td align=center><%= userDetail.getTotal()%>円</td>
                <td align=center><%= sdf.format(userDetail.getNewDate())%></td>
            </tr>
        </table>
        <br><%= jh.myhistory()%><br>
        <br><%= jh.myupdate()%><br>
        <br><%= jh.mydelete()%>
    </body>
</html>
