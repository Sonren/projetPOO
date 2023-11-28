package class_Animal; 

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
    
    public String getname (){
        return this.name;
    }
     public int getlevellife (){
        return this.levellife;
    }
     public int getstrenght (){
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
    public boolean isDeadAnimal(){
        return levellife > 0;
        }
    
    public void looselevellife(int quantite){
        levellife -= quantite;
        if(levellife <0){
            levellife = 0;
            system.out.println("l'animal est mort :(");
        }
    }
    // classe abstraite eat qui depend de si l'animal est carnivore omnivore ou herbivore
    public abstract void eatMeat(Animal);
    public abstract void eatPlant(Plant);
}

public class Carnivore extends Animal{
    //constructeur de la classe carnivore
    public Carnivore(String n, int levellife, int strength, Position pos, Biome b){
        super(name,levellife,strength,position,biome);
    }