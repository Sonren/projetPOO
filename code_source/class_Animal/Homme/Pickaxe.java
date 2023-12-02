package class_Animal.Homme;

public class Pickaxe implements Tool {

    public String name;
    public int strength;
    public double durability;
    


  
    public Pickaxe(String name, int strength) {
        this.name = name;
        this.strength = strength;
        this.durability = 100;
    }
  
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public double getDurability() {
        return this.durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    @Override
    public void useoutil(){
        this.durability = this.durability-0.5;
    }
    
    @Override
    public void remplaceoutil(String nom, int force, double durable){
            this.name = nom;
            this.strength = force;
            this.durability = durable;
    }

    

}