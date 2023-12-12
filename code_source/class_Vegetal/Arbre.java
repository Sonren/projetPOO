package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

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
