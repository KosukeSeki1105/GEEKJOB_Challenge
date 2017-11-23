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
 * 以下の機能を持つクラスを作成してください。
 * パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、
 * ２つの変数の中身をprintするパブリックなメソッド
 */
class Main {

    public static void main( String[] args ) {
        // Parentクラスをインスタンス生成
        Parent p = new Parent();
        
        // メソッド呼び出し
        p.setName( "山田太郎" );
        p.setAge( 34 );
        p.display();
        
    }

}
