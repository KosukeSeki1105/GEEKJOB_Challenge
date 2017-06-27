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
class Hito {
    public String name;
    public int age;

    public void setHuman(String n, int a) {
        this.name = n;
        this.age = a;
    }
    
    public void printHuman(){
        System.out.print(name + age);
}
}


public class Human {
    public static void main(String[] args) {
        Hito human = new Hito();
        
        human.setHuman("せき", 23);
        
        /*human.name = "seki";
        human.age = 23;
        */
    }

}
    


