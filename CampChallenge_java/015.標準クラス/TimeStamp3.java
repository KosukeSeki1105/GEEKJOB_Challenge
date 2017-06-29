/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author guest1Day
 */
public class TimeStamp3 {
    public static void main(String[] args){
         Calendar c = Calendar.getInstance();
         c.set(2016, 10, 4, 10, 00, 00);
         Date d = c.getTime();
         
         //System.out.println(d);
         //System.out.println(d.getTime());
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
         System.out.print(sdf.format(d.getTime()));
    }
}
