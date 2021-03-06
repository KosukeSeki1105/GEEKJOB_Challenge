package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jums.UserDataBeans;
import jums.UserDataDTO;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更
            
            //フォームからの入力を取得してUserDataBeansに格納
            UserDataBeans udb = new UserDataBeans();
            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setType(request.getParameter("type"));
            udb.setTell(request.getParameter("tell"));
            udb.setComment(request.getParameter("comment"));
            
            //ResultDetailで格納した対象のユーザーIDをセッションから取得
            HttpSession hs = request.getSession();
            UserDataDTO udd = (UserDataDTO)hs.getAttribute("resultDetailData");
            int ID =udd.getUserID();
            
            //対象のユーザーIDをUserDataDTOに格納
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO updateData = new UserDataDTO();
            updateData.setUserID(ID);
            udb.UD2DTOMapping(updateData);

            
            //更新したユーザー情報結果をresultUpdateDataに格納
            //結果画面での表示用にリクエストパラメータとして保持
            UserDataDTO resultUpdateData = UserDataDAO .getInstance().update(updateData);
            request.setAttribute("resultUpdateData", resultUpdateData);
            
            //更新
            UserDataDTO searchData = new UserDataDTO();
            ArrayList<UserDataDTO> resultData = UserDataDAO .getInstance().search(searchData);
            HttpSession session = request.getSession();
            session.setAttribute("resultData", resultData);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
            
        }catch(Exception e){
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
