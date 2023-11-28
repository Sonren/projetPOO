package class_Biome;

import java.util.ArrayList;
import class_vegetal.Vegetal;
import class_Animal.Animal;

public class Plaine extends Biome {
    private int nbrobers;
    
    public Plaine(String nom) {
        super(nom);
        this.nbrobers = 0;
    }

    // Méthode permettant à l'Homme de couper du bois avec son outil sans perdre de vie
    public int getCouperBoisOutil(Homme homme, Outil outil) {
        int boisGagne = 10;  // Valeur à revoir 
        System.out.println(homme.getName() + " coupe du bois avec un(e) " + outil.getType() + " dans la plaine.");
        System.out.println("Gagne " + boisGagne + " unités de bois.");
        return boisGagne;
    }  

    // Méthode permettant à l'Homme de couper du bois sans outil entrainant une perte de vie
    public int getCouperBois(Homme homme) {
        int boisGagne = 5;  // Valeur à revoir
        int viePerdue = 3;  // Valeur à revoir 
        System.out.println(homme.getName() + " coupe du bois à mains nues dans la plaine.");
        System.out.println("Gagne " + boisGagne + " unités de bois, mais perd " + viePerdue + " points de vie.");
        return boisGagne;
    }

}
