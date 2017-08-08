<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO"
        import="jums.UserDataDAO"
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="java.text.SimpleDateFormat"
        %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>)hs.getAttribute("resultData");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for(UserDataDTO value:udd){%>
            <tr>
                <td><a href="ResultDetail?id=<%= value.getUserID()%>"><%= value.getName()%></a></td>
                <td><%= value.getBirthday()%></td>
                <td><%= jh.exTypenum(value.getType())%></td>
                <td><%= sdf.format(value.getNewDate())%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <%=jh.home()%>
</html>
