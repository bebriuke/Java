/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18_mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication18_mysqlJdbc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");//zipe kelias, prieš tai įkėlus į biblioteką (Projects -> Libraries dešiniu pelės, Add Library -> mysql-....jar
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/persons_scheme", "root", "root"); // jungimasis prie DB
        Statement st = con.createStatement();
        String vardas = "Antanas";
//        ResultSet rs = st.executeQuery("select * from persons");
//        
//        while (rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getDate(4));
//            System.out.println(rs.getBigDecimal(5));
//        }
//        rs.close();


        //st.execute("insert into persons(first_name, last_name) values('Jonas', 'Jonaitis')");
        //st = con.createStatement(); 
        //st.execute("delete from persons where id = 5");
// Išrenka eilutes su konkrečiu vardu; ATSARGIAI! Įsilaužimas/duombazės praradimas su teisinga užklausa: String vardas = "Jonas';dropdatabase;select'"
//        ResultSet rs = st.executeQuery("select * from persons where first_name = '"+vardas+"'");
//        while (rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getDate(4));
//            System.out.println(rs.getBigDecimal(5));
//        }
        

//Šitas nebijo dropdatabase;
//        PreparedStatement pst = con.prepareStatement("select * from persons where first_name = ?");  //kiekvienam klaustukui reikia suformuoti reikšmes;//parametrizuota užklausa
//        pst.setString(1, vardas); //kievienam klaustukui siunčiamas parametras. kelintas klaustukas :)
//        ResultSet rs = pst.executeQuery();
//        while (rs.next()){
//            System.out.println(rs.getInt(1));
//            System.out.println(rs.getString(2));
//            System.out.println(rs.getString(3));
//            System.out.println(rs.getDate(4));
//            System.out.println(rs.getBigDecimal(5));
//        }
        


        System.out.println("Pasirinkite veiksmą:");
        System.out.println("1 -- jeigu norite pamatyti visą lentelę;");
        System.out.println("2 -- jeigu norite išsirinkti įrašus pagal vardą arba pavardę");
        System.out.println("3 -- jeigu norite įrašyti naują darbuotoją į lentelę");
        System.out.println("4 -- jeigu norite pakeisti darbuotojo atlyginimą");
        System.out.println("5 -- jeigu norite pašalinti eilutę");
        
        int x = 1;
        
        
        switch (x) {
            case 1:  System.out.println("1");;
                     break;
            case 2:  System.out.println("2");
                     break;
            case 3:  System.out.println("3");
                     break;
            case 4:  System.out.println("4");
                     break;
            case 5:  System.out.println("5");
                     break;
        }
        
        
        st.close();
        con.close();
    }
    //jeigu 1: parodyti sąrašą visų personų;
    //jeigu 2: paprašyti vardo ir pavardės ir išvardinti tas eilutes, kur yra vardas arba pavardė;
    //jeigu 3: paprašo vardo, pavardės, datos ir salarį ir įrašo tuos duomenis į duombazę;
    //jeigu 4: paklausia ID, ir koks bus naujas to žmogaus atlyginimas ir updatina;
    //jiegu 5: pakalusia ID ir ištrina tą eilutę;
}
