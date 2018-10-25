/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.lang.reflect.Method;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = 10;
        Saugykla s = new Saugykla();
        for(int i = 0; i < 3; i++){
            int j = 3;
            System.out.println(skaiciuoti(i, s)+j+k++);
        }
        System.out.println(s.r1 + " " + s.r2);
        
        //2018-10-23
        
        Apskritimas aps = new Apskritimas (10, 10, 25); //(1)
        System.out.println(aps.toString());
        
        Apskritimas aps2 = new Apskritimas (15, 7, 3);//(2)
        System.out.println(aps2.toString());
        
        System.out.println(aps2.toString().toUpperCase().length());
        
        Apskritimas aps3 = aps.dvigubas(); //(3)
        System.out.println(aps3.toString());
        /////////2018-10-26
        System.out.println("*********************************");
        
        Apskritimas a = new Apskritimas(1, 2, 3); //(4)
        System.out.println(a.getR());
        System.out.println(a.toString());
        Class c = a.getClass();
        Method[] m = c.getMethods();
        System.out.println(c.toString());
        System.out.println("");
        
        System.out.println(c.getName());
        System.out.println("");
        
        for(Method d : m){
            System.out.println(d.getName());
        }
        
        System.out.println("*********************************");
        System.out.println("");
        System.out.println(a.plotas(3));
        System.out.println(a.plotas(a));  //nepatinka :( bet logika 64-65 eil.! :)
        System.out.println(a.plotas()); //patinka :))))
        System.out.println("");
        System.out.println(Apskritimas.plotas(a));
        System.out.println(Apskritimas.plotas(3));
        
        System.out.println("");
        System.out.println(Apskritimas.getKiekis());
        
        a = new Apskritimas(3, 4, 5);
        a = new Apskritimas(6, 7, 8);
        new Apskritimas (9, 10, 11);
        System.out.println(Apskritimas.getKiekis());  //statiniui objektui nereikia konteksto
        System.out.println(aps3.getKiekis()); // jis pasako bendrą sukurtų objektų kiekį, todėl kreiptis su konkrečiu objektu nėra prasmės
                
        System.gc(); // iškviečiamas garbidž kolektorius;
        
        /* final klasė -- negalima sukurti klasės, paveldėtos nuo final
        galima turėti kintamuosius final
        final int a = 5;
        a++; negalima
        final veikia kaip konstanta, Java neturi konstantos rakto
        
        pasižiūrėti inner ir anonimines klases (arba vėliau :D
        */
        System.out.println("--------------");
        System.out.println("");
        String bla = "\uD83D\uDD74";
        System.out.println(bla);
        
        System.out.println("");
        Test t1 = new Test (10);
        System.out.println(t1);
        Test t2 = new Test (10);
        System.out.println(t2);
        
        System.out.println("");
        if (t1 == t2) System.out.println ("lygu");
        else System.out.println("nelygu"); 
        System.out.println("************");
        
        if (t1.equals(t2)) System.out.println ("lygu");
        else System.out.println("nelygu");
        
        
        Object o = "Labas";
        if (t1.equals(o)) System.out.println ("lygu");
        else System.out.println("nelygu");

        
                
    }
    
    public static int skaiciuoti(int i){
        int rez = 0;
        while(i > 0){
            int j = 2;
            rez += j*i--;
        }
        return rez;
    }
    
    public static int skaiciuoti(int i, Saugykla s){
        s.r2 = s.r2+ ++s.r1;
        s = new Saugykla();
        return i*s.r1;
    }
    
}
