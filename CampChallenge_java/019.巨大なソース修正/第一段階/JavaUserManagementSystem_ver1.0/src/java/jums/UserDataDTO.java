package jums;

//JavaBeansの必要条件
//１．publicで引数なしのコンストラクタ(初期化処理)を持つ
//２．フィールドは隠匿されていること
//３．フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//４．シリアライズ可能であること

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */

//UserDataDTOクラスにSerializableを実装
public class UserDataDTO implements Serializable{
    
    //publicで引数なしのコンストラクタを作成
    public UserDataDTO(){}
    
    //フィールド作成
    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    
    //getter・setter
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }

}
