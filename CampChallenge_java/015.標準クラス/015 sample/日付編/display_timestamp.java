/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author k-seki
 */
// 2016年11月4日 10時0分0秒のタイムスタンプを作成し、
//「年-月-日 時:分:秒」で表示してください。
public class display_timestamp {
    
    public static void main( String[] args ) {
        
        // Calensarクラス生成
        Calendar calendar = Calendar.getInstance();
    
        // 2016年11月4日 10時0分0秒を設定
        calendar.set( 2016, 10, 4, 10, 00, 00 );
        
        // Dateオブジェクト取得
        Date date = calendar.getTime();
        
        // タイムスタンプ作成
        long timestamp = date.getTime();
        
        // SimpleDateFormatオブジェクトを取得
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        
        // フォーマット
        System.out.println( sdf.format( timestamp ) );
    
    }
    
}
