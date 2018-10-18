/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Taskas O = new Taskas(5, 10);
        System.out.println(O);
        
        O.paslinkti(50);
        System.out.println(O);
        
        O.paslinkti(20, 17);
        System.out.println(O);
        
        
        O.paslinkti(4.0);
        System.out.println(O); // overloadinimas veikia tiek metodams, tiek konstruktoriams :)
    }
    
}
