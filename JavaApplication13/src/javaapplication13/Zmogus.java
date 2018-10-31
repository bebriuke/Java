/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Zmogus {
    private String vardas;
    private String pavarde;
    private int gimimoMetai;
    private static int kiek=0;
    
    public Zmogus(String vardas, String pavarde, int metai){
        this.vardas = vardas;
        this.pavarde = pavarde;
        gimimoMetai = metai;
        kiek++;
    }

    public static int getKiek() {
        return kiek;
    }

    
    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public int getGimimoMetai() {
        return gimimoMetai;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public String toString() {
        return "Zmogus{" + "vardas=" + vardas + ", pavarde=" + pavarde + ", gimimoMetai=" + gimimoMetai +'}'+"\n";
    }
    
    
    
    
    
}
