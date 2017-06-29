/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author guest1Day
 */

public class class_file3 {
    public static void main(String[] args) throws IOException{
        File fp1 = new File("test2.txt");
        
        FileWriter fw2 = new FileWriter(fp1);
        
        Date start = new Date();
        //System.out.println(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        
        
        fw2.write(sdf.format(start) + "開始\r\n");

        //ArrayListに0～100までの数字を入れる
        ArrayList a = new ArrayList();
        for(int i = 0; i <= 100; i++){
            a.add(i);
        }
        
        //0から100までの数字を2回ランダムで選ぶ
        //1回目：英語の得点に加える
        //2回目：数学の得点に加える
        Random rand = new Random();
        Integer index = rand.nextInt(a.size());
        System.out.println("英語："+ index + "点");
        
        Random rand1 = new Random();
        Integer index1 = rand.nextInt(a.size());
        System.out.println("数学：" + index1 + "点");
        
        //点数の低いほうを調べる
        //if(両者同じ点である)
        //"両方とも・・・"を表示
        //else
        //x + "点だったほうは・・"を表示
        int x = Math.min(index, index1);
        if(index == index1){
            System.out.println("両方とも・・・");    
        }else{
        System.out.println(x + "点だったほうは・・");
        }
        
        //if(xが50未満である)
        //"怒られた"を表示
        //else if(xが70未満である)
        //"特に何も言われなかった"を表示
        //else
        //"褒められた"を表示
        if(x < 50){
            System.out.println("怒られた");
        }else if(x < 70){
            System.out.println("特に何も言われなかった");
        }else{
            System.out.println("褒められた");
        }
        
       
        Date end = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        //System.out.println(sdf1.format(end));
        fw2.write(sdf.format(end) +"終了");

        fw2.close();
        
        FileReader fr = new FileReader(fp1);
        BufferedReader br = new BufferedReader(fr);
        
        String str = br.readLine();
        while(str != null){
            System.out.println(str);
            str = br.readLine();
        }
        br.close();
        
    }
}

