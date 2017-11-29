/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.HashMap;

/**
 * 共通 - ユーザー情報DB処理
 * データベース処理系全般をつかさどるオブジェクト。
 * 基本的にデータはUserDataDTO経由。 
 *
 * @author seki-k
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    
    /**
     * データの検索処理を行う。
     * 該当するデータがあった場合はreturnを返す。
     * 該当するデータがなかった場合はfalseを返す。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public boolean search(UserData ud) throws SQLException{
        Connection con       = null;
        PreparedStatement st = null;
        ResultSet rs         = null;
        try{
            //DB検索処理
            con = DBManager.getConnection();
            st  = con.prepareStatement("SELECT * FROM user_t WHERE name = ? and password = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            rs  = st.executeQuery();
                        
            //該当するデータがあった場合は配列に格納
            //deleteFlgの値も格納            
            ArrayList<String> resultDetail = new ArrayList<String>();
            while(rs.next()){
                resultDetail.add(rs.getString("name"));
                resultDetail.add(rs.getString("password"));
                resultDetail.add(String.valueOf(rs.getInt("deleteFlg")));                
            }
            
            //if(配列の要素数が０でないかつdeleteFlgが１でない場合) ※該当するデータあり
            //trueを返却            
            //else(配列の要素数が０の場合)  ※該当するデータなし
            //falseを返却
            if(resultDetail.size() != 0 && !resultDetail.get(2).equals("1")){
                return true;
            }else{
                return false;
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(rs  != null){ rs.close(); }
            if(st  != null){ st.close(); }
            if(con != null){ con.close(); }
        }        
    }
    
    
    /**
     * データの詳細検索処理を行う。
     * 該当するデータをuserID以外返す。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public UserDataDTO searchDetail(UserData ud) throws SQLException{
        Connection con       = null;
        PreparedStatement st = null;
        ResultSet rs         = null;
        try{
            //詳細検索処理
            con = DBManager.getConnection();
            st  = con.prepareStatement("SELECT userID, name, password, mail, address, total, newDate FROM user_t WHERE name = ? AND password = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            rs  = st.executeQuery();
            
            //詳細検索結果をUserDataDTOに格納し、返却
            UserDataDTO userDetail = new UserDataDTO();
            while(rs.next()){
                userDetail.setUserID(rs.getInt("userID"));
                userDetail.setName(rs.getString("name"));
                userDetail.setPassword(rs.getString("password"));
                userDetail.setMail(rs.getString("mail"));
                userDetail.setAddress(rs.getString("address"));
                userDetail.setTotal(rs.getInt("total"));
                userDetail.setNewDate(rs.getTimestamp("newDate"));                
            }
            return userDetail;            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(rs  != null){ rs.close(); }
            if(st  != null){ st.close(); }
            if(con != null){ con.close(); }
        }        
    }
    
    
    /**
     * 既に使用されているユーザー名・パスワード・メールアドレスがあるかどうかの検索処理を行う。
     * 該当するデータを連想配列で返す。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public HashMap<String, String> confirm(UserData ud) throws SQLException{
        Connection con       = null;
        PreparedStatement st = null;
        ResultSet rs         = null;
        try{
            //sql文の記述を省くための変数sql
            String sql = "SELECT * FROM user_t";
            
            //該当するデータがあるかの検索処理
            //ユーザー名
            //パスワード
            //メールアドレス
            //HashMap作成
            //if(ユーザー名が使用済み)
            //キーをnameとして入力フォームのデータを格納
            //if(パスワードが使用済み)
            //キーをpasswordとして入力フォームのデータを格納
            //if(メールが使用済み)
            //キーをmailとして入力フォームのデータを格納
            //HashMapを返却
            con = DBManager.getConnection();
            st  = con.prepareStatement(sql + " WHERE name = ?");
            st.setString(1, ud.getName());
            rs  = st.executeQuery();
            UserDataDTO rc1 = new UserDataDTO();
            while(rs.next()){
                rc1.setName(rs.getString("name"));
            }
                        
            st  = con.prepareStatement(sql + " WHERE password = ?");
            st.setString(1, ud.getPassword());
            rs  = st.executeQuery();
            UserDataDTO rc2 = new UserDataDTO();
            while(rs.next()){
                rc2.setPassword(rs.getString("password"));
            }
                        
            st  = con.prepareStatement(sql + " WHERE mail = ?");
            st.setString(1, ud.getMail());
            rs  = st.executeQuery();
            UserDataDTO rc3 = new UserDataDTO();
            while(rs.next()){                
                rc3.setMail(rs.getString("mail"));
            }
            
            HashMap<String, String> index = new HashMap<String, String>();
            if(ud.getName().equals(rc1.getName())){
                index.put("name", ud.getName());
            }
            if(ud.getPassword().equals(rc2.getPassword())){
                index.put("password", ud.getPassword()) ;
            }
            if(ud.getMail().equals(rc3.getMail())){
                index.put("mail", ud.getMail()); 
            }
            
            return index;
                       
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(rs  != null){ rs.close(); }
            if(st  != null){ st.close(); }
            if(con != null){ con.close(); }
        }        
    }        
    
    
    /**
     * データの挿入処理を行う。現在時刻 年月日時分 は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserData ud) throws SQLException{
        Connection con       = null;
        PreparedStatement st = null;
        try{
            //挿入処理
            con = DBManager.getConnection();
            st  = con.prepareStatement("INSERT INTO user_t(name, password, mail, address, newDate) VALUES(?, ?, ?, ?, ?)");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(st  != null){ st.close();}
            if(con != null){ con.close(); }
        }
    }
    
    
    /**
     * データの更新処理を行う。現在時刻 年月日時分 は更新直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void update(UserData ud) throws SQLException{
        Connection con        = null;
        PreparedStatement  st = null;
        try{
            //更新処理
            con = DBManager.getConnection();
            st  = con.prepareStatement("UPDATE user_t SET name = ?, password = ?, mail = ?, address = ?, newDate = ? WHERE userID = ?");
            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, ud.getUserID());
            st.executeUpdate();
            System.out.println("update completed!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);        
        }finally{
            if(st != null) { st.close(); }
            if(con != null){ con.close(); }
        }
    }
    

    /**
     * deleteFlgを１にする処理。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void delete(UserData ud) throws SQLException{
        Connection con       = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st  = con.prepareStatement("UPDATE user_t SET deleteFlg = ? WHERE userID = ?");
            st.setInt(1, 1);
            st.setInt(2, ud.getUserID());
            st.executeUpdate();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(st != null) { st.close(); }
            if(con != null){ con.close(); }
        }        
    }

}
