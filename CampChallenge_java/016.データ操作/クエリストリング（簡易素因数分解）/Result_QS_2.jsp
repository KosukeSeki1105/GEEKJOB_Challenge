<%-- 
    Document   : Result_QS_2
    Created on : 2017/06/30, 14:40:50
    Author     : guest1Day
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
        
            String s = request.getParameter("num");
             
            int n = Integer.parseInt(s);
            out.print("元の値は" + n + "です。<br>");
            
            if(n < 2){
                out.print("結果：" + 1 + "です。");
            }
                
            while(n % 2 ==0){
                out.print(2);
                out.print(" ");
                n /= 2;
            }    
            for (int i = 3; i <= n; i += 2){
                while(n % i == 0){
                    out.print(i + " ");
                    n /= i;
                }
            }
            if(n > 1)out.print(n);
            


        %>
        
    </body>
</html>
