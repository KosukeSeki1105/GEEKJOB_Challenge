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
/**
 * 以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、
 * 結果を表示してください。
 *「きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます」 
 */
public class replace {
    
    public static void main( String[] args ) {
        
        String message = " きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます" ;
        
        // 「I」⇒「い」に入れ替える
        message = message.replaceAll( "I" , "い" ) ;
        // 「U」⇒「う」に入れ替える
        message = message.replaceAll( "U", "う" );
        
        System.out.println( message );
        
    }
    
}
