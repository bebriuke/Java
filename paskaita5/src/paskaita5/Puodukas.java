/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita5;

/**
 *
 * @author Jurate Valatkevicien
 * 
 * modifaeriai yra 4, tame tarpe ir kai jo nėra 
 * 1. packed protected nėra modifaerio
 * 2. public matomas visiems
 * 3. protected matomas sau ir paveldėjusiom klasėms
 * 4. private matomas tiktai toje klasėje
 * 
 * 
 * paveldėjimas inheriting
 */
public class Puodukas {
    private int turis;
    private int kiekis;
    private String spalva;
    
    public Puodukas(String sp, int t){  //konstruktorius sutampa su klasės pavadinimu ir
        spalva =sp;
        turis = t;
        kiekis = 0;
    }
    
    //metodas tas pats, kas funkcija;
    public int getTuris (){ 
        return turis;
    }
    //Alt Insret geteriai ir seteriai :D

    public int getKiekis() {
        return kiekis;
    }

    public String getSpalva() {
        return spalva;
    }
  //setTuris neturi prasmės, nes po pagaminimo puoduko turis nesikeicia ;)

    public void setSpalva(String spalva) {
        this.spalva = spalva;
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

    @Override
    public String toString() {
        return "Puodukas{" + "turis=" + turis + ", kiekis=" + kiekis + ", spalva=" + spalva + '}';
    }
    
    
    
}

//nkapsuliacija incapsulation
