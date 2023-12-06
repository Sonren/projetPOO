package class_Animal;

import java.util.ArrayList;

import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;

public class Herbivore extends Animal {

    private ArrayList<Animal> hfaune;

    public Herbivore(String n, int levellife, int strength, Position pos, Biome b){
        super(n,levellife,strength,pos,b);
        this.hfaune = new ArrayList<Animal>();
    } 
   
       public ArrayList<Animal> gethfaune(){
        return this.hfaune;
    }

    public boolean isCarnivore(Animal pet){
        boolean herbi = false;
        for (Animal an : hfaune){
            if (pet.getname() == an.getname()){
                herbi = true;
                return herbi;
            }
        }
        return herbi;
    }

   
   
   
    @Override
   public void eatPlant(Vegetal plant){
        // avoir : peut-être mettre un niveau de nutriment pour les plantes
       // int plantVitamin = plant.getNutriment();
        int plantVitamin = 5; // pour l'instant
        this.levellife += plantVitamin;
        System.out.println(this.getname() + "mange"+ plant.getname());

   }  

  @Override 
   public void eatMeat(Animal prey){
    System.out.println("Les Herbivores ne mangent pas de viandes");
   }  
    
}
