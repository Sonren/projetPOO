package fr.lynchmaniac.class_Vegetal;
import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Carte.Position;

public class Vegetal {

    private String name;
    private Biome biome;
    private Position position;
    private int levellife;

    //constructeur
    public  Vegetal (String n, Biome b, Position p){
            this.name = n;
            this.biome = b;
            this.position = p;
            this.levellife = 30;
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

    public int getlife(){
        return this.levellife;
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

    public void setlife (int vie){
        this.levellife = vie;
    }


    //fonction de la classe animal 
    public boolean isDeadveg (){
        return (this.levellife == 0);
    }


}


