package BlackJack;

import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author k-seki
 */
/*
    Dealerクラス

    cardsというArrayListの変数を用意し、初期処理でこのcardsに全てのトランプを持たせてください。
    dealという公開メソッドを用意し、cardsからランダムで2枚のカードをArrayListにして返却してください。
    hitという公開メソッドを用意し、cardsからランダムで1枚のカードをArrayListにして返却してください。

    setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
    checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
    openは、myCardsのカードの合計値を返却するように実装してください。
*/
public class Dealer extends Human {
    
    // 山札
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    
    // 山札からランダムで2枚引いたカード情報
    private ArrayList<Integer> dealCard = new ArrayList<Integer>();
    
    // 山札からランダムで1枚引いたカード情報
    private ArrayList<Integer> hitCard = new ArrayList<Integer>();
    
    
    // コンストラクタ
    public Dealer() {  //cardsに全てのトランプを持たせる
        for( int i = 1; i <= 13; i++ ) {    
            for( int j = 1; j <= 4; j++ ) {
                if( i > 10 ) {      // 10以上は10として山札にセット
                    cards.add( 10 );
                } else {
                    cards.add( i );
                }
            }
        }
    }
    
    
    //dealという公開メソッドを用意し、cardsからランダムで2枚のカードをArrayListにして返却
    public ArrayList<Integer> deal() {
        // Randomクラス生成
        Random random = new Random();
        
        for( int i = 1; i <= 2; i++ ) {
            // 1枚のカードを引く
            Integer index = random.nextInt( cards.size() );
            
            // dealCardにカード情報を追加
            dealCard.add( cards.get( index ) );
            
            // 山札からカード情報を削除
            cards.remove( (int)index );
        }

        // dealCardを返却
        return dealCard;
    }
    
    
    //hitという公開メソッドを用意し、cardsからランダムで1枚のカードをArrayListにして返却
    public ArrayList<Integer> hit() {
        // 1枚のカードを引く
        Integer index = new Random().nextInt( cards.size() );
        
        // hitCardにカード情報を追加
        hitCard.add( cards.get( index ) );
        
        // 山札からカード情報を削除
        cards.remove( (int)index );
        
        // hitCardを返却
        return hitCard;
    }
    
    
    //openは、myCardsのカードの合計値を返却するように実装
    @Override
    public int open( ArrayList<Integer> myCards ) {
        // カードの合計値
        int total = 0;
        
        // 拡張for文
        for( int value : myCards ) {    // myCardsのカード合計を求める
            total += value;
        }
        
        // カードの合計値を返却
        return total;
    }
    

    //setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装
    @Override
    public ArrayList<Integer> setCard( ArrayList<Integer> setCard ) {
        switch( setCard.size() ) {
            case 1:                               // setCardの正体がhitCardの場合
                myCards.add( setCard.get( 0 ) );  // myCardsにカード情報を追加
                setCard.remove( 0 );              // hitCardのカード情報を削除
                break;
                
            case 2:                                            // setCardの正体がdealCardの場合
                for( int i = 0; i <= setCard.size(); i++ ) {  // 2枚のカード情報
                    myCards.add( setCard.get( 0 ) );          // myCardsにカード情報を追加
                    setCard.remove( 0 );                      // dealCardのカード情報を削除
                }
                break;
        }

        // myCradsを返却
        return myCards;
    }


    //checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装
    @Override
    public boolean checkSum( int total ) {
        if( total <= 17 ) {   // カード合計値が17以下
            return true;
        } else {             // カード合計が18以上
            return false;
        }
    }
    
}