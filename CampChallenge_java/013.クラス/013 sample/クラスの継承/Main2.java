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
/**
 * 「クラスの作成」で作成したクラスを継承し、以下の機能を持つクラスを作成してください。
 *  ２つの変数の中身をクリアするパブリックなメソッド
 */
class Main2 {

    public static void main(String[] args) {
        // Childクラスをインスタンス生成
        Child c = new Child();
        
        // メソッド呼び出し
        c.name = "山田一郎";
        c.age = 8;
        c.display();
        
        // ２つの変数nameとageの中身をクリア
        c.clear();
        c.display();

    }
    
}
