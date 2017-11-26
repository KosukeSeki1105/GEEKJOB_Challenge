/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import beans.ProductBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import helper.JDBCInfo;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 商品情報取得を実現するクラス
 * @author k-seki
 */
public class Select {
   
    // フィールド
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    
    /**
     * 商品名取得
     * @param productName 
     * @return 商品名
     * @throws ArrayIndexOutOfBoundsException
     * @throws SQLException
     * @throws Exception
     */
    public static final String[] getProductName( String productName ) throws ArrayIndexOutOfBoundsException, SQLException, Exception {
        
        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";
        
        // 検索データを格納するArrayList
        String[] searchResult = new String[1];
        
        // DB接続
        con = JDBCInfo.getConnection();
        
        try {
            // SQL文
            String sql = "SELECT ProductName FROM Products";
            sql += " WHERE productName = ?";
            
            // 商品名を検索
            ps = con.prepareStatement( sql );
            ps.setString( 1, productName );
            rs = ps.executeQuery();
            
            // 検索データ格納
            while( rs.next() ) {
                searchResult[0] = rs.getString( "ProductName" );
            }
        
            // 商品名を返却
            return searchResult;
            
        } catch( ArrayIndexOutOfBoundsException e ) {
            throw new ArrayIndexOutOfBoundsException( errorMessage );
            
        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
            
        } finally {
            // クローズ処理
            JDBCInfo.disconnect( rs, ps, con );
        }
        
    }
    
    
    /**
     * 商品IDと商品名取得
     * @return 商品IDと商品名情報
     * @throws SQLException
     * @throws Exception
     */
    public static final ArrayList<ProductBean> getProductIDName() throws SQLException, Exception {
        
        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";
        
        // 検索データを格納するArrayList
        ArrayList<ProductBean> productNames = new ArrayList<ProductBean>();
        
        // DB接続
        con = JDBCInfo.getConnection();
        
        try{
            // SQL文
            String sql = "SELECT ProductID, ProductName FROM Products";
            
            // 商品IDと商品名を検索
            ps = con.prepareStatement( sql );
            rs = ps.executeQuery();
            
            // 検索データ格納
            while( rs.next() ) {
                // 情報格納用のBean生成
                ProductBean pb = new ProductBean();
                
                // フィールドにそれぞれ値を設定
                pb.setProductID( rs.getInt( "ProductID" ) );
                pb.setProductName( rs.getString( "ProductName" ) );
                // ArrayListに格納
                productNames.add( pb );
            }
            
            // 検索データを返却
            return productNames;
            
        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
            
        } finally {
            // クローズ処理
            JDBCInfo.disconnect( rs, ps, con );
        }
        
    }
    
    
    /**
     * 商品情報全てを取得
     * @return 全商品情報
     * @throws Exception
     */
    public static final ArrayList<ProductBean> getProductAll() throws Exception {
        
        // エラーメッセージ
        String errorMessage = "予期しないエラーが発生しました。管理者にお問い合わせください。";
        
        // Bean格納用のArrayList作成
        ArrayList<ProductBean> ProductsData = new ArrayList();
        
        // DB接続
        con = JDBCInfo.getConnection();
        
        try {
            // SQL文
            String sql = "SELECT * FROM Products";
            
            // 商品情報全てを検索
            ps = con.prepareStatement( sql );
            rs = ps.executeQuery();
            
            // データ格納
            while( rs.next() ) {
                // 情報格納用のBean生成
                ProductBean pb = new ProductBean();
                
                // フィールドにそれぞれ値を設定
                pb.setProductID( rs.getInt( "ProductID" ));
                pb.setProductName( rs.getString( "ProductName" ) );
                pb.setPrice( rs.getInt( "Price" ) );
                pb.setStock( rs.getInt( "Stocks" ) );
                pb.setUpdateTime( rs.getTimestamp( "UpdateTime" ) );
                
                // ArrayListに格納
                ProductsData.add( pb );
            }
            
            // ArrayList返却
            return ProductsData;
            
        } catch( SQLException e ) {
            throw new SQLException( errorMessage );
            
        } finally {
            // クローズ処理
            JDBCInfo.disconnect( rs, ps, con );
        }
        
    }
    
}
