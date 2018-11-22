/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication16;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Jurate Valatkevicien
 * System.in
 * System.out
 * System.err
 */
public class JavaApplication16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer [] mas = {1, 4, 3, null, -1, 7};
        int c = 0; final int cc = c;
        
        Arrays.sort(mas, new Comparator<Integer>(){   //Comparator yra interfeisas
            
            private int count = 0;
            private void printCounter(Integer a, Integer b){
                System.out.println(++count+":   " + a + "    " + b);
            }
            @Override
            public int compare(Integer a, Integer b){
                System.out.println(cc);
                printCounter(a, b);
                if(a == null){
                    if(b == null){
                        return 0;
                    }
                    return -1;
                }else {
                    if(b == null){
                        return 1;
                    }
                    return a-b;
                }
            }
        });
        
        Arrays.sort(mas, (a, b) ->{//liambda exprešinai savo THIS neturi
            System.out.println(cc);
            if(a == null){
                    if(b == null){
                        return 0;
                    }
                    return -1;
                }else {
                    if(b == null){
                        return 1;
                    }
                    return a-b;
                }
        
        });
        
        System.out.println(Arrays.toString(mas));
    }
    
    
    
}
