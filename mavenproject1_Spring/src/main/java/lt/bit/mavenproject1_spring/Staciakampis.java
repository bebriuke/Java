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
public class Staciakampis implements Figura{
    private Taskas kampas;
    private float aukstis;
    private float plotis;

    public Staciakampis() {
        System.out.println("Kuriam staciakampį");
        this.kampas = new Taskas();
        this.aukstis = 1;
        this.plotis = 1;
    }

    
    
    public Staciakampis(Taskas kampas, float aukstis, float plotis) {
        this.kampas = kampas;
        this.aukstis = aukstis;
        this.plotis = plotis;
    }

    public Taskas getKampas() {
        return kampas;
    }

    public void setKampas(Taskas kampas) {
        this.kampas = kampas;
    }

    public float getAukstis() {
        return aukstis;
    }

    public void setAukstis(float aukstis) {
        this.aukstis = aukstis;
    }

    public float getPlotis() {
        return plotis;
    }

    public void setPlotis(float plotis) {
        this.plotis = plotis;
    }

    @Override
    public String toString() {
        return "Staciakampis{" + "kampas=" + kampas + ", aukstis=" + aukstis + ", plotis=" + plotis + '}';
    }

    @Override
    public Taskas getVieta() {
        return kampas;
    }

    @Override
    public void judamX(int x) {
        kampas.setX(kampas.getX()+x);
    }

    @Override
    public void judamY(int y) {
        kampas.setY(kampas.getY()+y);
    }
    
    
    
}
