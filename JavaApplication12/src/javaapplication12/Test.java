/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author Jurate Valatkevicien
 */
public class Test {
    private int score;
    public Test (int score){
	this.score =score;
    }

    public String toString(){
	return "Test score: "+score;
    }

    public boolean equals(Object o){
	//return this == o;  // būtent tai grąžina objekto equals;
	if (o == null) return false;
	if(!getClass().equals(o.getClass())) return false;  //techniškai galime ir taip: this.getClass() != o.getClass() pradinukų lygmenyje :)
        else if (score != ((Test) o).score) return false;  // aš rašiau this, praktiškai nereikia
        return true;
}

}
