/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.mavenproject1_spring;

/**
 *
 * @author Jurate Valatkevicien
 */



public class Apskritimas implements Figura{
    private Taskas centras;
    private float skersmuo;

    public Apskritimas() {
        this.centras=new Taskas();
    }

    
    public Apskritimas(Taskas centras, float skersmuo) {
        this.centras = centras;
        this.skersmuo = skersmuo;
    }

    public Taskas getCentras() {
        return centras;
    }

    public void setCentras(Taskas centras) {
        this.centras = centras;
    }

    public float getSkersmuo() {
        return skersmuo;
    }

    public void setSkersmuo(float skersmuo) {
        this.skersmuo = skersmuo;
    }

    @Override
    public String toString() {
        return "Apskritimas{" + "centras=" + centras + ", skersmuo=" + skersmuo + '}';
    }

    @Override
    public Taskas getVieta() {
        return centras;
    }

    @Override
    public void judamX(int x) {
        centras.setX(centras.getX()+x);
    }

    @Override
    public void judamY(int y) {
        centras.setY(centras.getY()+y);
    }// Alt+shift+f -- išlygiuoja
    
    
    
    
}
