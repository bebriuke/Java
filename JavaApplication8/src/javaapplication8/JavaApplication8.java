/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Suo obj = new Suo();
        //obj.rekti();
        
        Kate cat = new Kate();
        //cat.rekti();
        
//        Gyvunas [] zoo = new Gyvunas[2];
//        zoo[0] = obj;
//        zoo[1] = cat;
        
        //arba
        
        SnekantisZvirblis bird = new SnekantisZvirblis();
        Gyvunas [] zoo = {obj, cat, bird, new Zvirblis(), new Eziukas(), new Kiaule(), new Balandis()};
        
        
        
        
//        zoo[0].rekti();
//        zoo[1].rekti();
        
        

        for(Gyvunas g: zoo){   //foreach :)  negarantuoja eiliškumo;
            g.rekti();
            System.out.println(g.getClass().getName());
            if(g instanceof Skraiduolis){
                ((Skraiduolis)g).skristi();
                ((Skraiduolis)g).pakilti(10);
                ((Skraiduolis)g).nutupti();
            }
        }
        
        //zoo[2].skristi();//Polimorfizmas kol gyvūnas neišmoks skraidyti, tol žvirblis neskris;
//        bird.skristi();
//        ((Zvirblis)zoo[2]).skristi();
//        ((Zvirblis)zoo[1]).skristi();//katė nežvirblis: klaida
        
        
    }    
    
}
