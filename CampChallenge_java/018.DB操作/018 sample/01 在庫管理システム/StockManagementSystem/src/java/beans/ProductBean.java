/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * 検索した商品情報を保持するクラス
 * @author k-seki
 */
public class ProductBean implements Serializable {
    
    // フィールド
    private int productID;
    private String productName;
    private int price;
    private int stock;
    private String updateTime;

    // コンストラクタ
    public ProductBean() {}
    
    // getter・setter
    public int getProductID() {
        return productID;
    }
    public void setProductID( int productID ) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice( int price ) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock( int stock ) {
        this.stock = stock;
    }

    public String getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime( Timestamp updateTime ) {
        // 表示用にフォーマット
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd HH:mm" );
        this.updateTime = sdf.format( updateTime );
    }
    
}
    