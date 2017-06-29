/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class TimeStamp1 {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1, 00, 00, 00);
        
        Date d = c.getTime();
       // System.out.println(d);
        
        System.out.println(d.getTime());
        
    }
}
