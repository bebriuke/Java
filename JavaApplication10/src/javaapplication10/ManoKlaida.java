/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

/**
 *
 * @author Jurate Valatkevicien
 */
public class ManoKlaida extends Exception{
    
    public ManoKlaida(String s){
        super(s);  // konstruktorių nepaveldime, reikia siųsti su super
        
    }
    
    public ManoKlaida(int n){    
        super("Klaidos kodas: " + n);
    }
     public ManoKlaida(){        
    }
}
