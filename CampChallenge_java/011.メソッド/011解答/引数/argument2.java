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
  1. ３つの引数を持ち、渡された数値で掛け算をするメソッドを作成します。
  メソッドは、１つ目の引数と２つ目の引数を掛け算し、３つ目の引数がtrueの場合は結果を２乗させてください。
  また、２つ目の引数は5、３つ目の引数はfalseをデフォルト値として設定してください。
  2. 作成したメソッドを呼び出し、結果を表示してください。
*/
public class argument2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * @param num1
     * @param num2
     * @param bl
     * @param out
     */
    
    // メソッド作成
    public void multiply( int num1, int num2, boolean bl, PrintWriter out) {
        // 計算結果を格納するための変数
        int result;
        
        // １つ目の引数と２つ目の引数を掛け算
        result = num1 * num2;
        
        if(bl) {    // 計算結果を表示した後、それを2乗し表示
            out.print( num1 + " × " + num2 + " = " + result + "<br>" );
            out.print( result + " の２乗： " + ( result * result ) + "<br><br>" );
        } else {    // 計算結果の表示のみ
            out.print( num1 + " × " + num2 + " = " + result + "<br><br>" );
        }
    }
    
    // オーバーロード
    public void multiply( int num1, PrintWriter out ) {
        // デフォルト値設定
        multiply( num1, 5, false, out );
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>引数2</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // メソッド呼び出し
            multiply( 5, 9, true, out );
            multiply( 3, 4, false, out );
            multiply( 21, out );
            
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
