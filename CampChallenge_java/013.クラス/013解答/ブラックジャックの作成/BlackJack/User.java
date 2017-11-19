package BlackJack;

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

/*
    Userクラス

    setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
    checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
    openは、myCardsのカードの合計値を返却するように実装してください。
*/
public class User extends Human {
    
    // 山札からランダムで2枚引いたカード情報
    private ArrayList<Integer> dealCard = new ArrayList<Integer>();
    
    // 山札からランダムで1枚引いたカード情報
    private ArrayList<Integer> hitCard  = new ArrayList<Integer>();
    

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
        if( total <= 18 ) {   // カード合計値が18以下
            return true;
        } else {              // カード合計が18以上
            return false;
        }
    }

}