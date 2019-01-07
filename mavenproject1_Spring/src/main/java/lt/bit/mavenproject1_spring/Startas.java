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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Figura f1 = (Figura) ctx.getBean("staciakampiukas");
        System.out.println(f1);
    }
}
