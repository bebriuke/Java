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
public class Puodukas {
    int turis;
    int kiekis;
    String spalva;
    
    public Puodukas(String sp, int t){  //konstruktorius sutampa su klasės pavadinimu ir
        spalva =sp;
        turis = t;
        kiekis = 0;
    }
    
    public void ipilk(int kiek){
        if (kiek > 0) {
            kiekis += kiek;
            if (kiekis > turis) kiekis = turis;
        }  
    }
    
    public void isgerk(int kiek){
        if (kiekis == 0) System.out.println("Negerk iš tuščio");
        if (kiek > 0) {
            kiekis -= kiek;
            if (kiekis < 0) kiekis = 0;
        }  
    }
}

//nkapsuliacija incapsulation
