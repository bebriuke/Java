/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita6;

/**
 *
 * @author Jurate Valatkevicien
 * 
 * 
 * Sukurti objektą mažšina, kuri gazuotš, stabdytš, greitį, pavadinimą/markę
 * mašina turi žinoti, kiek yra nuvažiavusi, turėti metodą važiuoti
 * mainas turi sukurti  mašinas -- masyvą;
 * visos mašinos turi pradėti su  greičiu ir nuvažiuotas atstumas;
 * maine reikia prasukti ciklą su kiekviena mašina:
 * randomas: jeigu <  0,2 ->stabdom, jeigu > 0,8 mašina greitėja;
 * mašina gali gazuoti -- lėtėti, jeigu stabdo, per kiek pasikeičia greitis; jeigu gazuoja, greitėja;
 * greitis keičiasi nuo 1 iki 10 (du random: ar gazuos, kiek padidės greitis)
 * ciklas pasibaigia , kaip pirma mašina pasiekia 500 kelio.
 * pasakyti kuri mašina laimėjo
 * ----
 * klase trasa, kuri turi viską valdyti
 * maine sukuriu trasą, pasakau kiek važiuoja, run/                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000!/
 * 
 * 
 */
public class Paskaita6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int finis = 500;
        int n = 5;
        trasa obj = new trasa("Bolidas", n, finis);
        obj.startas();
        
    }
}
