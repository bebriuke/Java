/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 *
 * @author Jurate Valatkevicien
 */
public class Datos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        Date d = new Date();
//        System.out.println(d);
//        Date d1 = new Date();
//        
//        
//        
//        LocalDate naujad = LocalDate.now();
//        System.out.println(naujad);
//        LocalDate naujad1= LocalDate.now();
//        
//        
//        Calendar cal = Calendar.getInstance(Locale.GERMAN);
//        System.out.println(cal);
//        Calendar cal1 = Calendar.getInstance(Locale.GERMAN);
//        
//        System.out.println(cal.equals(cal1));
//        
//        System.out.println("------------------");
//        System.out.println(d.equals(d1));
//        System.out.println(d.getYear()+ "  XX  " + d1.getYear());
//        System.out.println(d.getMonth() + "  XX  " + d1.getMonth());
//        System.out.println(d.getDate() + "  XX  " + d1.getDate());
//        System.out.println((d.getYear() == d1.getYear())&& (d.getMonth() == d1.getMonth())&&(d.getDate() == d1.getDate()));
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("******");
        String kas = br.readLine();
        
        System.out.println(kas);
    }
    
}

