/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita6;

/**
 *
 * @author Jurate Valatkevicien
 */
public class trasa /*extends Automobilis*/ {
    

    private int autoSk;
    private int finisas;
    private Automobilis [] MAS;// = new Automobilis [autoSk];
    
    public trasa(String name, int sk, int fin){
        //super (name);
        autoSk = sk;
        finisas = fin;
        for(int i = 0; i < sk; i++){
            MAS[i] = new Automobilis(name + i);
        }
        
    } 
    
    
        
    
    public void startas(){
        int laimetojas = -1;
        int tolimiausias = 0;
        do{
            for(int i = 0; i < autoSk; i++){
                System.out.println(MAS[i]);
                double r1 = Math.random();
                
                if (r1 < 0.2) MAS[i].letek((int) (Math.random() * 10 + 1));
                else if (r1 > 0.8) MAS[i].greitek((int) (Math.random() * 10 + 1));
                MAS[i].vaziuok(); 

                if (MAS[i].getKelias() > tolimiausias) {
                    tolimiausias = MAS[i].getKelias();
                    laimetojas = i;   
                }
            }
            System.out.println("***********************  "+ tolimiausias);
        } while (tolimiausias < finisas);
        
        
        for(int i = 0; i < autoSk; i++){
            System.out.println(MAS[i]);
        }
        
        if (laimetojas >= 0) System.out.println("Laimėjo automobilis " + MAS[laimetojas].getVardas());
        else System.out.println("Varžybos neįvyko");
    }
    
}
