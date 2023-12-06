package class_Animal;

import java.util.ArrayList;

import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;


public class Omnivore extends Animal{

    private ArrayList<Animal> ofaune;

    public Omnivore(String n, int l, int s, Position p, Biome b){
        super(n,l,s,p,b);
        this.ofaune = new ArrayList<Animal>();
    }  
   
       public ArrayList<Animal> gethfaune(){
        return this.ofaune;
    }

    public boolean isCarnivore(Animal pet){
        boolean omni = false;
        for (Animal an : ofaune){
            if (pet.getname() == an.getname()){
                omni = true;
                return omni;
            }
        }
        return omni;
    }
    
    
    @Override
    public void eatMeat(Animal prey){
        int preystrength = prey.getstrength();
        // compare le force des deux animaux et this mange la proie que si il a plus de force
        if(this.getstrength() > preystrength){
            System.out.println(this.getname() + " mange " + prey.getname());
            this.levellife += 5; // peut-être plus?
        } 
        else{
            // à voir , reajuster???
            int damage = preystrength/2;
            this.looselevellife(damage);
            System.out.println(this.getname() + " n'a pas pu manger" + prey.getname());
            
        } 
    } 
    @Override
    public void eatPlant(Vegetal plant){
         // avoir : peut-être mettre un niveau de nutriment pour les plantes
        // int plantVitamin = plant.getNutriment();
         int plantVitamin = 5; // pour l'instant
         this.levellife += plantVitamin;
         System.out.println(this.getname() + "mange"+ plant.getname());
        
    }
    

}
