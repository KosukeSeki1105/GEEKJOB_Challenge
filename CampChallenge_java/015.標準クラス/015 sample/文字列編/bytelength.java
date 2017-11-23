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
// 自分の氏名について、バイト数と文字数を取得して、表示してください。
public class bytelength {
    
    public static void main( String[] args ) {
        
        String name = "関皓理";
        
        // バイト数を表示
        System.out.println( name.getBytes().length );
        
        // 文字数を表示
        System.out.println( name.length() );
        
    }
    
}
