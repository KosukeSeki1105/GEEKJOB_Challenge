/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB接続・切断を一手に担うクラス
 * @author k-seki
 */
public class JDBCInfo {
    
    /**
     * DB接続
     * @return Connnection
     * @throws Exception 
     */
    public static final Connection getConnection() throws Exception {
        
        // DB接続成功メッセージ
        String message = "DB接続成功";
        
        // 例外メッセージ
        final String MESSAGE = "接続時にエラーが発生しました。";        
        
        // Connection初期化
        Connection con = null;
        
        try {
            // クラス生成
            Class.forName( "com.mysql.jdbc.Driver" ).newInstance();
            
            // DB接続
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/testdb", "root", "root" );
            System.out.println( message );
            
        } catch( Exception e ) {
            // エラーメッセージ作成
            throw new Exception( MESSAGE );
        }
        
        // Connection返却
        return con;
            
    }
    
    
    /**
     * DB切断
     * 
     * @param rs
     * @param ps
     * @param con
     * @throws SQLException
     */
    public static final void disconnect( ResultSet rs, PreparedStatement ps, Connection con ) throws SQLException {
        
        // DB切断成功メッセージ
        String message = "クローズ成功";
        
        try {
            
        }finally {    
            // ResultSetクローズ
            if( rs != null) {
                rs.close();
                System.out.println( message );
            }

            // PreparedStatementクローズ
            if( ps != null ) {
                ps.close();
                System.out.println( "message" );
            }
        
            // Connectionクローズ
            if( con != null ) {
                con.close();
                System.out.println( "message" );
            }
        }
        
    }
    
    
    /**
     * DB切断(オーバーロード)
     * 
     * @param ps
     * @param con
     * @throws SQLException 
     */
    public static final void disconnect( PreparedStatement ps, Connection con ) throws SQLException {
        
        ResultSet rs = null;
        
        // メソッド呼び出し
        disconnect( rs, ps, con );
    
    }
    
}
