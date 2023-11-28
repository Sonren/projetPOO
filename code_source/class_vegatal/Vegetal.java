import class_Animal.*;

public class Vegetal {

    private String name;
    private Biome biome;
    private Position position;
    private int levellife;

    //constructeur
    public  Vegetal (String n, Biome b, Position p){
            this.name = n;
            this.biome = b,
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

    public Position get position(){
        return this.position;
    }

    public int getlife(){
        return this.levellife;
    }

    // les setters
    public String setname (String nom){
        this.name = nom;
    }

    public Biome setbiome (biome bio){
        this.biome = bio;
    }

    public Position setposition (Position emplacement){
        this.position = emplacement;
    }

    public int setlife (int vie){
        this.levellife = vie;
    }


    //fonction de la classe animal 
    public boolean isDeadveg (){
        boolean dead = true;
        return (this.levellife == 0);
    }


}