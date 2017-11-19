/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.date;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author k-seki
 */
// 2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）
// を表示してください。
public class calc_timestamp {
    
    public static void main( String[] args ) {
        
        // Calendarクラス生成
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        
        // 2015年1月1日 0時0分0秒を設定
        calendar1.set( 2015, 00, 01, 00, 00, 00 );
        // 2015年12月31日 23時59分59秒を設定
        calendar2.set( 2015, 11, 31, 23, 59, 59 );
        
        // Dateオブジェクトを取得
        Date date1 = calendar1.getTime();
        Date date2 = calendar2.getTime();
        
        // 差（ミリ秒）を計算
        long result = date2.getTime() - date1.getTime();
        
        // 計算結果を表示
        System.out.println( result );
        
    }
    
}
