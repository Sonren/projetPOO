package class_Carte;

import java.util.ArrayList;

import class_Animal.Animal;
import class_Biome.Biome;
import java.util.Random;
import class_Carte.*;

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
   
    public boolean isEmpty(Position p){
        boolean empty = false;
        
        return empty;
        //TODO
   }

   public void verifmvtanimal(Animal pet, Position pos){
    //TODO
   } 


    public void haut (Animal an, Position pos){
        pos.y -= 1;
        if (!(isEmpty(pos))) {
            verifmvtanimal(an,pos);
        }else{
            an.setposition (pos);
        }
    }
         
    public void bas (Animal an, Position pos){
        pos.y += 1;
        if (!(isEmpty(pos))) {
            verifmvtanimal(an,pos);
        }else{
            an.setposition (pos);
        }
    }

    public void droite (Animal an, Position pos){
        pos.x += 1;
        if (!(isEmpty(pos))) {
            verifmvtanimal(an,pos);
        }else{
            an.setposition (pos);
        }
    }

    public void gauche (Animal an, Position pos){
        pos.x -= 1;
        if (!(isEmpty(pos))) {
            verifmvtanimal(an,pos);
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
