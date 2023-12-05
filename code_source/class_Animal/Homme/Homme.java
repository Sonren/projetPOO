package class_Animal.Homme;

import class_Animal.Omnivore;
import class_Biome.Biome;
import class_Carte.Position;
import class_Animal.Homme.*;

public class Homme extends Omnivore {
    public Inventaire invent;

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

