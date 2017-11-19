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
// 2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
public class crate_timestamp {
    
    public static void main( String[] args ) {
        
        // Calendarクラス生成
        Calendar calendar = Calendar.getInstance();
    
        // 2016年1月1日 0時0分0秒を設定
        calendar.set( 2016, 0, 1, 00, 00, 00 );
        
        // Dateオブジェクトを取得
        Date date = calendar.getTime();
        
        // タイムスタンプ表示
        System.out.println( date.getTime() );
        
    }
    
}
