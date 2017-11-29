/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jums.UserDataDTO;

/**
 *
 * @author seki-k
 */
public class RegistrationComplete extends HttpServlet {

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
        //・プロフィール用のDBに値を挿入。
        //この際、現在時(年月日時分)を組み込み関数で取得し、追加。

        //セッションスタート
        HttpSession session = request.getSession();

        try {
            //セッションに格納したUserData情報を取得
            UserData ud = (UserData) session.getAttribute("registration");

            //DBへデータを挿入
            UserDataDAO.getInstance().insert(ud);

            //DBに挿入したデータをUserDataDTOに格納
            UserDataDTO registComp = new UserDataDTO();
            registComp.setName(ud.getName());
            registComp.setPassword(ud.getPassword());
            registComp.setMail(ud.getMail());
            registComp.setAddress(ud.getAddress());
            
            //成功したのでセッションの値を削除
            session.invalidate();
            
            //結果画面での表示用に入力パラメータをリクエストパラメータとして保存
            request.setAttribute("registComp", registComp);

            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
        } catch (Exception e) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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
