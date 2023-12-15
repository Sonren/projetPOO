package class_Animal;

import java.util.ArrayList;
import java.util.Random;

import class_Biome.Biome;
import class_Carte.Case;
import class_Carte.Position;


public class  Animal {
    protected String name;
    protected int levellife;
    protected int strength;
    protected Position position;
    protected Biome biome;
    protected boolean isDead;
    private ArrayList<Animal> cfaune = new ArrayList<Animal>();
    private ArrayList<Animal> hfaune = new ArrayList<Animal>();
    private ArrayList<Animal> ofaune = new ArrayList<Animal>();

    public Animal (String n, int l, int s , Position p, Biome b){
        this.name = n;
        this.levellife = l;
        this.strength = s;
        this.position = p;
        this.biome = b;
        this.isDead = false;

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
       public boolean isDead (){
        return this.isDead;
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
        this.isDead = dead;
    }
    
    //add et remove
    //faune herbivore
    public void addherbivore(Animal pet){
        this.hfaune.add(pet);
    }
    public void removeherbivore(Animal hpet){
        this.hfaune.remove(hpet);
    }
    //faune carnivore
    public void addcarnivore(Animal pet){
        this.cfaune.add(pet);
    }
    public void removecarnivore(Animal cpet){
        this.hfaune.remove(cpet);
    }
    //faune omnivore
    public void addomnivore(Animal pet){
        this.ofaune.add(pet);
    }
    public void removeomnivore(Animal opet){
        this.hfaune.remove(opet);
    }

    /**
     * procédure qui va reduire la vie de l'animal en fonction de l'entier passer en paramètre, si la la vie de l'animal est en desous de zéro alors on tue l'animal
     * @param quantite quantité de vie a retirer a l'animal
     */
    public void looselevellife(int quantite){
        levellife -= quantite;
        if(levellife <0){
            levellife = 0;
            System.out.println("l'animal est mort");
            killedAnimal(this);
        }
    }

    /**
     * procédure qui tue un animal en passant a vrai le parametre isDead
     * @param deadAnimal c'est l'animal qu'on souhaite faire mourir
     */
    public void  killedAnimal(Animal deadAnimal){
        deadAnimal.setisDead(true);
    }
    


    /**
     * fonction qui teste si un animal est herbivore
     * @return renvoie vrai si l'animal est herbivore sinon elle renvoie faux
     */
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

    /**
     * fonction qui teste si un animal est carnivore
     * @return renvoie vrai si l'animal est carnivore sinon elle renvoie faux
     */
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

    /**
     * fonction qui teste si un animal est omnivore
     * @return renvoie vrai si l'animal est omnivore sinon elle renvoie faux
     */
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



//********************************************************************************************************************************
    //les mouvement des animaux
    
    /**
     * 
     * @param cart
     * @return
     * @throws Exception
     */
    public Position move(Case[][] cart){
        Position tempHPosition = new Position (0,0);
        Position tempBPosition = new Position (0,0);
        Position tempGPosition = new Position (0,0);
        Position tempDPosition = new Position (0,0);
        boolean goodHPosition = false;
        boolean goodBPosition = false;
        boolean goodGPosition = false;
        boolean goodDPosition = false;
        boolean result;
        Random random = new Random();
        int rand = random.nextInt(4) +1;

        goodHPosition = tempHPosition.setPosition(this.getposition().getX(), this.getposition().getY() - 1);
        goodBPosition = tempBPosition.setPosition(this.getposition().getX(), this.getposition().getY() + 1);
        goodGPosition = tempGPosition.setPosition(this.getposition().getX() - 1, this.getposition().getY());
        goodDPosition = tempDPosition.setPosition(this.getposition().getX() + 1, this.getposition().getY());
        switch (rand){
            case 1:
                result = testPosition(tempHPosition, cart);
                if (result) {
                    if(goodHPosition){
                        if (cart[tempHPosition.getX()][tempHPosition.getY()].getisanimal() == true){
                        this.AnimalmeetAnimal(cart, tempHPosition);
                        return this.getposition();
                        }else{
                            cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                            this.setposition(tempHPosition);
                            cart[tempHPosition.getX()][tempHPosition.getY()].setisanimal(true);
                            return tempHPosition;
                        }
                    }else{
                        return this.getposition();
                    }
                }
            case 2:
                result = testPosition(tempBPosition, cart);
                if (result) {
                    if(goodBPosition){
                        if (cart[tempBPosition.getX()][tempBPosition.getY()].getisanimal() == true){
                            this.AnimalmeetAnimal(cart, tempBPosition);
                        }
                        cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                        this.setposition(tempBPosition);
                        cart[tempBPosition.getX()][tempBPosition.getY()].setisanimal(true);
                        return tempBPosition;
                    }else{
                        return this.getposition();
                    }
                }
            case 3:
                result = testPosition(tempGPosition, cart);
                if (result) {
                    if(goodGPosition){
                        if (cart[tempGPosition.getX()][tempGPosition.getY()].getisanimal() == true){
                            this.AnimalmeetAnimal(cart, tempGPosition);
                        }
                        cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                        this.setposition(tempGPosition);
                        cart[tempGPosition.getX()][tempGPosition.getY()].setisanimal(true);
                        return tempGPosition;
                    }else{
                        return this.getposition();
                    }
                }
            case 4:
                result = testPosition(tempDPosition, cart);
                if (result) {
                    if(goodDPosition){
                        if (cart[tempDPosition.getX()][tempDPosition.getY()].getisanimal() == true){
                            this.AnimalmeetAnimal(cart, tempDPosition);
                        }
                        cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                        this.setposition(tempDPosition);
                        cart[tempDPosition.getX()][tempDPosition.getY()].setisanimal(true);
                        return tempDPosition;
                    }else{
                        return this.getposition();
                    }
                }
            default:
                return null;
        }
    }

    /**
     * fonction qui renvoie l'animal qui se situe a la position temppos, l'animal qui est donc sur la case notre animal veut aller
     * @param temppos position sur laquelle notre animal souhaite aller
     * @param gamemap plateau de jeu ou se situe tout les animaux
     * @param bio biome de notre animal et de celui qu'on recherche
     * @return on retourne l'animal qui se situe sur la case ou l'on souhaite aller avec notre animal et retourne null si il n'a trouvé aucun animal
     */
    public Animal findpet(Position temppos, Case[][] gamemap, Biome bio) {
        for (Animal ani : bio.getfaune()){
            if(ani.getposition().getX() == temppos.getX() && ani.getposition().getY() == temppos.getY()){
                if (ani.isDead == false){
                    return ani;
                }else{
                    return ani; //on retourne ici l'animal mort et on gère le cas dans animalmeetanimal
                }
            }
        }
        bio.afficheFaune();
        return null;
    }

    /**
     * fonction qui va gérer la rencontre entre deux animaux en fonction de leurs régime alimentaire 
     * @param mapmonde plateau de jeu sur lequel les animaux évolue
     * @param tpmpos position sur laquelle notre animal veut aller
     */
    public Position AnimalmeetAnimal(Case[][] mapmonde, Position tpmpos){
        //On doit chercher l'animal rencontré
        Animal petmeet = findpet(tpmpos, mapmonde, this.getbiome());
        if (petmeet.isDead() == true){
            System.out.println("animal mort");
            mapmonde[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(tpmpos);
            mapmonde[tpmpos.getX()][tpmpos.getY()].setisanimal(true);
            return this.getposition();
        }  
        if (petmeet != null){
            if (petmeet.isCarnivore() || petmeet.isOmnivore() && this.isCarnivore()||this.isOmnivore()){
                tpmpos = this.animalFight(petmeet, tpmpos, mapmonde); //gérer quand petmeet est mort
                return this.getposition();
            }else if((petmeet.isCarnivore() || petmeet.isOmnivore() && this.isHerbivore()) || (petmeet.isHerbivore() && this.isCarnivore() || this.isOmnivore())){
                tpmpos = this.animalEatAnimal(petmeet, tpmpos, mapmonde);
                return this.getposition();
            }else if(petmeet.isHerbivore() && this.isHerbivore()){
                tpmpos = this.animalMeetAnimal(petmeet, tpmpos, mapmonde);
                return tpmpos;
            }
        } 
        return null;
    }

    
    /**
     * procédure qui gère un combat entre deux animaux carnivore/omnivore si ils viennent a se rencontrer, l'animal ayant le plus de force gagne le combat.
     * On set la position uniquement si c'est l'animal qui voulait aller sur la case qui gagne le combat.
     * @param predatorPet correspond a l'animal qu'on rencontre et qui se situe sur la case sur laquelle on veut aller (=petmeet)
     * @param finalposi correspond a la position sur laquelle notre animal sopuhaite aller et donc correspond aussi a la position de l'animal rencontré
     * @param mapm plateau de jeu sur lequl évolue les animaux
     */
    public Position animalFight(Animal predatorPet, Position finalposi, Case[][] mapm) {
        if (this.getstrength() >= predatorPet.getstrength()){
            killedAnimal(predatorPet);
            mapm[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(finalposi);
            mapm[finalposi.getX()][finalposi.getY()].setisanimal(true);
            return this.getposition();
        }else if (predatorPet.getstrength() >= this.getstrength() ){
            killedAnimal(this); // pas besoin de set la position vu que l'animal est déja sur la case petmeet = predatorpet
            return finalposi;
        }
        return null;
    }


    /**
     * procédure qui gère la rencontre entre un carnivore/omnivore et un herbivore, le carnivore va récupérer la position finale a la fin 
     * @param animalMeet correspond a l'animal qu'on rencontre et qui se situe sur la case sur laquelle on veut aller (=petmeet)
     * @param finalposi correspond a la position sur laquelle notre animal sopuhaite aller et donc correspond aussi a la position de l'animal rencontré
     * @param map plateau de jeu sur lequl évolue les animaux
     */
    public Position animalEatAnimal(Animal animalMeet, Position finalposi, Case[][] map) {
        if(animalMeet.isCarnivore()){
            killedAnimal(this); // pas besoin de set la position vu que l'animal est déja sur la case petmeet = animalMeet
            return finalposi;
        }else if(this.isCarnivore()){
            killedAnimal(animalMeet);
            map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(finalposi);  
            map[finalposi.getX()][finalposi.getY()].setisanimal(true);
            return this.getposition();
        }
        return null;
    }

    /**
     * procédure qui gère la rencontre entre deux herbivore, il échangent de position, herbivoreMeet prend la position de l'animal qui voulais aller sur sa case et 
     * l'animal qui voulais aller sur sa case récupère donc finalposi
     * @param herbivoreMeet correspond a l'animal qu'on rencontre et qui se situe sur la case sur laquelle on veut aller (=petmeet)
     * @param finalposi correspond a la position sur laquelle notre animal sopuhaite aller et donc correspond aussi a la position de l'animal rencontré
     * @param map plateau de jeu sur lequl évolue les animaux
     */
    public Position animalMeetAnimal(Animal herbivoreMeet, Position finalposi, Case[][] map) {
        herbivoreMeet.setposition(this.getposition());
        this.setposition(finalposi);
        return this.getposition();
    }


    /**
     * Fonction qui vérifie si la postion passé en entré est correcte (si on est dans le bon biome et que la case d'arrivé est vide) 
     * @param position position d'arrivé de l'animal (this)
     * @return retourne true si la position est bonne et false si la position n'est pas bonne
     */
    public boolean testPosition(Position position, Case[][] map) {
        boolean isGoodPosition = false;
        if (isGoodBiome(position) && position.isEmptyVegetal(map)){
            isGoodPosition = true;
            return isGoodPosition;
        }else{
            return isGoodPosition;
        }
    }

    /**
     * fonction qui vérifie si la position passé en entrée correspond bien a une position dans le biome de l'animal 
     * @param pos position d'arrivé de l'animal (this)
     * @return retourne true si la position se situe dans le bon biome et renvoie false si la postion se situe dans le mauvais biome
     */
    public boolean isGoodBiome(Position pos) {
        boolean goodbiome = true;
        if (this.getbiome().getName() == "forêt"){
            if (pos.getY() < 4){
                return goodbiome; //l'animal se situe dans la forêt
            }else{
                goodbiome = false;
                return goodbiome;
            }
        }else if (this.getbiome().getName() == "plaine"){ 
                    if ((pos.getY() < 9) && (pos.getY() >= 4)){
                        return goodbiome; //l'animal se situe dans la plaine 
                    }else{
                        goodbiome = false;
                        return goodbiome;
                    }
        }else{ 
            goodbiome = false;
            return goodbiome; //aucun animal ne peut aller dans la mer 
        }
    }
}






