/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class db6 extends HttpServlet {

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
            Connection conn = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            String url = "jdbc:mysql://localhost/Challenge_db";
            String user = "SEKI";
            String password = "SEKIKOSUKE";
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //out.println("ドライバのロードに成功しました<br>");
                
                conn = DriverManager.getConnection(url, user, password);
                //out.println("データベース接続に成功しました<br>");
                
                db_st = conn.prepareStatement("delete from profiles where profilesID = ?");
                db_st.setInt(1, 5);
                db_st.executeUpdate();
                
                db_st = conn.prepareStatement("select * from profiles");
                db_data = db_st.executeQuery();
                
                while(db_data.next()){
                    int pfID = db_data.getInt("profilesID");
                    String name = db_data.getString("name");
                    String tell = db_data.getString("tell");
                    int age = db_data.getInt("age");
                    String bdy = db_data.getString("birthday");
                    out.println("プロフィールID：" + pfID+ "名前：" + name + "電話番号：" + tell + "年齢：" + age + "生年月日：" + bdy +"<br>");
                }
                db_data.close();
                db_st.close();
                conn.close();
                
            }catch(ClassNotFoundException e){
                out.println("ClassNotFoundException:" + e.getMessage());
            }catch(SQLException e){
                out.println("SQLException:" + e.getMessage());
            }catch(Exception e){
                out.println("Exception:" + e.getMessage());
            }finally{
                try{
                    if(conn != null){
                        conn.close();
                        out.println("データベース切断に成功しました");
                    }else{
                        out.println("コネクションがありません");
                    }
                }catch(SQLException e){
                        out.println("SQLException:" +e.getMessage());
                }
        }
            
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
