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
import javax.servlet.http.HttpSession;

/**
 *
 * @author guest1Day
 */
public class Result_user_login extends HttpServlet {
    
   
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
        
//            //アクセスしようとしたURLを格納
//            String target = request.getRequestURI();
//
//            HttpSession session = request.getSession(false);
//            
//            //if(sessionが開始されておらず、Loginに関するデータがない場合)
//            //アクセスしようとしたURLを保存
//            //ログイン画面に遷移
//            //else
//            //Loginに関するデータを取得
//            //if(sessionが開始されており、Loginに関するデータがない場合)
//            //アクセスしようとしたURLを保存
//            //ログイン画面に遷移
//            if(session == null){
//                session = request.getSession(true);
//                session.setAttribute("target", target);
//                
//                response.sendRedirect("/user_login");
//            }else{
//                Object loginCheck = session.getAttribute("login");
//                if(loginCheck == null){
//                    session.setAttribute("target", target);
//                    response.sendRedirect("/user_login");
//                }
//            }
            Connection db_con       = null;
            PreparedStatement db_st = null;
            ResultSet db_data       = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "SEKI", "SEKIKOSUKE");

                //入力データを格納
                request.setCharacterEncoding("UTF-8");
                String user = request.getParameter("user");
                String password = request.getParameter("password");
                
                //入力データを検索
                db_st = db_con.prepareStatement("select * from user_certification where userName = ? AND password = ?");
                db_st.setString(1, user);
                db_st.setString(2, password);

                db_data = db_st.executeQuery();
                
                if(db_data.next()){
                    response.sendRedirect("http://localhost:8080/SampleA/product.jsp");
                    //out.println("<a href=\"" + "http://localhost:8080/SampleA/product.jsp" +"\">商品情報管理へ</a>");
                }
           
                if(!db_data.next()){
                   response.sendRedirect("http://localhost:8080/SampleA/user_login.jsp");
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


            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ユーザー認証結果</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<a href="http://localhost:8080/SampleA/product.jsp"target="_self">商品情報へ</a>");
            
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
