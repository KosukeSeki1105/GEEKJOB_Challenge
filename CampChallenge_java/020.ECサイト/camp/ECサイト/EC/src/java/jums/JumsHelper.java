/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

/**
 *画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author seki-k
 */
public class JumsHelper {
    //ログインページへのリンクを定数として設定
    private final String loginURL = "login.jsp";
    
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //ログインページ画面へのリンクを返却
    public String login(){
        return "<a href=\"" + loginURL + "\">ログイン</a>";
    }
}
