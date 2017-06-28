/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public class BlackJack extends HttpServlet {

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
            
            //インスタンス生成
            Dealer dealer = new Dealer();
            User user = new User();
            
            //ディーラーが山札から2枚引き、ディーラーとユーザーそれぞれにカードを2枚setする
            dealer.setCard(dealer.deal());
            user.setCard(dealer.deal());
            
            //確認
            out.print("dealerの手札：" + dealer.myCards +"<br>");
            out.print("userの手札：" + user.myCards + "<br><br>");
            
            //お互いのカード合計を出す
            dealer.open();
            user.open();
            
            //確認
            out.print("dealerの合計：" + dealer.open()+"<br>");
            out.print("userの合計：" + user.open() + "<br><br>");
            
            //お互いそれぞれのカード合計が18未満かどうか確認
            //trueなら・・・
            //カード合計が18未満ならhit
            //ディーラーが山札から1枚引き、ディーラーとユーザーそれぞれにカードを1枚setする
            //falseなら・・・
            //そのまま
            
            if(dealer.checkSum()){
                dealer.setCard(dealer.hit());
                out.print("dealer：SETしました。<br>");
            }else{
                out.print("dealer：SETしませんでした。<br>");
            }

            if(user.checkSum()){
                user.setCard(dealer.hit());
                out.print("user：SETしました。<br><br>");
            }else{
                out.print("user:SETしませんでした。<br><br>");
            }
            
            //お互いのカード合計を出す
            //勝敗の結果表示
            out.print("dealerの合計：" + dealer.open() + "<br>");
            out.print("userの合計：" + user.open() + "<br><br>");
                        
            //if文(BUST)
            //if文(DRAW)
            //if文(BlackJak)
            //if文(勝利)

            if(dealer.open() == user.open() || (dealer.open() >= 22 && user.open() >= 22)){
                out.print("DRAW");
            }else if(dealer.open() >= 22){
                out.print("dealer；BUST");
            }else if(user.open() >= 22){
                out.print("user；BUST");                
            }else if(dealer.open() == 21){
                out.print("dealer：BlackJack！");
            }else if(user.open() == 21){
                out.print("user：BlackJack！");
            }else if(dealer.open() > user.open()){
                out.print("dealer：WIN！");
            }else {
                out.print("user：WIN！");
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
