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
        
        
        List  l1 = Arrays.asList(1, 3, 5);
        l1 = new ArrayList(l1);
        List l2 = Arrays.asList(4, 6, 8);
        l2 = new ArrayList(l2);
        List l = Arrays.asList(-1, l1, 14, l2, -3);
        l = new ArrayList(l);

        
        
        
        
        l1.add(l2);
        l2.add(l);
        
        //l.add(11);
       
        System.out.println("*****************");
        System.out.println(listuSuma(l));
        System.out.println("*******************");

        
        
//        l1.add(l2);
//        //l1.add(l); // rekursiniai kreipiniai, nes į listą sedama nuoroda į listą
//        System.out.println("*************");
//        System.out.println(l1);
//        System.out.println(l); 
//        
//        System.out.println(listuSuma(l));
//        //*******************************************
        
//        List mas1 = new ArrayList();
//        List mas2 = new ArrayList();
//        List mas3 = new ArrayList();
//       
//        mas1.add(l1);
//        mas2.add(l2);
//        mas3.add(l);
//        
//        mas1.add(mas2);
//        
//        mas3.add(mas1);
//        
//        mas2.add(17);
        
        //mas1.add(mas3);// rekursiniai kreipiniai, nes į listą sedama nuoroda į listą
        
//        List<String> list = Arrays.asList("a","b","c");
//        List<String> newList = new Array<String>[4];
//        System.out.println(list);
//        newList.add("e");
        
//        System.out.println(mas1);
//        System.out.println(mas3);
        
        
        
        //l1.add(2);
        
        
//        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> inner = new ArrayList<Integer>();
//        inner.add(100);     
//        inner.add(200);
//        
//        outer.add(inner);
//        outer.add(inner);
//        
//        outer.get(0).add(300);
//        
//        System.out.println(outer);
        
        
//        System.out.println("");
//        System.out.println(l1);
//        System.out.println("");
//        System.out.println(l2);
//        System.out.println("");
//        System.out.println(l);
//        System.out.println("");
          
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
    
//    public static int listuSuma(List l){
//        int ilg = l.size();
//        int sum = 0;
//        for(int i = 0; i < ilg; i++){
//           if(l.get(i) instanceof List){
//               sum = sum + listuSuma((List)l.get(i));
//           }
//           else {
//               sum = sum + (int)l.get(i);
//           }
//        }
//        return sum;
//    }
    
    
    public static int listuSuma(List pl){
        return listuSuma(pl, new ArrayList());
    }
    
    private static int listuSuma(List pl, List path){
        if(path.contains(pl)){
            System.out.println("circle reference returning 0 čia jau buvau");
            return 0;
        }
        path.add(pl);
        int suma = 0;
        
        for (Object el: pl){
            if(el instanceof List ){
                suma += listuSuma((List)el, path);
            }
            else{
                suma += (Integer)el;
            }
            
        }
        path.remove(pl);
        return suma;
               
    }
}
