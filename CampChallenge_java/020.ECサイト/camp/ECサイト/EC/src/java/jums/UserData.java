/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

//JavaBeansの必要条件
//publicで引数なしのコンストラクタ(初期化処理)を持つ
//フィールドは隠匿されていること
//フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//シリアライズ可能であること


/**
 * 共通 - ユーザー情報クラス
 *フォームからの入出力されるデータを格納するBeansオブジェクト。
 * DTOからの変換、逆に、DTOへの変換を行うメソッドを保持する。
 * 
 * @author seki-k
 */

//シリアライズ可能に
public class UserData implements Serializable{
    
    //publicで引数なしのコンストラクタ
    public UserData(){};
    
    //フィールド作成
    private String userName = "";
    private String password = "";
    private String mail     = "";
    private String address  = "";
    
    //getter・setter
    //userName
    //password
    //mail
    //address
    public String getUserName(){
        return userName;
    }    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
