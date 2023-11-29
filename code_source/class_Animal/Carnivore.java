package class_Animal;

import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;
public class Carnivore extends Animal{

    //constructeur de la classe carnivore
    public Carnivore(String n, int levellife, int strength, Position pos, Biome b){
        super(n,levellife,strength,pos,b);
    }

    //implémentation de la méthode eatMeat

    @Override
    public void eatMeat(Animal prey){
        int preystrength = prey.getstrength();
        // compare le force des deux animaux et this mange la proie que si il a plus de force
        if(this.getstrength() > preystrength){
            System.out.println(this.getname() + " mange " + prey.getname());
            this.levellife += 5;
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
        System.out.println("Les Carnivores ne mangent pas de plantes");;
   } 
  

}
    

