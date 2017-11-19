/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author k-seki
 */
// ファイルから自己紹介を読み出し、表示してください。
public class filereader {
    
    public static void main( String[] args ) 
            throws FileNotFoundException, IOException {
        
        // Fileオープン
        File file = new File( "text.txt" );
        
        // FileReader作成
        FileReader fr = new FileReader( file );
        
        // BufferedReader作成
        BufferedReader br = new BufferedReader( fr );
        
        // 読み込み
        System.out.println( br.readLine() );
        
        // クローズ
        br.close();
        fr.close();
        
    }
    
}
