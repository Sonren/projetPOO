package class_Animal.Homme;

public class Pickaxe implements Tool {

    public String name;
    public int strength;
    public double durability;
    


  
    public Pickaxe(String name) {
        this.name = name;
        this.strength = 7;
        this.durability = 100;
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
        this.durability = this.durability-0.5;
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