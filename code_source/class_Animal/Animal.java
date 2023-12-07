package class_Animal;
import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;


public abstract class  Animal {
    protected String name;
    protected int levellife;
    protected int strength;
    protected Position position;
    protected Biome biome;

    public Animal (String n, int l, int s , Position p, Biome b){
        this.name = n;
        this.levellife = l;
        this.strength = s;
        this.position = p;
        this.biome = b;
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
        }
    }

    public boolean isHungry(){
        return levellife < levellife/2 || strength < strength/2 ;
    } 
    // classe abstraite eat qui depend de si l'animal est carnivore omnivore ou herbivore
    public abstract void eatMeat(Animal prey);
    public abstract void eatPlant(Vegetal plant);
    
}

