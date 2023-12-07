package class_Carte;

import java.util.ArrayList;

import class_Animal.*;
import class_Biome.*;
import java.util.Random;
import class_Carte.*;
import class_Vegetal.Vegetal;
import class_Animal.Carnivore;

public class Carte {

    private Case[][] map = new Case[100][100];
    //private ArrayList<Case> map = new ArrayList<>(); 
    private int nbtour;
    

    //getters et setters
    public Case[][] getMap() {
        return this.map;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }

    public int getNbtour() {
        return this.nbtour;
    }

    public void setNbtour(int nbtour) {
        this.nbtour = nbtour;
    }

    public void addtour (){
        this.nbtour += 1;
    }

    public boolean samePosition (Animal pet){
       boolean sposition = false;
       for(Animal ani : getfaune){
            if (ani.getposition() == pet.getposition()){
                sposition = false;
                return sposition;
            }else{
                return sposition;
            }
       }
    }
   
    public void preservefaune (){
        
    }

    public void fuite(Animal petfuite){
        //TODO
    }

    public boolean isEmpty(Position p){
        boolean empty = false;
        
        return empty;
        //TODO
   }
 
   public boolean verifflore(Animal pet){
        boolean isoccuped = false;
        for(Vegetal veg : getflore){
            if (veg.getposition() == pet.getposition()){
                isoccuped = true;
                return isoccuped;
            }
        }
        return isoccuped;
    }
   
    public String whatdiet (Animal an){
        if (isCarnivore(an)){
            return "Carnivore";
        }else if (isHerbivore(an)){
                return "Herbivore";
        }else if (isOmnivore(an)){
            return "Omnivore";
        }
    }

    public Animal findpet (Position pos){
        for(Animal ani : getfaune){
            if (ani.getposition() == pos){
                return ani;
            }//else leve exception
        }
    }


    public void carnivoreeatcarnivore (Animal predator, Animal hunter){
        if (predator.getstrength() >= hunter.getstrength()){
            hunter.looselevellife(2*predator.getstrength());
                if (!isDeadAnimal(hunter)){
                     fuite(hunter);
                     fuite(predator);
                }
        }
    }

    public void carnivoreeatherbivore (Animal predator, Animal brebis){
        brebis.looselevellife(2*predator.getstrength());
                    if (!isDeadAnimal(brebis)){
                        fuite(brebis);
                    }
    }

    //a voir pour rajouter des trucs sinon enlever procedure
    public void herbivoremeetherbivore (Animal brebis, Animal chevre){
        fuite(brebis);
        fuite(chevre);
    }

// voir pour gerer rencontre herbivore carnivore et omnivore
    public void animalmeetanimal(Animal pet){
    String diet; 
    String gibierdiet;
    Animal gibier;
        if (samePosition(pet)){
            diet = whatdiet(pet);
            gibier = findpet(pet.getposition());
            gibierdiet = whatdiet(gibier);
            if (((diet == "Carnivore") || (diet == "Omnivore")) && ((gibierdiet == "Carnivore") || (gibierdiet == "Omnivore"))){ //carnivore ou omnivorequi veut manger carnivore ou omnivore
                carnivoreeatcarnivore(pet, gibier);
            }else if (((diet == "Carnivore") || (diet == "Omnivore")) && (gibierdiet == "Herbivore")){ // carnivore ou omnivore qui mange herbivore
                carnivoreeatherbivore(pet, gibier);
            }else if ((diet == "Herbivore") && (gibierdiet == "Herbivore")){
                herbivoremeetherbivore(pet,gibier);
            }
        }
    } 


    public void haut (Animal an, Position pos){
        pos.y -= 1;
        if (!(isEmpty(pos))) {
            if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }       
        }else{
            an.setposition (pos);
        }
    }
         
    public void bas (Animal an, Position pos){
        pos.y += 1;
        if ((!isEmpty(pos))) {
           if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }
        }else{
            an.setposition (pos);
        }
    }

    public void droite (Animal an, Position pos){
        pos.x += 1;
        if (!(isEmpty(pos))) {
            if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }
        }else{
            an.setposition (pos);
        }
    }

    public void gauche (Animal an, Position pos){
        pos.x -= 1;
        if (!(isEmpty(pos))) {
            if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }
        }else{
            an.setposition (pos);
        } 
    }


    public void randommvt(Animal pet, Position posi){
        Random random = new Random();
        int rand = random.nextInt(4) +1;
        

        switch (rand){
            case 1:
                haut(pet, posi);
                break;
            case 2:
                bas(pet, posi);
                break;
            case 3:
                gauche(pet, posi);
            case 4:
                droite(pet, posi);
                break;
            default:

                break;
        }

    }
}
