package class_Biome;

import java.util.ArrayList;
import class_Vegetal.Vegetal;
import class_Animal.Animal;
import class_Animal.Homme.Homme;
import class_Animal.Homme.Tool;

public class Foret extends Biome {
    private int nbrochers;
    
    public Foret(String nom) {
        super(nom);
        this.nbrochers = 0;
    }
}