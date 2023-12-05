package class_Carte;


import class_Biome.Biome;

public class Case {

   private Biome biome;
   private Position position;
    


    public Case(Biome biome, Position position) {
        this.biome = biome;
        this.position = position;
    }

    //getters et setters
    public Biome getBiome() {
        return this.biome;
    }

    public void setBiome(Biome biome) {
        this.biome = biome;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    
}
