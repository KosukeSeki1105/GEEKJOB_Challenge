/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author k-seki
 */
// ファイルに自己紹介を書き出し、保存してください。
public class filewriter {
    
    public static void main( String[] args ) throws IOException {
        
        // 自己紹介
        String introduce = "関皓理です。よろしくお願いします。";
        
        // Fileオープン
        File file = new File( "text.txt" );
        
        // FileWriter作成
        FileWriter fw = new FileWriter( file );
        
        // 書き込み
        fw.write( introduce );
        
        // クローズ
        fw.close();
        
    }
    
}
