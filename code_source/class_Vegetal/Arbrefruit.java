package fr.lynchmaniac.class_Vegetal;

import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Carte.Position;

public class Arbrefruit extends Arbre {
    private int nbfruit;

    public Arbrefruit (String n,Biome b, Position p){
        super (n,b,p);
        this.nbfruit = 10;
    }

    //getters 
    public int getnbfruit(){
        return this.nbfruit;
    }

    //setters 
    public void setnbfruit(int fr){
        this.nbfruit = fr;
    }

    
}
