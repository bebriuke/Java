/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita5;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Paskaita5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Puodukas pvz =new Puodukas("rudas", 100);
        Puodukas naujas = new Puodukas("geltonas", 150);
        pvz.spalva ="rudas";
        pvz.turis = 200;
        pvz.kiekis = 25;
        System.out.println("pvz puodelis");
        System.out.println("kiekis: "+pvz.kiekis);
        System.out.println("spalva: "+pvz.spalva);
        System.out.println("tūris: "+pvz.turis);
        System.out.println("");
        
        System.out.println("naujas puodelis");
        System.out.println("kiekis: "+naujas.kiekis);
        System.out.println("spalva: "+naujas.spalva);
        System.out.println("tūris: "+naujas.turis);
        System.out.println("");    
                
        naujas = pvz;
        System.out.println("naujas puodelis dar kartą po naujas = pvz");
        System.out.println("kiekis: "+naujas.kiekis);
        System.out.println("spalva: "+naujas.spalva);
        System.out.println("tūris: "+naujas.turis);
        
        // Vot faina!
        System.out.println("");
        System.out.println("po darVienas = pvz ir darVienas. kiekis = 2 spausdinamas naujas");
        Puodukas darVienas = pvz;
        darVienas.kiekis = 2;
        System.out.println("kiekis: "+naujas.kiekis);
//        pvz = null;
//        System.out.println(pvz.spalva); // klaida

        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        Puodukas p = new Puodukas("Žalias", 500);
        p.ipilk(100);
        System.out.println("puoduke esantis kiekis įpylus 100: "+ p.kiekis);
        p.ipilk(450);
        System.out.println("puoduke esantis kiekis papildžius 450: "+ p.kiekis);
        
        while(p.kiekis > 0){
            p.isgerk(150);
            System.out.println("puoduke esantis kiekis kai išgėriau 100: "+ p.kiekis);
        }
        
    }
    
}
