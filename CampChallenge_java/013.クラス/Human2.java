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
class Dobutsu{
    public String name;
    public int age;
    
    public void setDobutsu(String n, int a){
        this.name = n;
        this.age = a;
    }
    
    public void printDobutsu(){
        System.out.print(name + age);
    }
}


class Inu extends Dobutsu{
    public void gei(){
        String msg = this.age + "歳の" + this.name + "はお手ができます。";
        System.out.print(msg);
    }
    public void clear(){
        this.name = "";
        this.age = 0;
    }
} 

public class Human2 {
    public static void main(String[] args){
     Inu a = new Inu();
     
     a.setDobutsu("Pochi", 2);
     a.gei();
     
     a.clear();
     a.gei();
    }
}
