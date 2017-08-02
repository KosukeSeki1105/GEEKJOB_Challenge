package jums;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

//JavaBeansの必要条件
//publicで引数なしのコンストラクタ(初期化処理)を持つ
//フィールドは隠匿されていること
//フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//シリアライズ可能であること

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */

//シリアライズ可能に。
public class UserDataDTO implements Serializable{
    
    //publicで引数なしのコンストラクタ
    public UserDataDTO(){};
    
    //フィールド作成
    private int userID        = 0;
    private String name       = "";
    private Date birthday     = null;
    private String tell       = "";
    private int type          = 0;
    private String comment    = "";
    private Date newDate = null;
    
    //getter・setter
    //ID
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    //名前
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //生年月日
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    //電話番号
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    //種別
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    //自己紹介
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    //現在時刻
    public Date getNewDate() {
        return newDate;
    }
    public void setDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    
    

}
