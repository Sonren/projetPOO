package class_Biome;

public class Mer extends Biome {
    private int profondeur;

    public Mer(String nom){
        super(nom);
        this.profondeur = 0;
    }

    public int getprofondeur(){
        return profondeur;
    }

    public void setprofondeur(){

    }
}
