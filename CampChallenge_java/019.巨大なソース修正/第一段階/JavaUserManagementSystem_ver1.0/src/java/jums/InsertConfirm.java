package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jums.UserDataBeans;
import java.util.HashMap;

/**
 * insertconfirm.jspと対応するサーブレット
 * フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
        try{
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
             //フォームからの入力をUserDataBeansに格納
             UserDataBeans udb = new UserDataBeans();
             udb.setName(request);
             udb.setYear(request);
             udb.setMonth(request);
             udb.setDay(request);
             udb.setType(request);
             udb.setTell(request);
             udb.setComment(request);
                                     
             
             //UserDataBeansをセッションに格納
             session.setAttribute("udb", udb);
             
             
             //未入力フォームがあった場合はHashMapに格納
             HashMap<Integer, String> eMsg = new HashMap<Integer, String>();
             if(udb.getName().equals("")){ eMsg.put(1, "名前"); }
             if(udb.getYearS().equals("")){ eMsg.put(2, "年"); }
             if(udb.getMonthS().equals("")){ eMsg.put(3, "月"); }
             if(udb.getDayS().equals("")){ eMsg.put(4, "日"); }
             if(udb.getType().equals("")){ eMsg.put(5, "種別"); }
             if(udb.getTell().equals("")){ eMsg.put(6, "電話番号"); }
             if(udb.getComment().equals("")){ eMsg.put(7, "自己紹介"); }
            
             session.setAttribute("eMsg", eMsg);
             
             
//            //フォームからの入力を取得
//            String name = request.getParameter("name");
//            String year = request.getParameter("year");
//            String month = request.getParameter("month");
//            String day = request.getParameter("day");
//            String type = request.getParameter("type");
//            String tell = request.getParameter("tell");
//            String comment = request.getParameter("comment");
//
//            //セッションに格納
//            session.setAttribute("name", name);
//            session.setAttribute("year", year);
//            session.setAttribute("month",month);
//            session.setAttribute("day", day);
//            session.setAttribute("type", type);
//            session.setAttribute("tell", tell);
//            session.setAttribute("comment", comment);
//            System.out.println("Session updated!!");
            
            request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);
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
