/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author k-seki
 */
// 現在の日時を「年-月-日 時:分:秒」で表示してください。
public class current_time {
    
    public static void main( String[] args ) {
        
        // Dateオブジェクトを取得
         Date date = new Date(); 
    
        // SimpleDateFormatオブジェクトを取得
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    
        // フォーマット
        System.out.println( sdf.format( date ) );
    
    }
    
}
