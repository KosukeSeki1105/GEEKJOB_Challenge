/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;

/**
 *
 * @author k-seki
 */
public class ResultData implements Serializable {
    
    // フィールド
    private String date;      // 日付
    private String luck;      // 運勢
    private String message;   // メッセージ
    
    
    // コンストラクタ
    public ResultData(){ }
    
    
    // getter setter
    public String getDate() {
        return date;
    }
    public void setDate( String date ) {
        this.date = date;
    }
    
    public String getLuck() {
        return luck;
    }
    public void setLuck( String luck ) {
        this.luck = luck;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage( String message ) {
        this.message = message;
    }
    
}
