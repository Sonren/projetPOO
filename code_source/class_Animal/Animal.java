package class_Animal;

import java.util.ArrayList;
import java.util.Random;

import class_Biome.Biome;
import class_Biome.Biomes;
import class_Carte.Carte;
import class_Carte.Case;
import class_Carte.Position;
import class_Vegetal.Vegetal;


public abstract class  Animal {
    protected String name;
    protected int levellife;
    protected int strength;
    protected Position position;
    protected Biome biome;
    boolean idDead;
    private ArrayList<Animal> cfaune = new ArrayList<Animal>();
    private ArrayList<Animal> hfaune = new ArrayList<Animal>();
    private ArrayList<Animal> ofaune = new ArrayList<Animal>();

    public Animal (String n, int l, int s , Position p, Biome b){
        this.name = n;
        this.levellife = l;
        this.strength = s;
        this.position = p;
        this.biome = b;
        this.idDead = false;

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
       public boolean getisDead (){
        return this.idDead;
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
      public void setisDead (boolean dead){
        this.idDead = dead;
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

    //a voir si on veut garder la procedure
    public boolean isDeadAnimal(Animal pet){
        return pet.levellife <=0;
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
    



    public String whatdiet(){
        String diet = " ";
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
        return diet;
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

    public void addherbivore(Animal pet){
        this.hfaune.add(pet);
    }

    public void removeherbivore(Animal hpet){
        this.hfaune.remove(hpet);
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

    public void addcarnivore(Animal pet){
        this.cfaune.add(pet);
    }

    public void removecarnivore(Animal cpet){
        this.hfaune.remove(cpet);
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

    public void addomnivore(Animal pet){
        this.ofaune.add(pet);
    }

    public void removeomnivore(Animal opet){
        this.hfaune.remove(opet);
    }

    public void  killedAnimal(Animal deadAnimal){
        System.out.println("coucou");
        deadAnimal.idDead = true;
       /*  deadAnimal.getbiome().removeAnimal(deadAnimal);
        if (deadAnimal.isCarnivore()){
            deadAnimal.removecarnivore(deadAnimal);
        }else if (deadAnimal.isHerbivore()){
            deadAnimal.removeherbivore(deadAnimal);
        }else if (deadAnimal.isOmnivore()){
            deadAnimal.removeomnivore(deadAnimal);
        }*/
        //deadAnimal.setlevellife(0);
        //deadAnimal.setname(null);
        //deadAnimal.setstrenght(0);
        //deadAnimal.setposition(null);
        //deadAnimal.getbiome().removeAnimal(deadAnimal);

    }

   
    public boolean inbiome(Position pos){
        boolean biome = false;
        if (this.getbiome().getName() == "forêt"){
            if (pos.getY() < 4){
                biome = true;
                return biome;
            }else{
                return biome;
            }
        }else if (this.getbiome().getName() == "plaine"){
            if ((pos.getY() < 9) && (pos.getY() >= 4)){
                biome = true;
                return biome; 
            }else{
                return biome;
            }
        }else{ 

            return biome; //aucun animal ne peut aller dans la mer 
        }
    }

    
    public Position randommvt(Case [][] mapworld){
        Random random = new Random();
        int rand = random.nextInt(4) +1;
        
        switch (rand){
            case 1:
                System.out.println("haut");
                return this.haut(mapworld);
            case 2:
                System.out.println("bas");
                return this.bas(mapworld);
            case 3:
                System.out.println("gauche");
                return this.gauche(mapworld);
            case 4:
                System.out.println("droite");
                return this.droite(mapworld);     
        }
        return this.getposition();
    }



    /**
     * fonction qui recherche l'animal que l'animal qui va bouger rencontre a la case ou il va 
     * @param pos position d'arrivé de l'animal qui bouge 
     * @param mapworld plateau de jeu ou les animaux sont implémenté
     * @param bio biome dans lequel l'animal qui bouge se trouve 
     * @return
     */
    public Animal chercheAnimal (Position pos, Case[][] mapworld, Biome bio){
        Animal petmet = null;
        for (Animal ani : bio.getfaune()){
            System.out.println(" petmeet = " + ani.getname() + " a la position x = " + ani.getposition().getX() + " y = " + ani.getposition().getY());
            System.out.println(" x = " + pos.getX() + " y = " + pos.getY());
            if (ani.getposition().getX() == pos.getX() && ani.getposition().getY() == pos.getY()){
                petmet = ani;
                return ani; 
            }

        }
        System.out.println("aucun animal dans la case visé");
        return null;
    }
    
    /**
     * procédure qui gère la rencontre entre deux carnivores, celui qui a plus de force gagne la bataille reste sur la carte, l'autre part 
     * @param predator carnivore rencontré par l'animal qui bouge 
     * @param mapwrld plateau de jeu ou sont placé les animaux
     * @param posi position d'arrivé de l'animal qui est en train de bouger
     */
    public void carnivoreeatcarnivore (Animal predator, Case[][] mapw, Position posi){
        if (predator.getstrength() >= this.getstrength()){
                    killedAnimal(this);
                    predator.setposition(posi);
        }else if (this.getstrength() >= predator.getstrength()){
                    killedAnimal(predator);
                    this.setposition(posi);
        }
    }

    /**
     * fonction qui gère la rencontre entre un carnivore et un herbivore, la carnivore mange ou blesse l'herbivore, si l'herbivore est mort alors isDead est true 
     * @param brebis animal rencontré par l'animal qui bouge (soit l'herbivore ou le carnivore en fonction du régime alimentaire de l'animal qui bouge) 
     * @param mapwrld plateau de jeu ou sont placé les animaux
     * @param posi position d'arrivé de l'animal qui est en train de bouger
     */
    public void carnivoreeatherbivore (Animal brebis, Case[][] mapwrld, Position pos){
        killedAnimal(brebis);
        this.setposition(pos);
    }

    /**
     * fonction qui gère la rencontre entre deux herbivore, l'un va partir de la case tandis que l'autre reste 
     * @param chevre l'animal rencontré par l'animal qui bouge avec le randomposition
     * @param mapw plateau de jeu ou sont placé les animaux
     * @param posi position d'arrivé de l'animal qui est en train de bouger 
     */
    public void herbivoremeetherbivore (Animal chevre, Case[][] mapw, Position posi){
        System.err.println("deux herbivores se rencontre");
        System.out.println("brebis : x = " + this.getposition().getX() + " y = " + this.getposition().getY());
        System.out.println("chevre : x = " + chevre.getposition().getX() + " y = " + chevre.getposition().getY());
        if (this.getlevellife() >= chevre.getlevellife()){
            System.out.println(chevre.getname() + " a fuit");
            chevre.randommvt(mapw);
            this.setposition(posi);
        }else if (chevre.getlevellife() > this.getlevellife()){
            System.out.println(this.getname() + " a fuit");
            this.randommvt(mapw);
            chevre.setposition(posi);
        }
    }

    /**
     * on entre dans cette procédure si le mouvement de l'animal comporte un problème 
     * @param map plateau de jeu ou on trouve tout les animaux 
     * @param posariv position d'arrivé de l'animal qui n'as pas encore été déplacé 
     * @param wrposition booléen qui renvoie true si la position est hors du plateau de jeu
     * @return retourne la position corriger 
     */
    public Position correctMoveAnimal (Case[][] map, Position posariv, boolean wrposition){
         System.out.println("entre dans correctmove");
        Animal petmeet;
        if (!(this.inbiome(posariv))){
            posariv.setPosition(this.getposition().getX(), this.getposition().getY(), wrposition);
            System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
            return posariv = this.randommvt(map);
        }else if (map[posariv.getX()][posariv.getY()].getisvegetal() == true || map[posariv.getX()][posariv.getY()].getisrocher() == true){
            System.out.println(this.getbiome().getName() + " " + this.getname() + " est dans le bon biome");
            posariv.setPosition(this.getposition().getX(), this.getposition().getY(), wrposition);
            System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
            return posariv = this.randommvt(map);
        }else if (wrposition){
            System.out.println(this.getname() + " est hors de la carte");
            posariv.setPosition(this.getposition().getX(), this.getposition().getY(), wrposition);
            System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
            return posariv = this.randommvt(map);
        }else if (map[posariv.getX()][posariv.getY()].getisanimal() == true){
            System.out.println("posariv x = " + posariv.getX() + " y = " + posariv.getY());
            petmeet = chercheAnimal(posariv, map, this.getbiome());
            if (petmeet.isCarnivore() || petmeet.isOmnivore() && this.isCarnivore() || this.isOmnivore()){
                this.carnivoreeatcarnivore(petmeet, map, posariv);
            }else if (petmeet.isCarnivore() || petmeet.isOmnivore() && this.isHerbivore()){
                this.carnivoreeatherbivore(petmeet, map, posariv);
            }else if (petmeet.isHerbivore() && this.isCarnivore() || this.isOmnivore()){
                this.carnivoreeatherbivore(petmeet, map, posariv);
            }else if (petmeet.isHerbivore() && this.isHerbivore()){
                this.herbivoremeetherbivore(petmeet, map, posariv);
            }
        }else if (!posariv.isEmpty(this.haut(map), map) || !inbiome(this.haut(map)) && !posariv.isEmpty(this.bas(map), map) || !inbiome(this.bas(map)) && !posariv.isEmpty(this.gauche(map), map) || !inbiome(this.gauche(map)) && !posariv.isEmpty(this.droite(map), map) || !inbiome(this.droite(map))){
            System.out.println("aucune case de libre");
            return null;
        }
        return posariv;
        
    }

    /**
     * la fonction change la position de l'animal en le deplacant d'une case en haut si la position est correcte sinon elle passe par corectmove
     * @param cart plateau de jeu dans lequel évolue les animaux
     * @return la position de l'animal déplacé en haut avec la position correct
     */
    public Position haut (Case[][] cart){
        Position posarrive= new Position (0,0); 
        boolean bio;
        boolean wposition = false;
        posarrive.setPosition(this.getposition().getX(), this.getposition().getY(), wposition);
        posarrive.setY(posarrive.getY() - 1, wposition); 
        bio = this.inbiome(posarrive);        
        if(bio){
            System.out.println("l'animal est dans le bon biome");
            if(this.getposition().isEmpty(posarrive, cart)){
                System.out.println("la position a été changé");
                cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition (posarrive);
                cart[posarrive.getX()][posarrive.getY()].setisanimal(true);
                return this.getposition();
            }else{
                System.out.println("la case d'arrivé n'est pas vide");
                System.out.println( "posarive : x = " + posarrive.getX() + " y = " + posarrive.getY());
                return this.correctMoveAnimal(cart, posarrive,wposition);
            }  
        }else{
            System.out.println("animal dans le mauvais biome");
            return this.correctMoveAnimal(cart, posarrive, wposition);
        }
    }


    /**
     * la fonction change la position de l'animal en le deplacant d'une case en bas si la position est correcte sinon elle passe par corectmove
     * @param cart plateau de jeu dans lequel évolue les animaux
     * @return la position de l'animal déplacé en bas avec la position correct
     */
    public Position bas (Case[][] cart){
        Position posarrive = new Position (0,0);
        boolean bio;
        boolean wposition = false;
        posarrive.setPosition(this.getposition().getX(), this.getposition().getY(), wposition);
        posarrive.setY(posarrive.getY() + 1, wposition);
        bio = this.inbiome(posarrive);
        if(bio){
            System.out.println("l'animal est dans le bon biome");
            if(this.getposition().isEmpty(posarrive, cart)){
                System.out.println("la position a été changé");
                cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition (posarrive);
                cart[posarrive.getX()][posarrive.getY()].setisanimal(true);
                return this.getposition();
            }else{
                System.out.println("la case d'arrivé n'est pas vide");
                return this.correctMoveAnimal(cart, posarrive, wposition);           
            }            
        }else{
            System.out.println("animal dans le mauvais biome");
            return this.correctMoveAnimal(cart, posarrive, wposition);
        }
    }
    
        
    /**
     * la fonction change la position de l'animal en le deplacant d'une case a droite si la position est correcte sinon elle passe par corectmove
     * @param cart plateau de jeu dans lequel évolue les animaux
     * @return la position de l'animal déplacé a droite avec la position correct
     */
    public Position droite (Case[][] cart){
        Position posarrive = new Position (0,0);
        boolean bio;
        boolean wposition = false;
        posarrive.setPosition(this.getposition().getX(), this.getposition().getY(), wposition);
        posarrive.setX(posarrive.getX() + 1, wposition);
        bio = this.inbiome(posarrive);
        if(bio){
            System.out.println("l'animal est dans le bon biome");
            if(this.getposition().isEmpty(posarrive, cart)){
                System.out.println("la position a été changé");
                cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition (posarrive);
                cart[posarrive.getX()][posarrive.getY()].setisanimal(true);
                return this.getposition();
            }else{
                System.out.println("la case n'est pas vide");
                return this.correctMoveAnimal(cart, posarrive, wposition);
            }  
        }else{
            System.out.println("animal dans le mauvais biome");
            return this.correctMoveAnimal(cart, posarrive, wposition);
        }
    }
    

    /**
     * la fonction change la position de l'animal en le deplacant d'une case a gauche si la position est correcte sinon elle passe par corectmove
     * @param cart plateau de jeu dans lequel évolue les animaux
     * @return la position de l'animal déplacé a gauche avec la position correct
     */
    public Position gauche (Case[][] cart){
        Position posarrive = new Position (0,0);
        boolean bio;
        boolean wposition = false;
        posarrive.setPosition(this.getposition().getX(), this.getposition().getY(), wposition);
        posarrive.setX(posarrive.getX() - 1, wposition);
        bio = this.inbiome(posarrive);
        if(bio){
            System.out.println("l'animal est dans le bon biome");
            if(this.getposition().isEmpty(posarrive, cart)){
                System.out.println("la position a été changé");
                cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition (posarrive);
                cart[posarrive.getX()][posarrive.getY()].setisanimal(true);
                return this.getposition();
            }else{
                System.out.println("la case d'arrivé n'est pas vide");
                return this.correctMoveAnimal(cart, posarrive, wposition);
            }  
        }else{
            System.out.println("animal dans le mauvais biome");
            return this.correctMoveAnimal(cart, posarrive, wposition);
        }
        
    }

}






