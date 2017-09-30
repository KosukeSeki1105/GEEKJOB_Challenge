/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author k-seki
 */
public class ResultData implements Serializable {
    private String d;
    private String luck;
    private String message;
    
    public ResultData(){}
    
    
    public String getD() {
        return d;
    }
    
    public void setD(String d) {
        this.d = d;
    }
    
    public String getLuck() {
        return luck;
    }
    
    public void setLuck(String luck) {
        this.luck = luck;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
