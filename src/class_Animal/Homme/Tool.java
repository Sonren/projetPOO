package class_Animal.Homme;


public interface Tool {

     public void useoutil();
     public String getName();
     public int getStrength();
     public double getDurability();
     public void setName(String name);
     public void setStrength(int strength);
     public void setDurability(double durability);
     public void remplaceoutil(String nom,int force,double durable);
}
