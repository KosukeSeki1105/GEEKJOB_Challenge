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
    private int userID        = 0;
    private String name       = "";
    private String password   = "";
    private String mail       = "";
    private String address    = "";
    private int total         = 0;
    private Timestamp newDate = null;
    
    //フォーム絡みのgetter・setter
    //userID
    //name
    //password
    //mail
    //address
    //total
    //newDate
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }    
    public void setName(String name){
        this.name = name;
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
    
    public int getTotal(){
        return total;
    }
    
    public Timestamp getNewDate(){
        return newDate;
    }
    
    
    //UserDataDTOからの変換メソッド
    //ID
    //name
    //password
    //mail
    //address
    //total
    //newDate
    public int getUserID(int userID){
        this.userID = userID;
        return userID;
    }    
    public String getName(String name){
        this.name = name;
        return name;
    }
    public String getPassword(String password){
        this.password = password;
        return password;
    }
    public String getMail(String mail){
        this.mail = mail;
        return mail;
    }
    public String getAddress(String address){
        this.address = address;
        return address;
    }        
    public int getTotal(int total){       
        this.total = total;
        return total;
    }
    
    public Timestamp getNewDate(Timestamp newDate){
        this.newDate = newDate;
        return newDate;
    }
}
