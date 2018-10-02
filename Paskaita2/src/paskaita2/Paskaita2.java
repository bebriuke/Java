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
    
    
    
        double r;
        
        
        for(int i = 0; i < 20; i++){
            r = Math.random()*100;
            
            if(r > 10){
                System.out.print(i+" ");
                System.out.println("didelis skaičius:  " + r);
            }
        }
        
        
        
    
        int suma = 0;
        int j = 1;
        while (j <= 114){
            suma += j;
            j++;
        }
        System.out.println("Suma nuo 1 iki 114: " + suma);
        
        
//        double k, sum = 0;
//        for(int i = 1; i <= 10; i++){
//            k = Math.random();
//            System.out.println(k);
//            sum += k;
//        }
//        System.out.println("Suma dešimties atsitiktinių skaičių: " + sum);


        double k, sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, sum5 = 0;
        for(int i = 1; i <= 20; i++){
            k = Math.random()*100-50;  //kas 20%
            if(k < -30){
                sum1 += k;
            }
            else if (k<-10){
                sum2 += k;
            }
            else if(k < 10){
                sum3 += k;
            }
            else if(k < 30){
                sum4 += k;
            }
            else sum5 += k;
            System.out.println(k);
        }
        System.out.println("Suma nuo -50 iki -30 " + sum1);
        System.out.println("Suma nuo -30 iki -10 " + sum2);
        System.out.println("Suma nuo -10 iki 10 " + sum3);
        System.out.println("Suma nuo 10 iki 30 " + sum4);
        System.out.println("Suma nuo 30 iki 50 " + sum5);
        
    }
    
    
}
