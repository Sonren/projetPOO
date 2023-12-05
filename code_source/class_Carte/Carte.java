package class_Carte;

import java.util.ArrayList;

import class_Animal.Animal;
import class_Biome.Biome;
import java.util.Random;

public class Carte {

    private ArrayList<Case> map = new ArrayList<>(); 
    private int nbtour;
    

    //getters et setters
    public ArrayList<Case> getMap() {
        return this.map;
    }

    public void setMap(ArrayList<Carte> map) {
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

   
    public void haut (Animal an, Position pos){
        pos.y -= 1;
        an.setposition (pos); 
    }
   
    public void bas (Animal an, Position pos){
        pos.y += 1;
        an.setposition (pos); 
    }

    public void droite (Animal an, Position pos){
        pos.x += 1;
        an.setposition (pos); 
    }

    public void gauche (Animal an, Position pos){
        pos.x -= 1;
        an.setposition (pos); 
    }


    public void randommvt(Animal pet){
        Random random = new Random();
        int rand = random.nextInt(4) +1;

        switch (rand){
            case 1:
                haut(pet);
                break;
            case 2:
                bas(pet);
                break;
            case 3:
                gauche(pet);
            case 4:
                droite(pet);
                break;
            default:

                break;
        }

    }
}
