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
    Humanという抽象クラスを作成し、以下を実装してください。

    openというabstractな公開メソッドを用意してください。
    setCardというArrayListを引数とした、abstractな公開メソッドを用意してください。
    checkSumというabstractな公開メソッドを用意してください。
    myCardsというArrayListの変数を用意してください。
*/
abstract class Human {
    
    public abstract int open( ArrayList<Integer> myCards );
    public abstract ArrayList<Integer> setCard( ArrayList<Integer> setCard );
    public abstract boolean checkSum(int total);
    
    // 手札
    public ArrayList<Integer> myCards = new ArrayList<Integer>();
    
}
