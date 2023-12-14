package fr.lynchmaniac.class_Vegetal;

import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Carte.Position;

public class Arbre extends Vegetal{
    private int hauteur = 0;

    public Arbre (String n, Biome b, Position p){
        super(n,b,p);
    }

    //creation getters
    public int gethauteur (){
        return this.hauteur;
    }
    //creation setters 
    public void setnbbois (int h){
        this.hauteur = h;
    }


}
