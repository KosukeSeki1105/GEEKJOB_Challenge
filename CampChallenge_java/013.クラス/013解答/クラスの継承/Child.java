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
public class Child extends Parent {
    
    // メソッド作成
    public void clear() {
        super.name = "";
        super.age = 0;
    }
    
}
