/*
 * To change this license header choose License Headers in Project Properties.
 * To change this template file choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    
        
        List <Gyvunai> gyv = new ArrayList(Arrays.asList());
        
        Kates kate = new Kates();
        Sunis suo = new Sunis();
        Gyvunai ggg = new Gyvunai();
        
        gyv.add(suo);
        gyv.add(kate);
        gyv.add(ggg);
        
        System.out.println(gyv.toString());
        System.out.println("");
        for(int i = 0; i < gyv.size(); i++){
            System.out.println(gyv.get(i));
        }
        
        System.out.println("/////////////////////////////////");
        
        String tekstas = "labas labas rytas labas mano saule saule saule";
        String [] temp = tekstas.split(" ");
        List <String> zodziai = new ArrayList(Arrays.asList(temp));
        zodziai.add(new String("Didelės"));
        zodziai.add(new String("Didelės"));
        zodziai.add(new String("Didelės"));
        
        System.out.println(zodziai);
        System.out.println(zodziai.size());
        
              
        System.out.println("************************");
        Set pol = new HashSet();
        for(int i = 0; i < zodziai.size(); i++){
            pol.add(zodziai.get(i));
        }
        System.out.println(pol);
        System.out.println(pol.size());
        System.out.println("************************");
        
        
        
       
        
        Map kiekiai = new HashMap();
        for(Object kas: pol) {
            int kiekis = 0;
            for(int j = 0; j < zodziai.size(); j++){
                if(kas.equals(zodziai.get(j))) kiekis++;
            }
            kiekiai.put(kas, kiekis);
            
            System.out.println(kas + " " + kiekis+" "+Collections.frequency(zodziai, kas));   //VALIO!!!!!
        }
        System.out.println(kiekiai);
        
        
        //optimizavimas:
//        Map kkiekiai = new HashMap();
//        for(int i = 0; i < zodziai.size(); i++){
//            //String z = (String)zodziai.get(i);
//            Integer kkiekis = (Integer)kkiekiai.get(zodziai.get(i));
//            if(kkiekis == null) kkiekis = 0;
//            kkiekis++;
//            //System.out.println("z = "+z+"  kkiekis = " + kkiekis);
//            kkiekiai.put(zodziai.get(i), kkiekis);
//        }

//        Map <String, Integer> kkiekiai = new HashMap<>();// tuščias <>, kai sutampa
//        for(int i = 0; i < zodziai.size(); i++){
//            String z = (String)zodziai.get(i);
//            Integer kkiekis = kkiekiai.get(z);
//            if(kkiekis == null) kkiekis = 0;
//            kkiekis++;
//            //System.out.println("z = "+z+"  kkiekis = " + kkiekis);
//            kkiekiai.put(z, kkiekis);
//        }

        Map <String, Integer> kkiekiai = new HashMap<>();// tuščias <>, kai sutampa
        //kkiekiai.
        for(String z: zodziai){    //prirašytie prie zidziai Listo <String>
            Integer kkiekis = kkiekiai.get(z);
            if(kkiekis == null) kkiekis = 0;
            kkiekiai.put(z, ++kkiekis);
        }


        System.out.println("**********************");
        System.out.println(kkiekiai);
        System.out.println(kkiekiai.values());
        
        for(String o: kkiekiai.keySet()){
            System.out.println(o+": "+kkiekiai.get(o));
        }
        System.out.println("oooo----------------------------");
        
        
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println("************************");
        
        
        Set oh = new HashSet();
        oh.add(new OneHash("A"));
        oh.add(new OneHash("B"));
        oh.add(new OneHash("C"));
        System.out.println(oh);
        System.out.println("************************");

           
    }
    
}
