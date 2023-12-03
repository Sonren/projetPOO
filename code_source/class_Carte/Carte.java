package class_Carte;

import java.util.ArrayList;

import class_Biome.Biome;

public class Carte {

    private ArrayList<Biome> map = new ArrayList<>();
    private int nbtour;
    

    //getters et setters
    public ArrayList<Biome> getMap() {
        return this.map;
    }

    public void setMap(ArrayList<Biome> map) {
        this.map = map;
    }

    public int getNbtour() {
        return this.nbtour;
    }

    public void setNbtour(int nbtour) {
        this.nbtour = nbtour;
    }


}
