package class_Animal;
import java.util.ArrayList;

import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;


public abstract class  Animal {
    protected String name;
    protected int levellife;
    protected int strength;
    protected Position position;
    protected Biome biome;
    private ArrayList<Animal> cfaune;
    private ArrayList<Animal> hfaune;
    private ArrayList<Animal> ofaune;

    public Animal (String n, int l, int s , Position p, Biome b){
        this.name = n;
        this.levellife = l;
        this.strength = s;
        this.position = p;
        this.biome = b;
        this.cfaune = new ArrayList<Animal>();
        this.hfaune = new ArrayList<Animal>();
        this.ofaune = new ArrayList<Animal>();
    }
    //fonction get
    
    public  String getname (){
        return this.name;
    }
     public int getlevellife (){
        return this.levellife;
    }
     public int getstrength(){
        return this.strength;
    }
      public Position getposition (){
        return this.position;
    }
       public Biome getbiome (){
        return this.biome;
    }
    //fonction set
    public void setname (String nom){
        this.name = nom;
    }
    public void setlevellife (int level){
        this.levellife = level;
    }
     public void setstrenght (int force){
        this.strength = force;
    }
     public void setposition (Position posi){
        this.position = posi;
    }
      public void setbiome (Biome bio){
        this.biome = bio;
    }
    public ArrayList<Animal> gethfaune(){
        return this.hfaune;
    }
    public ArrayList<Animal> getcfaune(){
        return this.cfaune;
    }
    public ArrayList<Animal> getofaune(){
        return this.ofaune;
    }

    // fonction qui gère si l'animal est mort ou pas
    public boolean isDeadAnimal(Animal pet){
        //this.Animal =null;   voir pour la mort de l'animal
        return this.levellife <=0;
        }
    
    public void looselevellife(int quantite){
        levellife -= quantite;
        if(levellife <0){
            levellife = 0;
            System.out.println("l'animal est mort");
        } else{
            System.out.println("l'animal n'est pas mort");
        }
    }

    public boolean isHungry(){
        return levellife < levellife/2 || strength < strength/2 ;
    } 
    // classe abstraite eat qui depend de si l'animal est carnivore omnivore ou herbivore
    public abstract void eatMeat(Animal prey);
    public abstract void eatPlant(Vegetal plant);
    



    public String whatdiet(){
        String diet;
        if (this.isCarnivore()){
            diet = "Carnivore";
            return diet ;
        }else if (isHerbivore()){
            diet = "Herbivore";
            return diet ;    
        }else if (isOmnivore()){
            diet = "Omnivore";
            return diet ;
        }
    }

    public boolean isHerbivore(){
        boolean herbi = false;
        for (Animal an : hfaune){
            if (an.getname() == this.getname()){
                herbi = true;
                return herbi;
            }
        }
        return herbi;
    }

    public boolean isCarnivore(){
        boolean carni = false;
        for (Animal an : cfaune){
            if (an.getname() == this.getname()){
                carni = true;
                return carni;
            }
        }
        return carni;
    }

    public boolean isOmnivore(){
        boolean omni = false;
        for (Animal an : ofaune){
            if (an.getname() == this.getname()){
                omni = true;
                return omni;
            }
        }
        return omni;
    }
}
