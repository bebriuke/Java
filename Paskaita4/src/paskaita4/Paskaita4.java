/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita4;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Paskaita4 {

    /*
    Turim masyvą. Pvz. [4, 7, 3, 6, 9]
    reikia sudaryti dvimatį masyvą, kuris būtų su tokiomis reikšmėmis:
    {{4, 7, 3, 6, 9}, {9, 4, 7, 3, 6}, {6, 9, 4, 7, 3} ir t.t.}
    **** info ****
    int [] a = new a[4] => tuščias 4 elementų masyvas
    int [] b = {1, 2, 3, 4}
    int[][]c = {1, 2, 3, 4}, {5, 6, 8, 4}, {4, 2}}
    
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [] mas = {4, 7, 3, 6, 9, 8, 2, 0, 3};
        int ilgis = mas.length;
        int [][] rez = new int [ilgis][ilgis];
        
        for(int i = 0; i < ilgis; i++){
            for(int k = 0; k < ilgis; k++){
                rez[i][k] = mas[k];
            }
                        
            int tmp = mas[0];
            //int [] laik = new int [ilgis];
            for(int j = 0; j < ilgis-1; j++){  //(i+j)%ilgis
                
                mas[j] = mas[j+1];
            }
            mas[ilgis - 1] = tmp; 
        }
        

        System.out.println("**************");
        for (int i = 0; i < ilgis; i++){
            for(int j = 0; j < ilgis; j++){
                System.out.print(rez[i][j]+" ");
            }
            System.out.println("");
        }
        
       
        
        
        
        
        for(int i = 0; i < ilgis; i++){
            for(int j = 0; j < ilgis; j++){
                rez[i][(j+i)%ilgis] = mas[j];
            }
        }
        
       
        
        System.out.println("**************");
        for (int i = 0; i < ilgis; i++){
            for(int j = 0; j < ilgis; j++){
                System.out.print(rez[i][j]+" ");
            }
            System.out.println("");
        }
        
        double []M = new double [2];
        
        M = kvadratineLygtis(1, 10, 25);  //25 - 4*2*4
        
        if (M != null){
            if(M[0] != M[1]){
                System.out.println("x1 = " + M[0]);
                System.out.println("x2 = " + M[1]);
            }
            else {
                System.out.println("x1 = " + M[0]);
                
            }
        }
        else System.out.println("Šaknų neturi");
        
        
    }
    
    public static double[] kvadratineLygtis(double a, double b, double c){
        double[]mas = new double [2];
        
        double d = b*b - 4*a*c;
        //System.out.println(d);
        if (d < 0)  mas = null;
        else {
            mas[0] = (-b + Math.sqrt(d))/(2*a);
            mas[1] = (-b - Math.sqrt(d))/(2*a);       
        }
        //System.out.println(mas[0] + " " + mas[1]+"**************");
        return mas;
    }
    
}
