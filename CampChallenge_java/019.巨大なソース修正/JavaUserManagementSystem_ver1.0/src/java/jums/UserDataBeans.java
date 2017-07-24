/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

//JavaBeansの必要条件
//１．publicで引数なしのコンストラクタ(初期化処理)を持つ
//２．フィールドは隠匿されていること
//３．フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//４．シリアライズ可能であること


import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guest1Day
 */

//UserDataBeansクラスにSerializableを実装
public class UserDataBeans implements Serializable{
    
    //publicで引数なしのコンストラクタを作成
    public UserDataBeans(){}
    
    
    //フィールド作成
    private String name     = "";
    private String year     = "";
    private String month    = "";
    private String day      = "";
    private String type     = "";
    private String tell     = ""; 
    private String comment  = "";
    
    
    //setter(フォームから受け取ったデータを格納)
    //名前
    public void setName(HttpServletRequest request){
        if(!request.getParameter("name").equals("")){
            this.name = request.getParameter("name");        
        }
    }
        
    //年
    public void setYear(HttpServletRequest request){
        if(!request.getParameter("year").equals("")){
            this.year = request.getParameter("year");        
        }
    }

    //月
    public void setMonth(HttpServletRequest request){
        if(!request.getParameter("month").equals("")){
            this.month = request.getParameter("month");
        }
    }    
        
    //日
    public void setDay(HttpServletRequest request){
        if(!request.getParameter("day").equals("")){
            this.day = request.getParameter("day");
        }
    }
        
    //種別
    public void setType(HttpServletRequest request){
        if(request.getParameter("type") != null){
            this.type = request.getParameter("type");
        }
    }    
        
    //電話番号
    public void setTell(HttpServletRequest request){
        if(!request.getParameter("tell").equals("")){
            this.tell = request.getParameter("tell");
        }
    }
        
    //自己紹介文
    public void setComment(HttpServletRequest request){
        if(!request.getParameter("comment").equals("")){
            this.comment = request.getParameter("comment");
        }
        
    }
        
    
    //getter(格納したデータを取り出す)
    //年月日はgetterを2つ用意
    //名前
    public String getName(){
        return name;
    }
    
    //年
    public int getYear(){
        if(!year.equals("")){
            return Integer.parseInt(year);
        }else{
            return 0;
        }
    }
    public String getYearS(){
        return year;
    }
    
    //月
    public int getMonth(){
        if(!month.equals("")){
            return Integer.parseInt(month);
        }else{
            return 0;
        }
    }
    public String getMonthS(){
        return month;
    }
    
    //日
    public int getDay(){
        if(!day.equals("")){
            return Integer.parseInt(day);            
        }else{
            return 0;
        }
    }
    public String getDayS(){
        return day;
    }
    
    //種別
    public String getType(){
        return type;
    }
    
    //電話番号
    public String getTell(){
        return tell;
    }
    
    //自己紹介文
    public String getComment(){
        return comment;
    }
}
    

    

