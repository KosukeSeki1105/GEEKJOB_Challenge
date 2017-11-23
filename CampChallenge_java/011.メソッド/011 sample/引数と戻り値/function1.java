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
  引数が１つのメソッドを作成してください。
  メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、
  引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
  それ以降は課題「戻り値2」と同じ処理にしてください。
*/
public class function1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param num
     * @return 
     */
    
    // メソッド作成
    public String[] getProf( int num ) {
        // 3人分のプロフィールを作成
        String[] prof1 = { "1", "山田太郎", "1970.3.5", "東京都" };
        String[] prof2 = { "2", "山田花子", "1975.7.24", "東京都" };
        String[] prof3 = { "3", "山田涼太", "2001.10.3", "東京都" };
        
        // 引数として渡された値と同じIDを持つ人物のプロフィールを返却
        switch( num ) {
            case 1:
                return prof1;
            case 2:
                return prof2;
            case 3:
                return prof3;
        }
        
        // 引数として渡された値と同じIDを持つ人物のプロフィールがなければnullを返却
        return null;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>引数、戻り値1</title>");            
            out.println("</head>");
            out.println("<body>");

            // 変数初期化
            int num = 1;

            // メソッド呼び出し
            String[] prof = getProf( num );
            
            if( prof != null ) {  // 返却されたプロフィールがnullでない
                // 拡張for文
                for( String value : prof ) {
                    if( value.equals( prof[0] ) ) {  // IDは表示しない
                        continue;
                    }
                    out.print( value + "<br>" );
                }
            } else {             // 返却されたプロフィールがnull
                out.print( num + "と同じIDを持つ人物が存在しません。<br>" );
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
