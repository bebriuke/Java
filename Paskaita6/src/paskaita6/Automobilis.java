package paskaita6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jurate Valatkevicien
 */
public class Automobilis {
    private String vardas;
    private int greitis;
    private int kelias;
    
    public Automobilis(String pav){
        vardas = pav;
        greitis = 0;
        kelias = 0;
    }
    
    
    public void greitek(int sk){
        if((greitis + sk) > 200) greitis = 200;
        else greitis += sk;  
    }
    
    
    public void letek(int sk){
        if (greitis < sk) greitis = 0;
        else greitis -= sk;
    }

    public void vaziuok(){
        kelias += greitis;   
    }
    
    public String getVardas() {
        return vardas;
    }

    public int getGreitis() {
        return greitis;
    }

    public int getKelias() {
        return kelias;
    }

    @Override
    public String toString() {
        return "Automobilis{" + "vardas=" + vardas + ", greitis=" + greitis + ", kelias=" + kelias + '}';
    }

   
    
    
    
}
