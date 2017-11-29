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
    
    //＜各リンクを定数として設定＞
    //ログインページ ※servlet側
    //ログインページ
    //トップページ
    //会員登録（入力画面）[新規会員登録]
    //買い物かご
    //会員情報（閲覧画面）
    //登録情報（更新画面）
    //登録情報（削除画面）
    //購入履歴
    //商品詳細ページ
    //商品追加ページ
    private final String LoginURL        = "Login";
    private final String loginURL        = "login.jsp";
    private final String topURL          = "top.jsp";
    private final String registrationURL = "registration.jsp";
    private final String cartURL         = "cart.jsp";
    private final String myupdateURL     = "myupdate.jsp";
    private final String mydeleteURL     = "mydelete.jsp";
    private final String myhistoryURL    = "myhistory.jsp";
    private final String itemURL         = "Item";
    private final String addURL          = "add.jsp";
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //＜リンク返却メソッド＞
    //ログインページ　　　（「ログイン」と表示）
    //ログインページ 　　　（「ログアウト」と表示）※ログアウト用
    //ログインページ画面　（「ログインページへ戻る」と表示）
    //トップページ画面　　（「トップページへ戻る」と表示）
    //新規会員登録画面　　（「新規会員登録」と表示）
    //会員登録（入力画面）（「会員登録（入力画面）へ戻る」と表示）
    //買い物かご画面　　　（「買い物かご」と表示）
    //会員情報（閲覧画面）　NOT maked
    //登録情報（更新画面）（「登録情報を更新する」と表示）
    //登録情報（更新画面）（「登録情報更新フォームへ戻る」と表示）
    //登録情報（削除画面）（「登録情報を削除する」と表示）
    //購入履歴　　　　　　（「購入履歴へ」と表示）
    //商品詳細ページ
    //商品追加ページ　　　（「カートに追加する」と表示）
    public String login(){ return "<a href=\"" + loginURL + "\">ログイン</a>"; }
    public String logout(){ return "<a href=\"" + LoginURL + "\">ログアウト</a>"; }
    public String loginBack(){ return "<a href=\"" + loginURL + "\">ログインページへ戻る</a>"; }    
    public String top(){ return "<a href=\"" +  topURL  + "\">トップページへ戻る</a>"; }
    public String registration(){ return "<a href=\"" + registrationURL + "\">新規会員登録</a>"; }
    public String registrationBack(){ return "<a href=\"" + registrationURL + "\">会員登録（入力画面）へ戻る</a>"; }
    public String cart(){ return "<a href=\"" + cartURL + "\">買い物かご</a>"; }
    public String myupdate(){ return "<a href=\"" + myupdateURL + "\">登録情報を更新する</a>"; }
    public String myupdateBack(){ return "<a href=\"" + myupdateURL + "\">登録情報更新フォームへ戻る</a>"; }
    public String mydelete(){ return "<a href=\"" + mydeleteURL + "\">登録情報を削除する</a>"; }
    public String myhistory(){ return "<a href=\"" + myhistoryURL + "\">購入履歴へ</a>"; }
    public String item(){ return itemURL ; }
    public String add(){ return "<a href=\"" + addURL + "\">カートに追加する</a>"; }
}
