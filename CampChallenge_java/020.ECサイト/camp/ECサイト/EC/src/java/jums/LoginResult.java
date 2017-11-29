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
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 *
 * @author seki-k
 */
public class LoginResult extends HttpServlet {

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
        
        //文字コードをUTF-8に変更
        request.setCharacterEncoding("UTF-8");
        
        //フォームから送られてきた入力情報をStringに格納
        String name     = request.getParameter("name");
        String password = request.getParameter("password");
        
        //＜未入力項目があった場合の処理＞
        //未入力項目名が格納できる配列を作成
        //if(フォームに未入力があった場合)
        //配列にその項目名を追加
        //if(配列の要素数が0でない場合) ※フォームに未入力があった場合
        //未入力項目名の情報をリクエストパラメータに格納
        //フォームから送られてきた入力情報を配列を使用してセッションに格納
        //loginresultfalse.jspに遷移                
        ArrayList<String> nullLogin = new ArrayList<String>();
        if(name.equals(""))    { nullLogin.add("ユーザー名"); }
        if(password.equals("")){ nullLogin.add("パスワード"); }
        if(nullLogin.size() != 0){
            request.setAttribute("nullLogin", nullLogin);
            HashMap<String, String> loginNull = new HashMap<String, String>();
            loginNull.put("name", name);
            loginNull.put("password", password);
            HttpSession session = request.getSession();
            session.setAttribute("loginNull", loginNull);
            request.getRequestDispatcher("/loginresultfalse.jsp").forward(request, response);
        }else{
            
        //else(配列の要素が0である場合) ※フォームに未入力がない場合
        //＜DB検索でデータが該当するかどうかの処理＞
        //フォーム入力情報をUserDataに格納
        //DB検索を実行
        //結果をbooleanで受け取る
        //if(trueの場合) 　 ※データが該当した場合
        //ログインに成功情報をログイン状態を管理できるセッション("loginState")に書き込み
        //各ページのログインボタンから遷移してきているのでページに関するセッション情報("pageCheck")を取得
        //ページ遷移した後の「ようこそ○○さん」の表示のためにセッション("userSearch")にUserData(loginState)の情報を格納
        //取得したページ情報をもとに直前まで閲覧していたページに遷移
        //else(falseの場合) ※データが該当しなかった場合
        //フォーム入力情報("loginNull")を更新
        //リクエストパラメータにログイン失敗した旨を格納
        //loginresultfalse.jspに遷移
            try{
                UserData loginState = new UserData();
                loginState.setName(name);
                loginState.setPassword(password);
            
                boolean searchResult = UserDataDAO.getInstance().search(loginState);
                HttpSession session = request.getSession();
            
                if(searchResult){
                    session.setAttribute("loginState", "connected");
                    String pageCheck    = (String)session.getAttribute("pageCheck");
                    session.setAttribute("userSearch", loginState);
                    request.getRequestDispatcher(pageCheck).forward(request, response);                            
                }else{
                    HashMap<String, String> loginNull = new HashMap<String, String>();
                    loginNull.put("name", name);
                    loginNull.put("password", password);
                    session.setAttribute("loginNull", loginNull);
                    request.setAttribute("falseLogin", "該当するユーザー情報はありませんでした。");
                    request.getRequestDispatcher("/loginresultfalse.jsp").forward(request, response);            
                }          
            }catch(Exception e){
                //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
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
