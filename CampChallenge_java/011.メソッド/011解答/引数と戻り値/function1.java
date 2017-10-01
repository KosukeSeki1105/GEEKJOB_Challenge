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
public class function1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param index
     * @return 
     */
    
    /*
      引数が１つのメソッドを作成してください。
      メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、
      引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
      それ以降は課題「戻り値2」と同じ処理にしてください。
    */
    public String[] getProf(int index) {
        String[] prof1 = {"1", "山田太郎", "1970.3.5", "東京都"};
        String[] prof2 = {"2", "山田花子", "1975.7.24", "東京都"};
        String[] prof3 = {"3", "山田涼太", "2001.10.3", "東京都"};
        
        switch(index) {
            case 1:
                return prof1;
            case 2:
                return prof2;
            case 3:
                return prof3;
        }
        
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
            out.println("引数が１つのメソッドを作成します。<br>");
            out.println("メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し<br>");
            out.println("引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にします。<br>");
            out.println("それ以降は課題「戻り値2」と同じ処理にします。（が、少し変更しました笑）<br><br>");
            
            int[] index = {1, 2, 3, 4};
            
            for(int i = 1; i <= index.length; i++) {
                String[] prof = getProf(i);
                if(prof != null) {
                    for(String value:prof) {
                        if(value.equals(prof[0])){
                            continue;
                        }
                        out.print(value + "<br>");
                    }
                } else {
                    out.print(i + "と同じIDを持つ人物が存在しません。<br>");
                }
                out.print("<br>");
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
