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
        
        
        String[] miestai = {"Vilnius", "Kaunas", "Klaipėda"};
        System.out.println(miestai[2]);

        int[][]MAS = new int[2][3];
        for (int i = 0; i <MAS.length; i++){
            for(int j=0; j < MAS[i].length; j++){
                MAS[i][j] = (int) (Math.random()*10);
                System.out.print(MAS[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        // ND: masyvas 50x50; jį užpildyti arba tarpu arba x (20% randomas < 0,2);
        // Atspausdinam užpildytą;
        // Susikurti tuščią masyvą ir 
        //1. jeigu tuščias ir aplinkį yra 3 x -- naujoje iteracijoje atsiranda x;
        //2. jeigu kvadratukas x ir turi 2 arba 3 kaimynus -- jis lieka gyventi;
        //3. jeigu turi mažiau arba daugiau kaimynų -- miršta, tampa 0
        //4. 10 iteracijų;
        //5. Palyginti ar nėra vienodas su prieš tai buvusiu;
        //6. tikrinti ar nesiciklina
        
        
        
        
        char[][]GYV = new char[6][6];
        for (int i = 0; i <GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                if(Math.random()>0.5){
                    GYV[i][j] = '0';
                }
                else GYV[i][j] = 'x';
            }
        }
        
        
        for(int i = 0; i < 10; i++){
            System.out.println(i + "  -------------------------------------");
            spausdink_GYV(GYV);
            char [][] GYVNew = gyvenimas(GYV);
            if(Compare(GYV, GYVNew)){
                System.out.println("Prieš tai buvęs pasaulis buvo toks pats!");
                i = 12;
                
            }
            else {
                GYV = gyvenimas(GYV);
            }
        }
        
       
        
        
        
        
        
    }
    
    
    public static void spausdink_GYV(char [][] GYV){
        for (int i = 0; i <GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                System.out.print(GYV[i][j]+" ");
            }
            System.out.println("");
            
        } 
    }
    
    public static boolean Compare(char[][] GYV, char[][] GYVNew){
        boolean verte = true;
        for (int i = 0; i < GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                if(GYV[i][j] != GYVNew[i][j]){
                    verte = false;
//                    j = GYV[i].length + 1;
//                    i = GYV.length+1;
                      break;  
                }
            }
        } 
        return verte;
    }
    
    
    public static char [][] gyvenimas(char [][] GYV){
        int kiekis;
        char[][]GYVNew = new char[6][6];
        for (int i = 0; i <GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                kiekis = 0;
                for(int k = i-1; k < i+2; k++){
                    if(k >= 0  && k < GYV.length){
                        for(int m = j-1; m < j+2; m++){
                            if((m >=0) && (m < GYV[i].length) && (GYV[k][m] == 'x')){
                                kiekis++; 
                            }
                        }
                    }
                }
                    
                if (GYV[i][j] == 'x') kiekis--;
                //System.out.print(kiekis+" ");
                if (GYV[i][j] == '0' && kiekis == 3) GYVNew[i][j]= 'x';
                else if(GYV[i][j] == 'x' && (kiekis < 2 || kiekis >3)) GYVNew[i][j]= '0';
                else GYVNew[i][j] = GYV[i][j];
            }
            //System.out.println("");
        }
        return GYVNew;
    }
    
}
