/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //zmoniu listas su vardais pavardem ir gimimo metais
        List <Zmogus> myList = new ArrayList <Zmogus>(); //ctrl+shift+i
        //10 žmonių su skirtingais vardais pavardė. Keli vardai tie patys, metai ir pavardės skiriasi;
        //atspausdinam;
        //surūšiuojam pagal vardą (be metodo sort), jei vardai vienodi, pagal pavardę, atspausdinti;
        //perrūšiuojam tą patį sąrašą pagal gimimo metus -- atspausdinam
        myList.add(new Zmogus("Jonas", "Jonaitis", 1985));
        myList.add(new Zmogus("Linas", "Adomėnas", 2000));
        myList.add(new Zmogus("Algis", "Minkus", 1999));
        myList.add(new Zmogus("Simonas", "Vaitkus", 1987));
        myList.add(new Zmogus("Simona", "Monkė", 2005));
        myList.add(new Zmogus("Julius", "Liaudanskis", 1988));
        myList.add(new Zmogus("Mindaugas", "Lukošius", 1991));
        myList.add(new Zmogus("Juozas", "Masiliūnas", 1995));
        myList.add(new Zmogus("Jonas", "Astikas", 2001));
        myList.add(new Zmogus("Miglė", "Pajaujienė", 2002));
        myList.add(new Zmogus("Jonas", "Grigas", 2003));
        myList.add(new Zmogus("Mykolas", "Lapas", 1986));
        myList.add(new Zmogus("Jonas", "Puzinas", 1989));

        System.out.println(myList.toString());
        System.out.println(Zmogus.getKiek());
        System.out.println("--------------------");
        
        for(int i = 0; i < Zmogus.getKiek()-1; i++){
            for(int j=i+1; j<Zmogus.getKiek(); j++){
                if(myList.get(i).getVardas().compareTo(myList.get(j).getVardas()) > 0){
                    Zmogus temp = myList.get(i);
                    myList.set(i, myList.get(j)); 
                    myList.set(j, temp);
                }
                else {
                    if((myList.get(i).getVardas().compareTo(myList.get(j).getVardas()) == 0)&&
                       (myList.get(i).getPavarde().compareTo(myList.get(j).getPavarde()) > 0)){        
                            Zmogus temp = myList.get(i);
                            myList.set(i, myList.get(j)); 
                            myList.set(j, temp);
                        }
                    }
                    
            }
        }
        
        
        System.out.println(myList.toString());
               
        
        
        System.out.println("--------------------");
        
         
        for(int i = 0; i < Zmogus.getKiek()-1; i++){
            for(int j=i+1; j<Zmogus.getKiek(); j++){
                if(myList.get(i).getGimimoMetai()> myList.get(j).getGimimoMetai()) {
                    Zmogus temp = myList.get(i);
                    myList.set(i, myList.get(j)); 
                    myList.set(j, temp);
                }
            }
        }
        
        
        System.out.println(myList.toString());

        
        
    }
        
}
    

