package BlackJack;


import BlackJack.User;
import BlackJack.Dealer;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k-seki
 */
// カードのやり取りは自動で構いません、カードの変化と最終結果を表示してください。
public class Main {
    
    public static void main(String[] args) {
        
        // Dealerクラスをインスタンス生成
        Dealer dealer = new Dealer();
        // Userクラスをインスタンス生成
        User user = new User();
     
        // dealcard
        ArrayList<Integer> dealcard = new ArrayList<Integer>();
        
        // dealerの手札
        ArrayList<Integer> dealerMyCards = new ArrayList<Integer>();
        // userの手札
        ArrayList<Integer> userMyCards = new ArrayList<Integer>();
        
        // dealerのhitCard
        ArrayList<Integer> dealerHitCard = new ArrayList<Integer>();
        // userのhitCard
        ArrayList<Integer> userHitCard = new ArrayList<Integer>();
        
        
        System.out.println( "◆◆ゲームスタート◆◆" );
        
        
        for( int i = 1; i <= 2; i++ ) {     // dealerとuserの2人分
            // 山札から2枚引く
            dealcard = dealer.deal();
            switch( i ) {
                case 1:                     // dealerの手札にカード情報を追加
                    dealerMyCards = dealer.setCard( dealcard );
                    break;
                case 2:                     // userの手札にカード情報を追加
                    userMyCards = user.setCard( dealcard );
                    break;
            }
        }
        

        // dealerの手札合計
        int dealerTotal = dealer.open( dealerMyCards );
        // userの手札合計
        int userTotal = user.open( userMyCards );
        
        
        // dealerとuserのカード合計を表示
        System.out.println( "dealerの手札：" + dealerTotal );
        System.out.println( "userの手札：" + userTotal );
        System.out.println();
        
        
        // dealerのhit判断
        while( dealer.checkSum( dealerTotal ) ) {   // dealerの手札合計が17以下
            System.out.println( "dealer：HIT" );
            dealerHitCard = dealer.hit();                       // hit
            dealerMyCards = dealer.setCard( dealerHitCard );    // dealerの手札にカード情報を追加
            dealerTotal = dealer.open( dealerMyCards );         // dealerの手札合計
            System.out.println( "手札合計：" + dealerTotal + "\n" );
        }
        
        // userのhit判断
        while( user.checkSum( userTotal ) ) {   // userの手札合計が18以下
            System.out.println( "user：HIT" );
            userHitCard = dealer.hit();                   // hit
            userMyCards = user.setCard( userHitCard );    // userの手札にカード情報を追加
            userTotal = user.open( userMyCards );         // userの手札合計
            System.out.println( "手札合計：" + userTotal + "\n" );
        }

        
        // dealerとuserのカード合計を表示
        System.out.println();
        System.out.println( "◆◆ゲーム結果◆◆" );
        System.out.println( "dealerの手札：" + dealerTotal );
        System.out.println( "userの手札：" + userTotal );
        System.out.println();
        
        
        /**
         * ゲーム結果
         * ・userの勝利 
         *   1 dealerがBUST
         *   2 userのカード合計がdealerより21に近い 
         * ・userの負け
         * 　1 userがBUST
         * 　2 dealerのカード合計がuserより21に近い
         * ・引き分け
         * 　1 userもdealerもBUST
         * 　2 userとdealerのカード合計が21以下でかつ同数
         */
        if( dealerTotal > 21 && userTotal <= 21 ) {         // dealerがBUST
            System.out.print( "BUST：" );
            System.out.println( "userの勝利" );
            
        } else if( dealerTotal <= 21 && userTotal > 21 ) {  // userがBUST
            System.out.print( "BUST：" );
            System.out.println( "userの負け" );
            
        } else if( dealerTotal > 21 && userTotal > 21 ) {   // userもdealerもBUST
            System.out.print( "BUST：" );
            System.out.println( "引き分け");
            
        } else if( dealerTotal < userTotal ) {  // userのカード合計がdealerより21に近い
            System.out.println( "userの勝利" );
            
        } else if( dealerTotal > userTotal ) {  // dealerのカード合計がuserより21に近い
            System.out.println( "userの負け" );
            
        } else if( dealerTotal == userTotal ) {  // userとdealerのカード合計が21以下でかつ同数
            System.out.println( "引き分け" );
        }
        
    }
    
}