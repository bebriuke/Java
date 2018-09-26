/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Hello {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 8 byte; 
        // 16 short;
        // 32 int;
        // 64 long;
        // 32 float;
        // 64 doube;
        
        System.out.println("Ąčęėįšųū90-ž");
        int a = 2;
        int b = 3;
        int c = a + b;
        c = c*2;
        System.out.println("c = " + c);
        
        float f1 = 0.1f; //(float) 0.1;  
        float f2 = 1.2f; //(float) 1.2;
        System.out.println(f1+f2);
        
        double x1 = 0.1;
        double x2 = 1.2;
        System.out.println(x1+x2);
        
        float k1 = 0.1f;
        double k2 = 1+ 1/10;
        System.out.println(k1+k2);  //rezultatas ilgesnis, t.y. double
        System.out.println(k2);
       
        
        //0b -- byte;
        //0l -- long;
        // 0 -- int;
        //char  ''
        //boolean   true | false
        
        char simb = '8';
        System.out.println(simb+1);  //'8' ASCII kodą;
                
        
    }
    
}
