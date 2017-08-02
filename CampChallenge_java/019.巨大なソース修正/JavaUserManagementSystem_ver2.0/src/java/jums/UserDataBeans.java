package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

//JavaBeansの必要条件
//１．publicで引数なしのコンストラクタ(初期化処理)を持つ
//２．フィールドは隠匿されていること
//３．フィールドは命名規則に沿ったメソッドが用意されている(getter/setterを持つ)
//４．シリアライズ可能であること

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    
    //publicで引数なしのコンストラクタ
    public UserDataBeans(){};
    
    //フィールド作成
    private String name    = "";
    private int year       = 0;
    private int month      = 0;
    private int day        = 0;
    private String tell    = "";
    private int type       = 0;
    private String comment = "";
    
//    public UserDataBeans(){
//        this.name = "";
//        this.year = 0;
//        this.month = 0;
//        this.day = 0;
//        this.tell = "";
//        this.type = 0;
//        this.comment= "";
//    }
    
    //getter・setter
    //名前
    public String getName() {
        return name;
    }
    public void setName(String name) {
        //先頭または最後に空白文字がくっついている場合、それらをすべて取り除く
        //空文字(未入力)の場合は空文字をセット
        if(name.trim().length()==0){
            this.name = "";
        }else{
            this.name = name;
        }
    }

    //年
    public int getYear() {
        return year;
    }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){
            this.year = Integer.parseInt("0");
            //this.year = 0;
        }else{
            this.year = Integer.parseInt(year);
        }
    }

    //月
    public int getMonth() {
        return month;
    }
    public void setMonth(String month) {        
        if(month.equals("")){
            this.month = Integer.parseInt("0");
            //this.month = 0;
        }else{
            this.month = Integer.parseInt(month);
        }
    }

    //日
    public int getDay() {
        return day;
    }
    public void setDay(String day) {
        if(day.equals("")){
            this.day = Integer.parseInt("0");
            //this.day = 0;
        }else{
            this.day = Integer.parseInt(day);
        }
    }

    //電話番号
    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        if(tell.trim().length()==0){
            this.tell = "";
        }else{
            this.tell = tell;
        }
    }

    //種別
    public int getType() {
        return type;
    }
    public void setType(String type) {
        if(type == null){
            this.type = 0;
        }else{
            this.type = Integer.parseInt(type);
        }

    }

    //自己紹介
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        if(comment.trim().length()==0){
            this.comment = "";
        }else{
            this.comment = comment;
        }
    }
    
    
    //入力チェックリスト
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.year == 0){
            chkList.add("year");
        }
        if(this.month == 0){
            chkList.add("month");
        }
        if(this.day == 0){
            chkList.add("day");
        }
        if(this.tell.equals("")){
            chkList.add("tell");
        }
        if(this.type == 0){
            chkList.add("type");
        }
        if(this.comment.equals("")){
            chkList.add("comment");
        }
        
        return chkList;
    }

    public void UD2DTOMapping(UserDataDTO udd){
        //名前
        udd.setName(this.name);
        
        //生年月日
        //カレンダーインスタンス生成
        //if(月が0または日が0の場合)
        //else(月も日も0でない場合)
        if(this.year != 0 || this.month != 0 || this.day != 0){
            Calendar birthday = Calendar.getInstance();
            if(this.month == 0 || this.day == 0){
                birthday.set(this.year,0,1);
            }else{
                birthday.set(this.year,(this.month)-1,this.day);
            }
            udd.setBirthday(birthday.getTime());
        }else{
            udd.setBirthday(null);
        }
        
        //電話番号
        udd.setTell(this.tell);
        
        //種別
        udd.setType(this.type);
        
        //自己紹介
        udd.setComment(this.comment);
    }
    
}
