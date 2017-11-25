/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.ProductBean;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import process.Select;

/**
 * 商品情報取得を制御するサーブレット
 * 
 * @author k-seki
 */
public class SelectProductServlet extends HttpServlet {

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

        // セッションスタート
        HttpSession session = request.getSession();
        
        // 文字コード指定
        request.setCharacterEncoding( "UTF-8" );
        
        
        /**
         * パラメータ取得
         * 
         * productNameの場合：商品IDと商品名のみの取得
         * productAllの場合：商品情報全てを取得
         */
        String selectType = request.getParameter( "select" );
        
        
        /**
         * 商品IDと商品名のみの取得
         */
        if( selectType.equals( "productName") ) {
            try {
                ArrayList<ProductBean> productNames = Select.getProductIDName();
                session.setAttribute( "productNames", productNames );   // 表示用に商品名情報を格納
                request.getRequestDispatcher( "/register_product.jsp" ).forward( request, response );  // 管理選択ページに遷移
                return;
            } catch( Exception e ) {
                request.setAttribute( "error", e.getMessage() );
                request.getRequestDispatcher( "/error.jsp" ).forward( request, response );  // エラーページに遷移
            }
        }
        
        
        /**
         * 商品情報全てを取得
         */
        if( selectType.equals( "productAll" ) ) {
            try {
                ArrayList<ProductBean> bean = Select.getProductAll();
                request.setAttribute( "bean", bean );  // 表示用に商品情報を格納
                request.getRequestDispatcher( "/show_products.jsp" ).forward( request, response );  // 商品一覧表示ページに遷移
            } catch( SQLException e ) {
                request.setAttribute( "error", e.getMessage() );
                request.getRequestDispatcher( "/error.jsp" ).forward( request, response );  // エラーページに遷移
            
            } catch( Exception e ) {
                request.setAttribute( "error", e.getMessage() );
                request.getRequestDispatcher( "/error.jsp" ).forward( request, response );  // エラーページに遷移
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
