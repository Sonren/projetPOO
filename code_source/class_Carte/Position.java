package class_Carte;

import java.util.Random;

import class_Biome.Biome;
import class_Biome.Biomes;

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

    public void setX(int x, boolean isWrongPosition) {
        isWrongPosition = false;
        if (x < 0 || x > 9){
            System.out.println("position hors le carte");
            isWrongPosition = true;
            System.out.println(isWrongPosition);
        } else {
            this.x = x;
        }
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y, boolean isWrongPosition) {
        isWrongPosition = false;
        if (y < 0 || y > 9){
            System.out.println("position hors le carte");
            isWrongPosition = true;
            System.out.println(isWrongPosition); 
        } else {
            this.y = y;
        }
    }

    public void setPosition (int x, int y, boolean isWrongPosition){
        isWrongPosition = false;
        if (y < 0 || y > 9 && x < 0 || x > 9){
            System.out.println("position hors de la carte");
            isWrongPosition = true;
        }else{
            System.out.println("position changé");
            this.x = x;
            this.y = y;
        }
        
    }

    public boolean isEmpty (Position pos, Case[][] map){
        boolean empty = false;
        if(map[pos.getX()][pos.getY()].getisanimal()){
            return empty;
        }else if (map[pos.getX()][pos.getY()].getisvegetal()){
            return empty;
        }else if (map[pos.getX()][pos.getY()].getisrocher()){
            return empty;
        }else{
            empty = true;
            return empty;
        }
    }

    public Position ramdomPosition(Biome bio, Case[][] mapwrld){
        Random rand = new Random();
        boolean WrongPosition = false;
        if (bio.getName() == Biomes.FORET.getNom()){
            this.setPosition(rand.nextInt(10), rand.nextInt(4), WrongPosition);
            while(WrongPosition == true || !isEmpty(this, mapwrld)){
                this.setPosition(rand.nextInt(10), rand.nextInt(4), WrongPosition);
            }
            return this;
        }else if (bio.getName() == Biomes.PLAINE.getNom()){
            this.setPosition(rand.nextInt(10), rand.nextInt(5) + 4, WrongPosition);
            while(WrongPosition == true || !isEmpty(this, mapwrld)){
                this.setPosition(rand.nextInt(10), rand.nextInt(5) + 4, WrongPosition);
            }
            return this;
        }else if (bio.getName() == Biomes.MER.getNom()){
            this.setPosition(rand.nextInt(10), 9, WrongPosition);
            while(WrongPosition == true || !isEmpty(this, mapwrld)){
                this.setPosition(rand.nextInt(10), 9, WrongPosition);
            }
            return this;
        }
        System.out.println("erreur");
        return this;
    }

}