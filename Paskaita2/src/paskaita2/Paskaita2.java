/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita2;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Paskaita2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double A, B, C;
        A = 2.3;
        B = 1.9; 
        C = -13;
        double d = B*B - 4*A*C;
        if(d>0){
            System.out.println((-B-Math.sqrt(d))/(2*A)); 
            System.out.println((-B+Math.sqrt(d))/(2*A));
        }
        else if (d == 0){
            System.out.println((-B)/(2*A)); 
        }
        else System.out.println("Šaknų nėra");
    }
    
}
