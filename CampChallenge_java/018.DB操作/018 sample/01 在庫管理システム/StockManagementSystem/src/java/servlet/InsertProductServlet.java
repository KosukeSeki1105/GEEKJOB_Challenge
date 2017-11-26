/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import process.Insert;
import process.Select;

/**
 * 商品登録を制御するサーブレット
 * 
 * １．ログインチェッカー
 * ２．未入力チェック
 * ３．商品登録処理
 * 
 * @author k-seki
 */
public class InsertProductServlet extends HttpServlet {

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

         // 未入力・誤入力用メッセージ
        String message = "";

        // 商品名
        String productName = "";
        
        // 単価
        int price = 0;
        
        // 在庫
        int stock = 0;
        
        // セッションスタート
        HttpSession session = request.getSession();
        
        // 文字コード指定
        request.setCharacterEncoding( "UTF-8" );


        /**
         * ログインチェッカー
         */
        if( session.getAttribute( "loginCode" ) == null ) {   // loginCodeがない
            response.sendRedirect( "login.jsp" );  // トップページに遷移
            return;
            
        } else {  // loginCodeがある
            int loginCode = (int)session.getAttribute( "loginCode" );
            int loginCheck = Integer.parseInt( request.getParameter( "loginCheck" ) ); // パラメータ取得
            if( loginCode != loginCheck ) {  // 数値が一致しない
                response.sendRedirect( "login.jsp" );  // トップページに遷移
                return;
            }
        }


        /**
         * 未入力チェック
         */
        try {
            /**
             * 商品名
             * 未入力判定あり
             */
            productName = request.getParameter( "productName" );
            
            if( productName.equals( "" ) ) {  // 商品名が未入力
                message += "商品名を入力してください。<br>";
                
            } else {                          // 商品名入力がある
                request.setAttribute( "productName", productName );  // 表示用に商品名情報を格納
            }
            
            
            /**
             * 単価
             * 未入力判定あり
             */
            String priceStr = request.getParameter( "price" );
            
            if( priceStr.equals( "" ) ) {   // 単価が未入力
                message += "単価を入力してください。<br>";
                
            } else {                        // 単価入力がある
                price = Integer.parseInt( priceStr );
                if( price < 0 ) {           // 単価入力がマイナス値
                    message += "数値がマイナスです。<br>";
                }
                request.setAttribute( "price", price );   // 表示用に単価情報を格納
            }
            

            /**
             * 在庫
             * 未入力判定なし
             */
            String stockStr = request.getParameter( "stock" );
            
            if( stockStr.equals( "" ) ) {   // 在庫が未入力
                stock = 0;                  // デフォルトを0に設定
                
            } else {                        // 在庫入力がある
                stock = Integer.parseInt( stockStr );
                if( stock < 0 ) {           // 在庫入力がマイナス値
                    message += "数値がマイナスです。<br>";
                }
                request.setAttribute( "stock", stock );  // 表示用に在庫情報を格納
            }
            
            
            // 未入力・誤入力メッセージがある
            if( ! message.equals( "" ) ) {
                request.setAttribute( "message", message );
                request.getRequestDispatcher( "/register_product.jsp" ).forward( request, response );  // 商品登録ページに遷移
                return;
            }
            
            
        } catch( NumberFormatException e ) {
            message += "適切な入力がされていません。";
            request.setAttribute( "message", message );
            request.getRequestDispatcher( "/register_product.jsp" ).forward( request, response );  // 商品登録ページに遷移
            return;
        }
        
        
        /**
         * 商品登録処理
         */
        try{
            // 登録済みの商品名があるか検索
            String[] searchResult = Select.getProductName( productName );
            
            if( searchResult[0] != null ) {  // 登録済みの商品名あり
                message += "既にその商品名は登録済みです。";
                request.setAttribute( "message", message );
                request.getRequestDispatcher( "/register_product.jsp" ).forward( request, response );  // 商品登録ページに遷移
                
            } else {    // 登録済みのデータなし
                // 登録処理
                Insert.insert(productName, price, stock );
            
                // 処理完了メッセージ
                String processMsg = "商品の新規登録が完了しました。<br>";
                request.setAttribute( "processMsg", processMsg );
                request.getRequestDispatcher( "/manegement_option.jsp" ).forward( request, response );  // 管理選択ページに遷移
            }
            
        } catch( ArrayIndexOutOfBoundsException | SQLException e ) {
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
