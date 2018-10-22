/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

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
