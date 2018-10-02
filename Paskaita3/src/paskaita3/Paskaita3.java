/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita3;

import java.text.DecimalFormat;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Paskaita3 {

    public static void main(String[] args) {
        double [] arr = new double [50];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Math.random()*100-50;
        }
        
        DecimalFormat df = new DecimalFormat("#.####");
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i]>0 && arr[i+1]>0){ // & -- ampersand
                System.out.println(String.format("%.5g",arr[i]) + "    " + String.format("%.5g",arr[i+1]));
                System.out.println(df.format(arr[i]) + "    " + df.format(arr[i+1]));
                System.out.println(Math.round(arr[i]) + "    " + Math.round(arr[i+1]));
                System.out.println("");
            }
        }
        
        
    }
    
}
