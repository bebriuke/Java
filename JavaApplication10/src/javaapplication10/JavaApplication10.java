/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication10;

import org.omg.IOP.ExceptionDetailMessage;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{  //jeigu mes klaidų nemėtom
//        Exception e = new Exception("Nusikeikiau");
//        throw e;
        
        //System.out.println(dalyba(4, 2));
        //System.out.println(dalyba(4, 0));
        
//        try{
//            int a = klaida();
//            System.out.println(a);
//        } catch (Exception ex){
//            System.out.println("Įvyko klaida"+ex.getMessage());
//        }finally {
//            System.out.println("vis tiek padariau :P");
//        }
//        System.out.println("Programos pabaiga");
    
        int k = 1;
        
        try{
            if (k == 1){
                throw new ManoKlaida(5);
            }
            int a = 1/0;
            System.out.println("labs");
            throw new Exception("kita klaida");
        } catch (ManoKlaida mex){
            mex.printStackTrace();
            System.out.println("Mano klaida");
            throw new Exception("Klaida viduje");  //kad nebūtų klaida naudok try try viduje, kaip ifą, ife :)
            
        } catch (Throwable ex){  //visi exceptionai yra thowable atstovai, throwable yra dar ir errorai, tačiau juos gaudyti nerekomenduojama, nes jie vyksta pačioj mašinoj :D
            System.out.println(ex.getClass().getName());
            System.out.println("Visas likusias klaidas: "+ex.getMessage());
        }finally{
            System.out.println("vis tiek vykdau");
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
