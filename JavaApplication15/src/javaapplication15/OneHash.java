/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.util.Objects;

/**
 *
 * @author Jurate Valatkevicien
 */
public class OneHash {
    private String s;
    public OneHash(String s){
        this.s = s;
    }

    @Override
    public String toString() {
        return "OneHash{" + "s=" + s + '}';
    }

    @Override
    public int hashCode(){
        return 1;
    }
}
