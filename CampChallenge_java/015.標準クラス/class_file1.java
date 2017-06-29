/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;
import java.io.*;

/**
 *
 * @author guest1Day
 */
public class class_file1 {
    public static void main(String [] args) throws IOException{
        File fp = new File("test.txt");
      
        FileWriter fw = new FileWriter(fp);
        
        fw.write("関皓理です。宜しくお願いします。");
        
        fw.close();
    }
}
