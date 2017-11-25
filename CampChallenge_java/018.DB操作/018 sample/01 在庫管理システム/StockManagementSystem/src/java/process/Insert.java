/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import helper.JDBCInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 商品登録を実現するクラス
 * @author k-seki
 */
public class Insert {
    
    // フィールド
    private static Connection con = null;
    private static PreparedStatement ps = null;
    
    /**
     * 商品登録
     * @param productName
     * @param price
     * @param stock
     * @throws SQLException
     * @throws Exception
     */
    public static void insert( String productName, int price, int stock ) throws SQLException, Exception {
       
        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";

        // DB接続
        con = JDBCInfo.getConnection();
        
        try {
            // SQL文
            String sql = "INSERT INTO Products";
            sql += "( ProductName, Price, Stocks) ";
            sql += "VALUES( ?, ?, ? )";
            
            // 商品新規登録
            ps = con.prepareStatement( sql );
            ps.setString( 1, productName );
            ps.setInt( 2, price );
            ps.setInt( 3, stock );
            ps.executeUpdate();

        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
            
        }finally{
            // クローズ処理
            JDBCInfo.disconnect( ps, con ); 
        }
        
    }
        
}
