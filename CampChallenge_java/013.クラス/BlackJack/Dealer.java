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
    class Dealer extends Human{
    
    ArrayList <Integer> Cards = new ArrayList<Integer>();
    public Dealer(){
        for(int i = 1; i <= 13; i++){
            for(int j = 1; j <= 4; j++){
                if(i >10){
                    Cards.add(10);
                }else{
                    Cards.add(i);
                }
            }
        }
    }
    public ArrayList<Integer> deal(){
        //山札から２枚引いたカードをdealCardにセット
        ArrayList <Integer> dealCard = new ArrayList<Integer>();
        Random rand = new Random();
        
        Integer index = rand.nextInt(Cards.size());
        dealCard.add(Cards.get(index));
        Cards.remove(index);
        System.out.println(Cards.size());
        //System.out.println(Cards.get(index));
        Integer index1 = rand.nextInt(Cards.size());
        dealCard.add(Cards.get(index1));
        Cards.remove(index1);
        System.out.print(Cards.size());
                
//        for(int i = 0; i < 2; i++){
//        Integer index = rand.nextInt(Cards.size());
//                dealCard.add(Cards.get(index));
//        }
                return dealCard;
    }
        
    public ArrayList<Integer> hit(){
        ArrayList <Integer> hitCard = new ArrayList<Integer>();    
        System.out.print(Cards.size());
        Random rand1 = new Random();
        
        Integer index = rand1.nextInt(Cards.size());
        hitCard.add(Cards.get(index));
        return hitCard;
    }
    
   
    
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

        
    


