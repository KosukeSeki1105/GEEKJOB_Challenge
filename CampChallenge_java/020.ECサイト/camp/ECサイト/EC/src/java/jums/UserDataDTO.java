/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.sql.Timestamp;

//JavaBeansの必要条件
//publicで引数なしのコンストラクタ(初期化処理)を持つ
//フィールドは隠匿されていること
//フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//シリアライズ可能であること

/**
 * 共通 - ユーザー情報保持クラス 
 * ユーザー情報を格納するBeansオブジェクト。
 * 型やフィールド名がDBと連携している。
 * データベースからの格納、
 * 取り出しで取得されたデータを最初に格納する。
 * 
 * @author seki-k
 */

//シリアライズ可能に
public class UserDataDTO implements Serializable{
    
    //publicで引数なしのコンストラクタ
    public UserDataDTO(){};
    
    //フィールド作成
    private int userID        = 0;
    private String name       = "";
    private String password   = "";
    private String mail       = "";
    private String address    = "";
    private int total         = 0;
    private Timestamp newDate = null;
    private int deleteFlg     = 0;
    
    //UserDataに格納されたユーザー情報をUserDataに格納
    //ID
    //name
    //password
    //mail
    //address
    //total
    //newDate
    public void setUserID(int userID){
        this.userID = userID;
    }    
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public void setNewDate(Timestamp newDate){
        this.newDate = newDate;
    }
    
    public int getUserID(){
        return userID;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getMail(){
        return mail;
    }
    public String getAddress(){
        return address;
    }   
    public int getTotal(){
        return total;
    }
    public Timestamp getNewDate(){
        return newDate;
    }
}

