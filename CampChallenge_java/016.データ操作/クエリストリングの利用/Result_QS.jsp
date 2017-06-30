<%-- 
    Document   : Result_QS
    Created on : 2017/06/30, 12:22:38
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
        
        String total =request.getParameter("total");
        String count =request.getParameter("count");
        String type = request.getParameter("type");
        
        int type1 = Integer.parseInt(type);
        if(type1 == 1){
            out.print("雑貨<br>");
        }else if(type1 == 2){
            out.print("生鮮食品<br>");
        }else{
            out.print("その他<br>");
        }
           
      
        
            //out.print(total +"<br>");
            //out.print(count +"<br>");
        
        int total1 = Integer.parseInt(total);
        int count1 = Integer.parseInt(count);
            //out.print(total1 +"<br>");
            //out.print(count1 +"<br>");
        
        int wari = total1 / count1;
            //out.print(wari +"<br>");
        out.print("1個当たりの値段は" + wari +"円です。<br>");
        

        if(total1 >= 5000){
            double kake = total1 * 0.05;
            int kakeA = (int)kake;
            out.print(kakeA + "ポイント付きました");
        }else if(total1 >= 3000){
            double kake1 = total1 * 0.04;
            int kakeB = (int)kake1;
            out.print(kakeB + "ポイント付きました");
        }else{
            out.print("ポイントは付きませんでした");
        }
        
    %>
        
        
    </body>
</html>
