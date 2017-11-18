/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author k-seki
 */
public class Parent {
    
    // フィールド
    public String name;     // 名前
    public int age;         // 年齢
    
    // setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // 表示メソッド
    public void display() {
        System.out.println( "名前：" + name );
        System.out.println( "年齢：" + age );
    }

}
