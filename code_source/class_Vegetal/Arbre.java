package fr.lynchmaniac.class_Vegetal;

import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Carte.Position;

public class Arbre extends Vegetal{
    private int nbbois;

    public Arbre (String n, Biome b, Position p){
        super(n,b,p);
        this.nbbois = 0;
    }

    //creation getters
    public int getnbbois (){
        return this.nbbois;
    }
    //creation setters 
    public void setnbbois (int arbre){
        this.nbbois = arbre;
    }


}
