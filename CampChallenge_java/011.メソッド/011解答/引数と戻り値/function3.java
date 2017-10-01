/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author k-seki
 */
public class function3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param limit
     * @return 
     */
    
    //課題「引数、戻り値2」の処理において、Integer limit=2を用意し、
    //limitを利用して２名のプロフィール表示までで停止する様に処理を実装してください。
     public ArrayList<String[]> getProf(Integer limit) {
        String[] prof1 = {"1", "山田太郎", "1970.3.5", null};
        String[] prof2 = {"2", "山田花子", "1975.7.24", "東京都"};
        String[] prof3 = {"3", "山田涼太", "2001.10.3", null};
        
        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(prof1);
        data.add(prof2);
        data.add(prof3);
        
        ArrayList<String[]> profs = new ArrayList<String[]>();
        int index =1;
        for(String[] value:data) {
            if(index <= limit && value[0].equals(String.valueOf(index))) {
                profs.add(value);
                index++;
            }
        }
        
        return profs;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>引数、戻り値3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("課題「引数、戻り値2」の処理において、Integer limit=2を用意し、<br>");
            out.println("limitを利用して２名のプロフィール表示までで停止する様に処理を実装します。<br><br>");
            
            Integer limit = 2;    
            ArrayList<String[]> profs = getProf(limit);
            
            for(String[] item:profs) {
                if(item[3] == null) {
                    out.print(item[1] + "<br>" + item[2] + "<br>");
                    out.print("<br>");
                } else {
                    out.print(item[1] + "<br>" + item[2] + "<br>" + item[3] + "<br>");
                    out.print("<br>");
                }
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
