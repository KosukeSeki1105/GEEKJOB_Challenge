/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 在庫管理システム;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author guest1Day
 */
public class Result_product_1 extends HttpServlet {
    public void printData1(ResultSet db_data, PrintWriter out){
        //1レコードを表示するメソッド
        try{
            int code       = db_data.getInt("code");
            String name    = db_data.getString("name");
            int price      = db_data.getInt("price");
            int stock      = db_data.getInt("stock");
            String company = db_data.getString("company");
            
            out.print("商品コード：" + code + "、" + "商品名：" + name + "、" + "単価：" + price + "、" + "在庫数：" + stock + "、" + "メーカー名：" + company);
        }catch(SQLException e_sql){
            System.out.println("接続時にエラーが発生しました。" + e_sql.getMessage());
        }catch(Exception e){
            System.out.println("接続時にエラーが発生しました。" + e.getMessage());
        }
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             //変数宣言
            Connection db_con       = null;
            PreparedStatement db_st = null;
            ResultSet db_data       = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "SEKI", "SEKIKOSUKE");

                //入力データを格納
                request.setCharacterEncoding("UTF-8");
                String see_write = request.getParameter("see_write");
               
                //if(全件検索の場合)
                if(see_write.equals("see")){
                    db_st = db_con.prepareStatement("select * from product");                
                    db_data = db_st.executeQuery();
                    
                    int i =0;
                    while(db_data.next()){
                        printData1(db_data, out);
                        i ++;
                        out.print("<br>");
                    }
                    out.print("<br>" + i +"件すべて検索しました。");
                }
               
               
                //if(商品情報追加の場合)
               if(see_write.equals("write")){
                    request.setCharacterEncoding("UTF-8");
                    int code = Integer.parseInt(request.getParameter("code"));
                    String name = request.getParameter("name");
                    int price = Integer.parseInt(request.getParameter("price"));
                    int stock = Integer.parseInt(request.getParameter("stock"));
                    String company = request.getParameter("company");
                    
                    db_st = db_con.prepareStatement("insert into product values(?, ?, ?, ?, ?)");                
                    db_st.setInt(1, code);
                    db_st.setString(2, name);
                    db_st.setInt(3, price);
                    db_st.setInt(4, stock);
                    db_st.setString(5, company);

                    db_st.executeUpdate();
                    
                    db_st = db_con.prepareStatement("select * from product where code = ?");
                    db_st.setInt(1, code);
                    db_data = db_st.executeQuery();
                    
                    db_data.next();
                    printData1(db_data, out);
                    out.print("<br>");
                    out.print("登録しました。");
                    
                }
                   
                db_data.close();
                db_st.close();
                db_con.close();
                
            }catch(SQLException e_sql){
                System.out.print("接続時にエラーが発生しました。" +e_sql.getMessage());
            }catch(Exception e){
                System.out.print("接続時にエラーが発生しました。" +e.getMessage());                
            }finally{
                if(db_con != null){
                try{
                    db_con.close();                    
                }catch(Exception e_con){
                    System.out.println(e_con.getMessage());
                }
                }
            }
            
            
            
            out.println("<a href=\"http://localhost:8080/SampleA/user_login.jsp\"target=\"_self\">ユーザーログイン画面へ</a>");
            //out.println("<form action=\"http://localhost:8080/SampleA/user_login.jsp\"></form>");
            //out.println("<input type="submit" name="logout" value="ログアウト">");
            //</form>
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Result_product_1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
