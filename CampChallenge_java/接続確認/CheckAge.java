/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author admin
 */
public class CheckAge {
    
    public boolean check(int age) throws IllegalAgeException {
            if(age < 0) {
               throw new IllegalAgeException("年齢がマイナス値です。");
            }
            return true;
    } 
}
