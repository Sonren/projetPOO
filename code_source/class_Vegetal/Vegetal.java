package fr.lynchmaniac.class_Vegetal;
import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Carte.Position;

public class Vegetal {

    private String name;
    private Biome biome;
    private Position position;
    private boolean isDeadveg = false;
    private int nbbois = 2;

    //constructeur
    public  Vegetal (String n, Biome b, Position p){
            this.name = n;
            this.biome = b;
            this.position = p;
    }

    //les getter
    public String getname(){
        return this.name;
    }
    
    public Biome getbiome(){
        return this.biome;
    }

    public Position getposition(){
        return this.position;
    }

    public boolean isDeadveg(){
        return this.isDeadveg;
    }

    public int getnbbois(){
        return this.nbbois;
    }

    // les setters
    public void setname (String nom){
        this.name = nom;
    }

    public void setbiome (Biome bio){
        this.biome = bio;
    }

    public void setposition (Position emplacement){
        this.position = emplacement;
    }

    public void setisDeadveg(boolean deadv){
        this.isDeadveg = deadv;
    }

    public void setnbbois(int nb){
        this.nbbois = nb;
    }


}

