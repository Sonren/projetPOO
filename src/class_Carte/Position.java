package class_Carte;

import java.util.Random;

import class_Biome.Biome;
import class_Biome.Biomes;

/**
* La classe Position représente les coordonnées (x, y) d'une position sur la carte.
* Elle fournit des méthodes pour obtenir et définir les coordonnées, vérifier si la position est vide,
* et générer une position aléatoire en fonction du biome spécifié.
*/
public class Position {
    protected int x;
    protected int y;
    

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    //getters et setters
    public int getX() {
        return this.x;
    }

    public void setX(int xx, boolean isCorrectPosition) {
        if (xx < 0 || xx > 9){
            isCorrectPosition = true;
        } else {
            this.x = xx;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int yy, boolean isCorrectPosition) {
        if (yy < 0 || yy > 9){
            isCorrectPosition = true;
        } else {
            this.y = yy;
        }
    }


    public boolean setPosition (int xx, int yy){
        boolean isCorrectPosition = false;
        if (yy < 0 || yy > 9) {
          if (yy > 9){
            this.x = xx;
            this.y = 9;
          }
          this.x = xx;
          return isCorrectPosition;
        }
        if ( xx < 0 || xx > 9){
          if(xx > 9){
            this.y = yy;
            this.x = 9;
          }
          this.y = yy;
          return isCorrectPosition;
        }
        if(yy >= 0 && yy <= 9 && xx >= 0 && xx <= 9){
            this.x = xx;
            this.y = yy;
            isCorrectPosition = true;
            return isCorrectPosition;
        }
        return isCorrectPosition;
    }
        

    /**
     * Vérifie si la position est vide dans la carte donnée.
     *
     * @param map La carte dans laquelle vérifier la position.
     * @return    True si la position est vide, sinon False.
     */
    public boolean isEmpty (Case[][] map){
        boolean empty = false;
        if(map[this.getX()][this.getY()].getisanimal()){
            return empty;
        }else if (map[this.getX()][this.getY()].getisvegetal()){
            return empty;
        }else if (map[this.getX()][this.getY()].getisrocher()){
            return empty;
        }else{
            empty = true;
            return empty;
        }
    }

    /**
     * Vérifie si la position est vide pour les végétaux dans la carte donnée.
     *
     * @param map La carte dans laquelle vérifier la position.
     * @return    True si la position est vide pour les végétaux, sinon False.
     */
    public boolean isEmptyVegetal(Case[][] map) {
        boolean isEmptyVeg = false;
        if (map[this.getX()][this.getY()].getisvegetal()){
            return isEmptyVeg;
        }
        if (map[this.getX()][this.getY()].getisrocher()){
            return isEmptyVeg;
        }
        isEmptyVeg = true;
        return isEmptyVeg;
    }
    
    /**
     * Génère une position aléatoire en fonction du biome spécifié.
     *
     * @param bio      Le biome spécifié.
     * @param mapwrld  La carte du monde.
     * @return         La nouvelle position générée.
     */
    public Position ramdomPosition(Biome bio, Case[][] mapwrld){
        Random rand = new Random();
        boolean isgoodPosition = false;
        if (bio.getName() == Biomes.FORET.getNom()){
            isgoodPosition = this.setPosition(rand.nextInt(10), rand.nextInt(4));
            while(isgoodPosition == false || !this.isEmpty(mapwrld)){
                isgoodPosition = this.setPosition(rand.nextInt(10), rand.nextInt(4));
            }
            return this;
        }else if (bio.getName() == Biomes.PLAINE.getNom()){
            isgoodPosition = this.setPosition(rand.nextInt(10), rand.nextInt(5) + 4);
            while(isgoodPosition == false || !this.isEmpty(mapwrld)){
                isgoodPosition = this.setPosition(rand.nextInt(10), rand.nextInt(5) + 4);
            }
            return this;
        }else if (bio.getName() == Biomes.MER.getNom()){
            isgoodPosition = this.setPosition(rand.nextInt(10), 9);
            while(isgoodPosition == false || !this.isEmpty(mapwrld)){
                isgoodPosition = this.setPosition(rand.nextInt(10), 9);
            }
            return this;
        }
        System.out.println("erreur");
        return this;
    }
}