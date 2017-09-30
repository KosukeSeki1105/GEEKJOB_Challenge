package servlet;

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

/**
 *
 * @author admin
 */
public class RegisterConfirm extends HttpServlet {

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
        try {
            //文字コードをUTF-8に設定
            request.setCharacterEncoding("UTF-8");
            
            //フォームに入力された値を格納
            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            Integer age = Integer.parseInt(request.getParameter("age"));
            
            //リクエストスコープに格納
            request.setAttribute("lastName", lastName);
            request.setAttribute("firstName", firstName);
            request.setAttribute("age", age);
            
            //CheckAgeクラスを生成
            CheckAge ca = new CheckAge();
            if(ca.check(age)) {
                System.out.println("適切な数字を確認。");
            }
            
        } catch(NumberFormatException e) {
            request.setAttribute("error", "年齢の入力値が不正です。");
           request.getRequestDispatcher("/error.jsp").forward(request, response);
           
        } catch(IllegalAgeException e) {
            request.setAttribute("error", e.getMessage());
           request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
        
        request.getRequestDispatcher("/confirm.jsp").forward(request, response);
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
