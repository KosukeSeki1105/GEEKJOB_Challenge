package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jums.UserDataBeans;

/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        //セッションスタート
        HttpSession session = request.getSession();
        HttpSession hs = request.getSession();
        
        try{
            //課題２
            request.setCharacterEncoding("UTF-8");
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)session.getAttribute("ac") != Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
            UserDataDTO userdata = new UserDataDTO();            
            
            //名前
            userdata.setName(udb.getName());
            
            //生年月日(年・月・日)
            //SimpleDateFormatでDate型に変更            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            //String test = udb.getYear()+"/"+udb.getMonth()+"/"+udb.getDay();
            Date birthday = sdf.parse(udb.getYearS()+"/"+udb.getMonthS()+"/"+udb.getDayS());
            userdata.setBirthday(birthday);

            //電話番号
            userdata.setTell(udb.getTell());

            //種別
            userdata.setType(Integer.parseInt(udb.getType()));
            
            //自己紹介
            userdata.setComment(udb.getComment());
            
            //userDataDTOをセッションに格納
            session.setAttribute("userdata", userdata);
            
            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            
            request.getRequestDispatcher("/insertresult.jsp").forward(request, response);
        }catch(SQLException e_sql){
            request.setAttribute("error", e_sql.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
