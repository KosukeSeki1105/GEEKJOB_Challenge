/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author k-seki
 */
/*
  課題「ユーザー定義メソッドの作成」で定義したメソッドを拡張します。
  メソッドへ戻り値を追加し、　true(boolean)　を返却するように修正してください。
  また、メソッドの呼び出し側で戻り値を評価し、trueなら「この処理は正しく実行できました」、そうでないなら「正しく実行できませんでした」と表示してください。
*/
public class ReturnValue1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param out
     */
    
    // メソッド作成
    public boolean displayProfile( PrintWriter out ) {
        out.print( "名前：関皓理<br>" );
        out.print( "生年月日：1993年11月5日<br>" );
        out.print( "自己紹介：2017年8月31日にキャンプ卒業しました！<br><br>" );
        return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>戻り値1</title>");            
            out.println("</head>");
            out.println("<body>");

            // メソッド呼び出し
            if( displayProfile(out) ) {
                out.print( "この処理は正しく実行できました" );
            } else {
                out.print( "正しく実行できませんでした" );
            }
            
            out.println("</body>");
            out.println("</html>");
            
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
