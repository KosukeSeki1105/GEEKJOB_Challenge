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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author k-seki
 */
public class test {
    
    public static void main( String[] args ) {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            
            con = JDBCInfo.getConnection();
            
            ps = con.prepareStatement( "SELECT * FROM Users" );
            
            rs = ps.executeQuery();
            
            while( rs.next() ) {
                System.out.print("名前：" + rs.getString( "UserName") );
                System.out.print("パスワード：" + rs.getString( "UserPass") );
            }
        
        } catch ( Exception e ) {
            System.out.println(e.getMessage());
        } finally {
            try {
               if(rs != null) rs.close();
            } catch( SQLException e) {
                e.getMessage();
            try {
               if(ps != null) ps.close();
            } catch( SQLException f ) {
                f.getMessage();
            }
            try {
               if( con != null) con.close();
            } catch(SQLException g) {
                e.getMessage();
            }
        }
        
    }
    }
}
