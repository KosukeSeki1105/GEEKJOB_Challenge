/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import process.Login;

/**
 * ログインを制御するサーブレット
 * 
 * １．ログインチェッカー機能
 * ２．未入力チェック
 * ３．ログイン処理
 * 
 * @author k-seki
 */
public class LoginServlet extends HttpServlet {

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
        
        // メッセージ
        String message = null;
        
        // セッションスタート
        HttpSession session = request.getSession();

        // 文字コード指定
        request.setCharacterEncoding( "UTF-8" );
        
        // パラメータ取得
        String name = request.getParameter( "name" );          // ユーザー名
        String password = request.getParameter( "password" );  // パスワード

        
        /**
         * ログインチェッカー機能
         */
        int loginCode = new Random().nextInt( 1001 );
        session.setAttribute( "loginCode", loginCode );

        
        /**
         * 未入力チェック
         */
        if( name.equals( "" ) && password.equals( "" ) ) {   // 名前とパスワード
            message = "ユーザー名とパスワードが未入力です。";

        } else if( name.equals( "" ) ) {                    // 名前
            message = "ユーザー名が未入力です。";
            
        } else if( password.equals( "" ) ) {                // パスワード
            message = "パスワードが未入力です。";
            request.setAttribute( "name", name );    // 表示部用に名前情報を格納
        }
        
        if( message != null ) {       // 未入力があったものはログインページへ遷移
            request.setAttribute( "message", message );
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
            return;
        }
        
        
        /**
         * ログイン処理
         */
        try {
            // 検索結果
            String[] userData = Login.loginCheck( name, password );
            
            if( userData[0] == null ) { // 該当するデータがない
                request.setAttribute( "name", name );   // 表示用にユーザー名を格納
                message = "ユーザー名あるいはパスワードが間違っています。";
                request.setAttribute( "message", message );
                request.getRequestDispatcher( "/login.jsp" ).forward( request, response );  // ログインページに遷移

            } else {                   // 該当するデータがある
                session.setAttribute( "name", userData[0] );
                request.getRequestDispatcher( "/manegement_option.jsp" ).forward( request, response ); // 商品登録・一覧機能ページに遷移
            }
        
        } catch( SQLException | ArrayIndexOutOfBoundsException e ) {
            request.setAttribute( "error", e.getMessage() );
            request.getRequestDispatcher( "/error.jsp" ).forward( request, response );  // エラーページに遷移
        
        } catch( Exception e ) {
            request.setAttribute( "error", e.getMessage() );
            request.getRequestDispatcher( "/error.jsp" ).forward( request, response );  // エラーページに遷移
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
