package lt.bit.mavenproject1_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jurate Valatkevicien
 */
public class Startas {
    public static void main(String[] mas){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml"); // failo pavadinimas gali būti bet koks; čia aprašom ką mokės gaminti mūsų 
        Figura f1 = (Figura) ctx.getBean("staciakampiukas0");
        System.out.println(f1);
        Figura f2 = (Figura) ctx.getBean("skrituliukas");
        System.out.println(f2);
        f1.judamX(5);
        f1.judamY(7);
        System.out.println(f1);
        Figura f3 = (Figura) ctx.getBean("staciakampiukas1");
        System.out.println(f3);
        System.out.println("****************************************");
        Staciakampis s1 = (Staciakampis) ctx.getBean("staciakampiukas1");
        System.out.println(s1);
        s1.judamX(30);
        System.out.println(s1);
        Staciakampis s2 = (Staciakampis) ctx.getBean("staciakampiukas1");
        System.out.println(s2);
        
        Taskas t1 = (Taskas) ctx.getBean("vienetas");
        System.out.println(t1);
        System.out.println("************************");
        Staciakampis s3 = (Staciakampis) ctx.getBean("staciakampiukas2");
        System.out.println(s3);
    }
}
