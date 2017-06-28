/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
class User extends Human{
    
    
    
    
    @Override
    public int open(){
        int x = 0;
        for(int i = 0; i < myCards.size(); i++){
            x += myCards.get(i);
        }
        return x;
    }
    @Override
    public void setCard(ArrayList<Integer> set){
       for(int i =0; i < set.size(); i++){
           myCards.add(set.get(i));
       }
    }
    @Override
    public boolean checkSum(){
        if(open() < 18){
            return true;
    }else{
            return false;
        }
}
    
    
    
    
}


