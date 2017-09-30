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
public class argument1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param num
     * @param out
     */
    
    //1. 引数として数値を受け取り、その値が奇数か偶数か判別＆表示するメソッドを作成してください。
    //2. 作成したメソッドを利用して、適当な数値の奇数・偶数の判別を行ってください。
    
    public void discrimination(int num, PrintWriter out) {
        if(num %2 == 0) {
            out.print(num + "は偶数です。<br><br>");
        } else {
            out.print(num + "は奇数です。<br><br>");
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>引数1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("1. 引数として数値を受け取り、その値が奇数か偶数か判別＆表示するメソッドを作成します。<br>");
            out.println("2. 作成したメソッドを利用して、適当な数値の奇数・偶数の判別を行います。<br><br>");
            
            for(int i = 1; i <= 100; i++) {
            discrimination(i, out);
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
