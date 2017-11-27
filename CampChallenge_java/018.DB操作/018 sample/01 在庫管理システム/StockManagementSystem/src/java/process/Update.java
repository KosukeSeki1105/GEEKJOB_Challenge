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
 * 登録済み商品の情報更新処理を実現するクラス
 * @author k-seki
 */
public class Update {
    
    // フィールド
    private static Connection con = null;
    private static PreparedStatement ps = null;

    /**
     * 登録済み商品の情報更新
     * @param productID
     * @param price
     * @param stock
     * @throws SQLException
     * @throws Exception
     */
    public static final void updateProduct( int productID, int price, int stock) throws SQLException, Exception {
        
        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";

        // DB接続
        con = JDBCInfo.getConnection();
        
        try {
            // SQL文
            String sql = "UPDATE products";
            sql += " SET Price = ?, Stocks = ? ";
            sql += "WHERE ProductID = ?";
            
            // 登録済み商品の情報更新
            ps = con.prepareStatement( sql );
            ps.setInt( 1, price );
            ps.setInt( 2, stock );
            ps.setInt( 3, productID );
            ps.executeUpdate();
            
        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
            
        } finally {
            // クローズ処理
            JDBCInfo.disconnect( ps, con );
        }
        
    }
    
}
