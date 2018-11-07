/*
 * To change this license header choose License Headers in Project Properties.
 * To change this template file choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jurate Valatkevicien
 */
public class JavaApplication15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tekstas = "Didelės žalos vaismedžiams Didelės žalos vaismedžiams Didelės "
                + "žalos vaismedžiamsDidelės žalos vaismedžiamsDidelės žalos vaismedžiams"
                + "ypač jauniems pridaro pelės "
                + "Šie graužikai nenuilstamai ieško maisto tad ne išimtis ir "
                + "žiemos periodas Jei zuikių paliktas žaizdas ant kamienų galima "
                + "pastebėti žiemą tai pelių darbo rezultatai matomi tik pavasarį "
                + "Rudenį graužikai būriuojasi ten kur palankios žiemojimo sąlygos "
                + "Pirmiausia juos vilioja namų rūsiai sandėliukai į krūvas sumestos "
                + "piktžolės lapai kitos sodo atliekos ir žinoma komposto dėžė "
                + "Žiemą kai laikinajame būste maistas baigiasi arba negailestingas "
                + "šeimininkas išprašo iš pagalbinių patalpų pelės pasklinda įvairiomis "
                + "kryptimis rausdamos tunelius sniege Storas baltas sluoksnis slepia "
                + "nuo kačių pelėdų ir kitų grobuonių tad jos jaučiasi saugios Peles "
                + "vilioja mėgiamas patiekalas stora sultinga jaunų medelių žievė "
                + "apatinėje kamieno dalyje O jei jos randa nepasodintų tik įkastų "
                + "pavasario laukiančių sodinukų pasijunta kaip tikroje puotoje "
                + "apgraužia liaunus kamienus nuo šaknelių iki viršūnėlių "
                + "Skaniausia šiems gyvūnams yra obelų ir abrikosų žievė";
        String [] temp = tekstas.split(" ");
        List zodziai = new ArrayList(Arrays.asList(temp));
        zodziai.add(new String("Didelės"));
        
        System.out.println(zodziai);
        System.out.println(zodziai.size());
        
        System.out.println("************************");
        Set pol = new HashSet();
        for(int i = 0; i < zodziai.size(); i++){
            pol.add(zodziai.get(i));
        }
        System.out.println(pol);
        System.out.println(pol.size());
        System.out.println("************************");
        
        
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println("************************");
        
        
        Set oh = new HashSet();
        oh.add(new OneHash("A"));
        oh.add(new OneHash("B"));
        oh.add(new OneHash("C"));
        System.out.println(oh);
        System.out.println("************************");

    }
    
}
