/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes.file;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author k-seki
 */
/**
 * 紹介していないJAVAの標準クラスを利用して、処理を作成してください。
 *
 * 講義では紹介されていないJAVAの標準クラスはたくさん存在します。
 * １つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
 * また、この処理を作成するに当たり、下記を必ず実装してください。
 * 1 処理の経過を書き込むログファイルを作成する。
 * 2 処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
 * 3 書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
 * 4 最後に、ログファイルを読み込み、その内容を表示してください。
 * 
 */
public class logfile {
    
    public static void main( String[] args ) throws IOException {
        
        // 標準クラスであるScannerクラスを生成
        Scanner scan = new Scanner( System.in );
        
        System.out.println( "◆◆ファイルに名前を書き込みます◆◆" );
        System.out.print( "名前を入力してください。" );
        System.out.println( "(入力例：山田太郎)" );
        System.out.print( ">>" );
        
        // 名前を取得
        String name = scan.next();
        System.out.println( "ファイルに書き込みます。\n" );
        
        // 書き込みメソッド呼び出し
        writeFile( name );
        
        // 読み込みメソッド呼び出し
        readFile();
         
        // Scannerクローズ
        scan.close();
        
    }
    

    /**
     * 書き込みメソッド
     * 処理の開始タイミングで、ログファイルに開始の書き込み
     * 日時の書き込み
     * 処理の終了タイミングで、ログファイルに終了の書き込み
     * @param name
     * @throws java.io.IOException
    */
    public static void writeFile( String name ) throws IOException {
        
        // 初期化処理
        File file = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        
        try {
            // Fileオープン
            file = new File( "employee.txt" );
            // FileWriter作成
            fw = new FileWriter( file );
            // BufferedWriter作成
            bw = new BufferedWriter( fw );
        
            // フォーマット生成
            SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
            // 開始日時
            Date start = new Date();
            // 終了日時
            Date end = new Date();
            
            // 書き込み
            bw.write( "開始" + "\t" );
            bw.write( sdf.format( start ) + "\r\n" );
            bw.write( "名前：" + name + "\r\n" );
            bw.write( "終了" + "\t" );
            bw.write( sdf.format( end ) + "\r\n" );
            
        } catch( IOException e ) {
            throw new IOException( "入力時にエラーが発生しました。" ); 
            
        } finally {
            try {
                if( bw != null) {       // BufferedWriterクローズ
                    bw.close();
                }
            } catch( IOException e ){
                e.getMessage();
            }
            
            try {
                if( fw != null ) {      // FileWriterクローズ
                    fw.close();
                }
            } catch( IOException e ) {
                e.getMessage();
            }
        }
        
    }
    
    
    // 読み込みメソッド
    public static void readFile() throws FileNotFoundException, IOException {
        
        // 初期化処理
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Fileオープン
            file = new File( "employee.txt" );
            // FileReader作成
            fr = new FileReader( file );
            // BufferedReader作成
            br = new BufferedReader( fr );            
            
            // 一行読み込み
            String line = br.readLine();
            while( line != null ) {
                System.out.println( line );
                line = br.readLine();       // 次の行の読み込み
            }
            
        } catch( FileNotFoundException e ) {
            throw new FileNotFoundException( "ファイルが見つかりませんでした。" );

        } catch( IOException e ) {
            throw new IOException( "出力時にエラーが発生しました。" ); 
            
        } finally {
            try {
                if( br != null) {       // BufferedReaderクローズ
                    br.close();
                }
            } catch( IOException e ){
                e.getMessage();
            }
            
            try {
                if( fr != null ) {      // FileReaderクローズ
                    fr.close();
                }
            } catch( IOException e ) {
                e.getMessage();
            }
        }
        
    }
    
}
