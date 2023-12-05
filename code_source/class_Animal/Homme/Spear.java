package class_Animal.Homme;

public class Spear implements Tool{
    public String name;
    public int strength;
    public double durability;

    


  
    public Spear(String name) {
        this.name = name;
        this.strength = 10;
        this.durability = 50;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int getStrength() {
        return this.strength;
    }
    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public double getDurability() {
        return this.durability;
    }
    @Override
    public void setDurability(double durability) {
        this.durability = durability;
    }

    @Override
    public void useoutil(){
        if(this.durability>0){
        this.durability = this.durability-0.6;
        } else{
        System.out.println("l'outil"+ this.getName()+ "a expiré");
        }  
    }
    
    @Override
    public void remplaceoutil(String nom, int force, double durable){
            this.name = nom;
            this.strength = force;
            this.durability = durable;
    }

    

}