package class_Biome;

import java.util.ArrayList;
import class_Vegetal.Vegetal;
import class_Animal.Animal;
import class_Animal.Homme.Homme;
import class_Animal.Homme.Tool;

public class Plaine extends Biome {
    private int nbrochers;
    
    public Plaine(String nom) {
        super(nom);
        this.nbrochers = 0;
    }

   /* // Méthode permettant à l'Homme de couper du bois avec son outil sans perdre de vie
    public int getCouperBoisOutil(Homme homme, Axe hache) {
        int boisGagne = 10;  // Valeur à revoir 
        System.out.println(Animal.getname() + " coupe du bois avec un(e) " + outil.getType() + " dans la plaine.");//Il faudrait voir pour recuperer le nom de l'homme a partir de la class animal
        //et on ne peut pas recuperer le type d'un outil comme ca vu que c'est une interface
        System.out.println("Gagne " + boisGagne + " unités de bois.");
        return boisGagne;
    }  

    // Méthode permettant à l'Homme de couper du bois sans outil entrainant une perte de vie
    public int getCouperBois(Homme homme) {
        int boisGagne = 5;  // Valeur à revoir
        int viePerdue = 3;  // Valeur à revoir 
        System.out.println(Animal.getname() + " coupe du bois à mains nues dans la plaine."); 
        System.out.println("Gagne " + boisGagne + " unités de bois, mais perd " + viePerdue + " points de vie.");
        return boisGagne;
    }

*/}
