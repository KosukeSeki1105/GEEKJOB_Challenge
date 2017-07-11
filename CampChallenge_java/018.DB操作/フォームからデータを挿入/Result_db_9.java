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
public class Result_db_9 extends HttpServlet {
    
    //1レコードを表示するメソッド
    public void printData(ResultSet db_data, PrintWriter out){
        try{
            int ID      = db_data.getInt("profilesID");
            String name = db_data.getString("name");
            String tell = db_data.getString("tell");
            int age     = db_data.getInt("age");
            String bdy  = db_data.getString("birthday");
                   
            out.print("ID：" +ID+ "," + "名前：" +name+ "," + "電話番号：" +tell+ "," + "年齢：" +age+ "," + "生年月日：" +bdy+ "<br>");
            
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>登録結果</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //変数宣言
            Connection db_con = null;
            PreparedStatement db_st = null;
            ResultSet db_data = null;
            
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","SEKI","SEKIKOSUKE");
                
                //入力データを格納
                request.setCharacterEncoding("UTF-8");
                int ID      = Integer.parseInt(request.getParameter("profilesID"));
                String name = request.getParameter("name");
                String tell = request.getParameter("tell");
                int age     = Integer.parseInt(request.getParameter("age"));
                String bdy  = request.getParameter("birthday");
                
                //登録データを追加
                db_st = db_con.prepareStatement("insert into profiles values (?, ?, ?, ?, ?)");
                db_st.setInt(1, ID);
                db_st.setString(2, name);
                db_st.setString(3, tell);
                db_st.setInt(4, age);
                db_st.setString(5, bdy);
                
                db_st.executeUpdate();
                
                //登録データを確認
                db_st = db_con.prepareStatement("select * from profiles where profilesID = ?");
                db_st.setInt(1,ID);
                db_data = db_st.executeQuery();
                
                //登録データを表示
                
                db_data.next();
                printData(db_data, out);
                out.print("追加されました。");
                
                db_data.close();
                db_st.close();
                db_con.close();
                
            }catch(SQLException e_sql){
                System.out.println("接続時にエラーが発生しました。" + e_sql.getMessage());
            }catch(Exception e){
                System.out.println("接続時にエラーが発生しました。" + e.getMessage());
            }finally{
                if(db_con != null){
                    try{
                        db_con.close();
                    }catch(Exception e_con){
                        System.out.println(e_con.getMessage());
                    }
                }
            }
            
            out.println("<h1>Servlet Result_db_9 at " + request.getContextPath() + "</h1>");
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
