/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import helper.JDBCInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ログインを実現するクラス
 * @author k-seki
 */

public class Login {
    
    // フィールド
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    /**
     * ログインチェック
     * @param name
     * @param password
     * @return userData
     * @throws SQLException
     * @throws ArrayIndexOutOfBoundsException
     * @throws Exception 
     */
    public static String[] loginCheck( String name, String password ) throws SQLException, ArrayIndexOutOfBoundsException, Exception {

        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";
        
        // 検索データ1件を格納する配列
        String[] userData = new String[1];
        
        // DB接続
        con = JDBCInfo.getConnection();

        try{
            // ユーザー名とパスワードが一致するレコードを検索
            ps = con.prepareStatement( "SELECT UserName FROM Users WHERE UserName = ? AND UserPass = ?" );
            ps.setString( 1, name );
            ps.setString( 2, password );
            rs = ps.executeQuery();
        
            // 該当するデータがある
            while( rs.next() ) {
                userData[0] = rs.getString( "UserName" );
            }
            
            // 検索データ1件を返却
            return userData;
            
        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
             
        } catch( ArrayIndexOutOfBoundsException e ) {
            throw new ArrayIndexOutOfBoundsException( errorMessage );
            
        } finally {
            // クローズ処理
            JDBCInfo.disconnect( rs, ps, con );
        }
        
    }
    
}
