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
                System.out.println(String.format("%.5g",arr[i]) + "    " + String.format("%.5g",arr[i+1]));  //tyrinėjam apvalinimą;
                System.out.println(df.format(arr[i]) + "    " + df.format(arr[i+1])); //tyrinėjam apvalinimą;
                System.out.println(Math.round(arr[i]) + "    " + Math.round(arr[i+1]));  //tyrinėjam apvalinimą;
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
        
        
        int eil = 10;
        int stulp = 10;
        int iteracijuSk = 20;
        
        //generuoja pirminę lentelę
        char[][]GYV = new char[eil][stulp];
        for (int i = 0; i <GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
//                if(Math.random()>0.5){
//                    GYV[i][j] = '0';
//                }
//                else GYV[i][j] = 'x';
                  GYV[i][j] =(Math.random()>0.5)?'0':'x';   //liambda išraiška
            }
        }
        
        
        char [][][] archyvas = new char [iteracijuSk][eil][stulp];
        
        
        //prasideda 10 iteracijų ciklas
        for(int i = 0; i < iteracijuSk; i++){
            archyvas[i] = GYV;
            System.out.println(i+1 + "  -------------------------------------");
            spausdink_GYV(GYV);
            char [][] GYVNew = gyvenimas(GYV, eil, stulp);
            if(Compare(GYV, GYVNew)){  //jeigu prieš tai buvusi lentelė tokia pati -- prasideda kartojimasis
                System.out.println(i+2 + " -- Prieš tai buvęs pasaulis buvo toks pats!");
                break;
            }
            else  if(Ar_yra_archyve(archyvas, GYVNew)){
                System.out.println(i+2 + " -- Užsiciklino!");
                break;
            }
            else {
                    GYV = GYVNew;
                 }
            
           
            
        }
        
       
     //netikrinau, ar nesikartoja kas kelias lenteles cikliškai;   
        
        
        
        
    }
    
    //f-ja spausdina lentelę
    public static void spausdink_GYV(char [][] GYV){
        for (int i = 0; i <GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                System.out.print(GYV[i][j]+" ");
            }
            System.out.println("");
            
        } 
    }
    
    //fja lygina ar dvi lentelės yra vienodos;
    public static boolean Compare(char[][] GYV, char[][] GYVNew){
        for (int i = 0; i < GYV.length; i++){
            for(int j=0; j < GYV[i].length; j++){
                if(GYV[i][j] != GYVNew[i][j]){
                    return false;
                }
            }
        } 
        return true;
    }
    
    //vienas gyvenimo ciklas :D
    public static char [][] gyvenimas(char [][] GYV, int eil, int stulp){
        int kiekis;
        char[][]GYVNew = new char[eil][stulp];
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
    
    public static boolean Ar_yra_archyve(char [][][] archyvas, char[][]GYV){
        int n = archyvas.length;
        for (int i = 0; i < n; i++){
            if (Compare(archyvas[i], GYV))
                return true;
        }
        return false;
    }
    
}
