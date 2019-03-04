/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryfinally;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Tryfinally {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int c = 1;
        int a = 1;
        int b = 0;
        try{
            a = a/b;
            System.out.println(c);
        }
        catch (Exception x){
            System.out.println("bbb");
        }
        finally{
            System.out.println(c);
        }
    }
    
}
