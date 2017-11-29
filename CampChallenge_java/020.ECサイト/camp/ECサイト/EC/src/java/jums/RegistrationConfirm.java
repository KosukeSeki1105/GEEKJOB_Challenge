/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author seki-k
 */
public class RegistrationConfirm extends HttpServlet {

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
            //セッションスタート
            HttpSession session = request.getSession();
        
            //文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");

            //入力されたデータを格納
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String mail     = request.getParameter("mail");
            String address  = request.getParameter("address");
            
            //未入力項目名が格納できる配列(ArrayList)を作成
            //if(ユーザー名が未入力の場合)
            //if(パスワードが未入力の場合)
            //if(メールアドレスが未入力の場合)
            //if(住所が未入力の場合)
            //上記制御文でtrueなら、配列に項目名を格納
            //セッションに配列を格納
            //if(配列の要素数が０でない場合)  ＊未入力項目がある場合
            //registrationconfirm.jspに遷移
            ArrayList<String> nullData = new ArrayList<String>();
            if(name.equals(""))    { nullData.add("ユーザー名"); }
            if(password.equals("")){ nullData.add("パスワード"); }
            if(mail.equals(""))    { nullData.add("メールアドレス"); }
            if(address.equals("")) { nullData.add("住所"); }            
            session.setAttribute("nullData", nullData);
            if(nullData.size() != 0){
            request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);
            }
            
            //UserDataと連携。フォームからの入出力されるデータを格納。
            UserData registration = new UserData();
            registration.setName(name);
            registration.setPassword(password);
            registration.setMail(mail);
            registration.setAddress(address);
            
            //既に使われているユーザー名・パスワード・メールアドレスでないかどうかを確認する処理
            //DAOのconfirmメソッドを使用
            //セッションにHashMapデータを格納
            //入力画面に遷移した際に、フォームが入力済みになっているようにセッションに入力情報を格納
            //registrationconfirm.jspに遷移
            try{
                HashMap<String, String> confirm = UserDataDAO.getInstance().confirm(registration);                     
                session.setAttribute("resultConfirm" , confirm);            
                session.setAttribute("registration", registration);
                request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);            
            }catch(Exception e){
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
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
