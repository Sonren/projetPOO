package class_Animal.Homme;

import class_Animal.Animal;
import class_Animal.Omnivore;
import class_Biome.Biome;
import class_Carte.Position;
import class_Animal.Homme.*;

public class Homme extends Omnivore {
    public Inventaire invent;

    // Méthode permettant à l'Homme de couper du bois avec son outil sans perdre de vie
    public int getCouperBoisOutil(Homme homme, Tool Axe : hache) {
        int boisGagne = 10;  // Valeur à revoir 
        System.out.println(Animal.getnom() + " coupe du bois avec un(e) " + outil.getType() + " dans la plaine.");//Il faudrait voir pour recuperer le nom de l'homme a partir de la class animal
        //et on ne peut pas recuperer le type d'un outil comme ca vu que c'est une interface
        System.out.println("Gagne " + boisGagne + " unités de bois.");
        return boisGagne;
    }  

    // Méthode permettant à l'Homme de couper du bois sans outil entrainant une perte de vie
    public int getCouperBois(Homme homme) {
        int boisGagne = 5;  // Valeur à revoir
        int viePerdue = 3;  // Valeur à revoir 
        System.out.println(Animal.getnom() + " coupe du bois à mains nues dans la plaine."); 
        System.out.println("Gagne " + boisGagne + " unités de bois, mais perd " + viePerdue + " points de vie.");
        return boisGagne;
    }

    //Méthode permettant à l'Homme de miner des rochers avec son outil sans perdre de vie
    public int getMinerOutil(Homme homme, Outil outil) {
        int pierreGagnee = 8;  // Valeur à revoir 
        System.out.println(homme.getName() + " mine avec un(e) " + outil.getType() + " dans la plaine.");
        System.out.println("Gagne " + pierreGagnee + " unités de pierre.");
        return pierreGagnee;
    }
    
    //Méthode permettant à l'Homme de miner des rochers sans outil entrainant une perte de vie
    public int getMiner(Homme homme) {
        int pierreGagnee = 5;  // Valeur à revoir 
        int viePerdue = 4;  // Valeur à revoir 
        System.out.println(homme.getName() + " mine des rochers à mains nues dans la plaine.");
        System.out.println("Gagne " + pierreGagnee + " unités de pierre, mais perd " + viePerdue + " points de vie.");
        return pierreGagnee;
    }
    
}
    public Homme(String n, int l, int s,Position p, Biome b,Inventaire invent) {
        super(n,l,s,p,b);
        this.invent = invent;
    }
    
    //getters et setters
    public Inventaire getInvent() {
        return this.invent;
    }

    public void setInvent(Inventaire invent) {
        this.invent = invent;
    }
    //demander au prof comment faire un for avec une interface 
    public boolean hasTool(String toolName){
        for(Tool atool: invent.getArsenal()){
            if(atool.getName().equals(toolName)){
                return true;
            }
        }
        return false;
    }
    //public void 
/*recolterbois(outil,vegetal)?? si pas encore d'outil utilise sa force 
pareil pour recolter Fruit
    public void recolterBois(int quantity){
        invent.ajouterBois(quantity);
        System.out.println(this.getname() + "a recolté" + quantity + "de bois"  );
    } 

    public void recolterFruit(int quantity){
        invent.ajouterFruit(quantity);
        System.out.println(this.getname() + "a recolté" + quantity + "de fruits");
    } 

    public void chasse(Animal prey){
        
    }  
    //commet faire pour ajouter un outil créer dans l'inventaire 
    //comment questioner l'inventaire
}
*/}

