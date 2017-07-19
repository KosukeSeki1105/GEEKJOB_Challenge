/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author guest1Day
 */

//オブジェクトを保存・復元できるように直列化可能にする
public class UserDataBeans implements Serializable{
    
    //インスタンス変数
    private String name  = "";
    private String year  = "";
    private String month = "";
    private String day   = "";
    private String type  = "";
    private String tell  = ""; 
    private String comment  = "";
    
    //フォームから受け取ったデータを格納
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
        if(!request.getParameter("type").equals("")){
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
        
    //格納したデータを取り出す
    //名前
    public String getName(){
        return name;
    }
    
    //年
    public int getYear(){
        return Integer.parseInt(year);
    }
    
    //月
    public int getMonth(){
        return Integer.parseInt(month);
    }
    
    //日
    public int getDay(){
        return Integer.parseInt(day);
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
    

    

