/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(fakt(7));
        
        
        List l1 = Arrays.asList(1, 3, 5);
        List l2 = Arrays.asList(4, 6, 8);
        List l = Arrays.asList(-1, l1, 14, l2, -3);
        
        
        
        l2.add(l1);
        
        
        System.out.println("");
        System.out.println(l1);
        System.out.println("");
        System.out.println(l2);
        System.out.println("");
        System.out.println(l);
        System.out.println("");
        //System.out.println(listuSuma(l));
    }
    
    
    public static int fakt(int i){
        if (i > 1) 
            return i*fakt(i-1);
        return i;
    }
    
//    public static int fakt(int i){
//        if(i == 1) return i;
//        return i*fakt(i-1);
//    }
    
    public static int listuSuma(List l){
        int ilg = l.size();
        int sum = 0;
        for(int i = 0; i < ilg; i++){
           if(l.get(i) instanceof List){
               sum = sum + listuSuma((List)l.get(i));
           }
           else {
               sum = sum + (int)l.get(i);
           }
        }
        return sum;
    }
}
