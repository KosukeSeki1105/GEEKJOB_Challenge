/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.string;

/**
 *
 * @author k-seki
 */
// 自分のメールアドレスの「@」以降の文字を取得して、表示してください。
public class substring {
    
    public static void main( String[] args ) {
    
        String mail = "kosuke.seki.1105@gmail.com";
        
        // 「@」が出現する位置を取得
        int index = mail.indexOf( "@" );
        
        // 「@」以降の文字を取得して表示
        System.out.println( mail.substring( index ) );
        
    }
    
}
