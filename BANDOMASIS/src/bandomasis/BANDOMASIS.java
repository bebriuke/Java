/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandomasis;

import com.sun.org.apache.bcel.internal.generic.SWITCH;

/**
 *
 * @author Jurate Valatkevicien
 */
public class BANDOMASIS extends Extend {
	public void a() {
		System.out.print("a1 ");
	}
	public void c() {
                super.b();
	}
	public static void main(String[] args) {
		//BANDOMASIS b=new BANDOMASIS();
		//b.c();
                Extend dd = new Extend();
                System.out.println(dd.x);
	}
        
        
        



    
}
