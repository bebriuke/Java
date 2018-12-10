/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18_mysql.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
        ResultSet rs = st.executeQuery("select * from persons");
        
        while (rs.next()){
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getDate(4));
            System.out.println(rs.getBigDecimal(5));
        }
        rs.close();
        st.close();
        con.close();
    }
    
}
