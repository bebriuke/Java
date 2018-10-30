/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author Jurate Valatkevicien
 * klasės viduje saugitų char 
 */
public class MyString {
    private char[] c;
    
    //šitas daiktas turi konstruktorių 
    public MyString(String s){
        //sukurti masyvą, tokio ilgio kaip stringas ir į tą masyvą sudėti visu string elementus
//        int ilg = s.length();
//        c = new char[ilg];
//        for(int i = 0; i<ilg; i++){
//            c[i] = s.charAt(i);
//        }
        c = s.toCharArray();
    }
    
    //turi būti metodas add
    public void add(String s){
        //prie mavyvo this prideda s elementus (sukurti naują ilgesnį masyvą
        int ilg = s.length() + c.length;
        char [] naujas = new char[ilg];
        
        System.arraycopy(c, 0, naujas, 0, c.length);
        
//        for(int i = c.length; i<ilg; i++){
//            naujas[i] = s.charAt(i-c.length);
//        }
        System.arraycopy(s.toCharArray(), 0, naujas, c.length, s.toCharArray().length);
        
        c = naujas;
    }

    @Override
    public String toString() {
//        String naujas = "";
//        for(int i = 0; i < c.length; i++){
//            naujas += c[i];
//        }
//        return "MyString{" + "c=" + naujas + '}';
        return String.valueOf(c);
    }
    
    public void remove(int from, int count){  //nuo kiek simbolių remoovinti
        int ilg = c.length - count;
        char[] naujas = new char[ilg];
        System.arraycopy(c, 0, naujas, 0, from);
        System.arraycopy(c, from+count, naujas, from, c.length-count-from);
        c=naujas;
    }
    
    
}
