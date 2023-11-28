package class_Animal;
import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;


public class  Animal {
    private String name;
    private int levellife;
    private int strength;
    private Position position;
    private Biome biome;

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
}

