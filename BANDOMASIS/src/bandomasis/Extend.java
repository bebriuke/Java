/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandomasis;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Extend {
    
    int x;
    
    public void a() {
	   System.out.print("a ");
   }
   
   public void b() {
	   System.out.print("b ");
           a();
   }

}
