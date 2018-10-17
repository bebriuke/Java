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
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)/* throws Exception */{  //jeigu mes klaidų nemėtom
//        Exception e = new Exception("Nusikeikiau");
//        throw e;
        
        //System.out.println(dalyba(4, 2));
        //System.out.println(dalyba(4, 0));
        
        try{
            int a = klaida();
            System.out.println(a);
        } catch (Exception ex){
            System.out.println("Įvyko klaida"+ex.getMessage());
        }finally {
            System.out.println("vis tiek padariau :P");
        }
        System.out.println("Programos pabaiga");
    }
    
    public static int klaida() /*throws Exception*/{
        if(Math.random() > 0.25){
            throw new RuntimeException("*******Klaida*********");
            //throw new Exception("Klaida");
        }
        return 15;
    }
    
    
    public static int dalyba(int a, int b){
        return a/b;
    }
    
}
