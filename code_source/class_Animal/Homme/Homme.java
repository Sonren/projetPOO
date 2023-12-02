package class_Animal.Homme;

import class_Animal.Omnivore;
import class_Biome.Biome;
import class_Carte.Position;

public class Homme extends Omnivore {
    public Inventaire invent;

    public Homme(String n, int l, int s,Position p, Biome b,Inventaire invent) {
        super(n,l,s,p,b);
        this.invent = invent;
    }
    
    //getters et setters
    public Inventaire getInvent() {
        return this.invent;
    }

    public void setInvent(Inventaire invent) {
        this.invent = invent;
    }

}