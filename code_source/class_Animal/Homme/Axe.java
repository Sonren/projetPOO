package class_Animal.Homme;

public class Axe implements Tool{
    public String name;
    public int strength;
    public double durability;
    


  
    public Axe(String name) {
        this.name = name;
        this.strength = 5;
        this.durability = 70;
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
        this.durability = this.durability-0.4;
    }
    
    @Override
    public void remplaceoutil(String nom, int force, double durable){
            this.name = nom;
            this.strength = force;
            this.durability = durable;
    }

    

}

