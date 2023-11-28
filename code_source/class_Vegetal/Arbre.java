package class_Vegetal;
import class_Biome.Biome;
import class_Carte.Position;
public class Arbre extends Vegetal{
    private int nbarbre = 0;

    public Arbre (String n, Biome b, Position p, int nb){
        super(n,b,p);
        this.nbarbre = nb;
    }

    //creation getters
    public int getnbabre (){
        return this.nbarbre;
    }
    //creation setters 
}
