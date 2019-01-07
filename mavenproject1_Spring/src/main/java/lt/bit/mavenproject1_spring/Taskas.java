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
public class Taskas {
    private int x;
    private int y;

    public Taskas() {
        this (0, 0);
    }

    public Taskas(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Taskas{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
