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
public class TimeStamp4 {
    public static void main(String[] args){
        Calendar c1 = Calendar.getInstance();
        c1.set(2015, 00, 01, 00, 00, 00);
        Date d1 = c1.getTime();
        
        //System.out.println(d1);
        //System.out.println(d1.getTime());
        
        Calendar c2 = Calendar.getInstance();
        c2.set(2015, 11, 31, 23, 59, 59);
        Date d2 = c2.getTime();
        
        //System.out.println(d2);
        //System.out.println(d2.getTime());
        
        long x = d2.getTime() - d1.getTime();
        System.out.println(x);
        
    }
}
