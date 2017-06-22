/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
/**
 *
 * @author guest1Day
 */
public class FortuneTelling extends HttpServlet {

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
            String luckList[] = {"大吉","中吉","小吉","吉","半吉","末小吉","凶","小凶","半凶","末凶","大凶"};
            
            Random rand = new Random();
            Integer index = rand.nextInt(luckList.length);
            
            out.print("あなたの今日の運勢は・・・");
            
            out.print(luckList[index]);
            
            /*
            
            switch(index){
                case 1:
                    out.print("大吉！！！");
                    break;
                case 2:
                    out.print("中吉！");
                    break;
                case 3:
                    out.print("小吉！");
                    break;
                case 4:
                    out.print("吉！");
                    break;
                case 5:
                    out.print("半吉！");
                    break;
                case 6:
                    out.print("末小吉！");
                    break;
                case 7:
                    out.print("凶！");
                    break;
                case 8:
                    out.print("小凶！");
                    break;
                case 9:
                    out.print("半凶！");
                    break;
                case 10:
                    out.print("末凶！");
                    break;
                case 11:
                    out.print("大凶！");
                    break;
                    
            
            }
            */
            
           
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
