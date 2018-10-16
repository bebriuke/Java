/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Balandis extends Paukstis implements Skraiduolis{

    

    @Override
    public void pakilti(int aukstis) {
        System.out.println("pakyla balandis į aukštį " + aukstis); 
    }

    @Override
    public void nutupti() {
        System.out.println("Balandis nutupia"); 
    }
    
}
