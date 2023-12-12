package class_Carte;


import class_Biome.Biome;

public class Case {

   private Biome biome;
   private Position position;
   private boolean isvegetal = false;
   private boolean isanimal = false;
   private boolean isrocher = false;
   private boolean ischampi = false;
    
    public Case() {
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

    public void setisvegetal(boolean b){
        this.isvegetal = b;
    }

    public boolean getisvegetal(){
        return this.isvegetal;
    }
    
    public void setisanimal(boolean b){
        this.isanimal = b;
    }

    public boolean getisanimal(){
        return this.isanimal;
    }

    public boolean getisrocher(){
        return this.isrocher;
    }

    public void setisrocher(Boolean r){
        this.isrocher = r;
    }

    public void setischampi(boolean ch){
        this.ischampi = ch;
    }

    public boolean setischampi(){
        return this.ischampi;
    }

    

    
}
