/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita5;

/**
 *
 * @author Jurate Valatkevicien
 */
public class GudrusPuodukas extends Puodukas{
    private int temperatura;
    
    public GudrusPuodukas(String sp, int t, int temp){
        super(sp, t);  //paleidžia puoduko konstruktorių :D
        temperatura = temp;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    
    public String toString(){
        return getSpalva()+" puodukas "+getTuris() + " tūrio. Įpilta " + getKiekis() + " l. " + getTemperatura() + " laipsnių temperatūros skysčio.";
    }
}
