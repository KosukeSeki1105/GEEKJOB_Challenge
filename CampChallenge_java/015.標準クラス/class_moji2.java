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
public class class_moji2 {
    public static void main(String[] args){
        String mailAd = "kosuke.seki.1105@gmail.com";
        
        int index = mailAd.indexOf("@");
        System.out.println(mailAd.substring(index));
        
    }
}
