/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

/**
 *
 * @author guest1Day
 */
public class class_moji3 {
    public static void main(String[] args){
        String x = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        
        String r1 = x.replace("U", "う");
        String r2 = r1.replace("I", "い");
        System.out.println(r2);
    }
}
