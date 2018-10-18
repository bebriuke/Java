/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Taskas {
    private int x;
    private int y;
    
    public Taskas(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Taskas{" + "xcor=" + x + ", ycor=" + y + '}';
    }
    
    
    public void paslinkti(int kiek){  //enkapsuliacija -- kintamojo keitimas per metodus;
        x += kiek;
    }
    
    public void paslinkti(double kiek){
        y += kiek;
    }
    
    public void paslinkti(int kiekx, int kieky){  //overload -- metodas tuo pačiu pavadinimu, tik skirtingais parametrais;
        x += kiekx;
        y += kieky;
        
    }
    
}
