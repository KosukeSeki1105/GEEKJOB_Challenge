<%-- 
    Document   : session2_1
    Created on : 2017/07/03, 10:57:14
    Author     : guest1Day
--%>
<%@page import="javax.servlet.http.HttpSession"%>
<%
    request.setCharacterEncoding("UTF-8");           
    
    HttpSession hs = request.getSession();
    String n = "";
    String s = "";
    String hby = "";
    
    //if(セッションが空でなければ)
    if(hs.getAttribute("Name") != null){
        n = (String)hs.getAttribute("Name");
    }
    
    if(hs.getAttribute("Sei") != null){
        s = (String)hs.getAttribute("Sei");
    }
    
    if(hs.getAttribute("Hby") != null){
        hby = (String)hs.getAttribute("Hby");
    }    
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./session2_2.jsp" method="post">
            氏名<br>
            <input type="text" name="name" value="<%=n%>">
            <br><br>
            
            男<input type="radio" name="sei" value="男" 
                    <%if(s.equals("男")){
                        out.print("checked");
                    }%>><br>
            女<input type="radio" name="sei" value="女" 
                    <%if(s.equals("女")){
                        out.print("checked");
                    }%>><br><br>
            
                
            趣味は？<br>
            <textarea name="syumi"><%=hby%></textarea><br><br><br>
            
            <input type="submit" name="submit" value="送信">
    
        </form>
        
    </body>
</html>
       