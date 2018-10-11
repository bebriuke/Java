/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita5;

/**
 *
 * @author Jurate Valatkevicien
 * 
 */
public class Paskaita5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Puodukas pvz =new Puodukas("rudas", 100);
        Puodukas naujas = new Puodukas("geltonas", 150);
        pvz.setSpalva("rudas");
        //pvz.setTuris(200);
        //pvz.kiekis = 25;
        System.out.println("pvz puodelis");
        System.out.println("kiekis: "+pvz.getKiekis());
        System.out.println("spalva: "+pvz.getSpalva());
        System.out.println("tūris: "+pvz.getTuris());
        System.out.println("");
        
        System.out.println("naujas puodelis");
        System.out.println("kiekis: "+naujas.getKiekis());
        System.out.println("spalva: "+naujas.getSpalva());
        System.out.println("tūris: "+naujas.getTuris());
        System.out.println("");    
                
        naujas = pvz;
        System.out.println("naujas puodelis dar kartą po naujas = pvz");
        System.out.println("kiekis: "+naujas.getKiekis());
        System.out.println("spalva: "+naujas.getSpalva());
        System.out.println("tūris: "+naujas.getTuris());
        
        // Vot faina!
        System.out.println("");
        System.out.println("po darVienas = pvz ir darVienas. kiekis = 2 spausdinamas naujas");
        Puodukas darVienas = pvz;
        //darVienas.kiekis = 2;
        System.out.println("kiekis: "+naujas.getKiekis());
//        pvz = null;
//        System.out.println(pvz.spalva); // klaida

        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        Puodukas p = new Puodukas("Žalias", 500);
        p.ipilk(100);
        System.out.println("puoduke esantis kiekis įpylus 100: "+ p.getKiekis());
        p.ipilk(450);
        System.out.println("puoduke esantis kiekis papildžius 450: "+ p.getKiekis());
        
        while(p.getKiekis() > 0){
            p.isgerk(150);
            System.out.println("puoduke esantis kiekis kai išgėriau 150: "+ p.getKiekis());
        }
        
        
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        GudrusPuodukas gp =new GudrusPuodukas("chaki", 300, 45);
        System.out.println("Gudraus puoduko spalava: "+ gp.getSpalva());
        System.out.println("Gudraus puoduko turis: "+ gp.getTuris());
        System.out.println("Gudraus puoduko kiekis: "+ gp.getKiekis());
        System.out.println("Gudraus puoduko temperatura: "+ gp.getTemperatura());
        gp.ipilk(100);
        System.out.println("G puoduke esantis kiekis įpylus 100: "+ gp.getKiekis());
        gp.ipilk(450);
        System.out.println("G puoduke esantis kiekis papildžius 450: "+ gp.getKiekis());
        
        System.out.println("------------------------------");
        System.out.println(p);
        System.out.println(gp.toString());
        System.out.println("------------------------------");
        
        while(gp.getKiekis() > 0){
            gp.isgerk(75);
            System.out.println("puoduke esantis kiekis kai išgėriau 150: "+ gp.getKiekis());
        }
        
        
    }
    
}
