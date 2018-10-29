/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Apskritimas {
    private float x;
    private float y;
    private float r;
    private static int kiekis = 0;
   
    public Apskritimas(float x, float y, float rr){
       // public static int move(out aa=0);
       // static{
       //     //čia gali iškviesti objektą ir dar visokias kitokias gudrybes
      //      mainCount = 10;
       // }//static blokų gali būti ne vienas; sudėtingas priskyrimas
        this.x = x;
        this.y = y;
        r = rr;
        kiekis++;
    }
    
    

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Apskritimas{" + "x=" + x + ", y=" + y + ", r=" + r + '}';
    }
    
    public Apskritimas dvigubas(){
        Apskritimas d =new Apskritimas(x, y, r);
        d.setR(getR()*2);
        return d;
    }
    
    
    public static float plotas(float r){
        return 3.1415f*r*r;
    }
    
    public static float plotas(Apskritimas a){  //statiniai metodai neturi "this"
        return plotas(a.getR());
    }
    
    
     public float plotas(){
        return plotas(this);
    }

    public static int getKiekis() {
        return kiekis;
    }
     
    
}
