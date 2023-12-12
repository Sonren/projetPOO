package class_Carte;

import class_Animal.Animal;

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
        if(x<0|| x>9 ){
            System.out.println("la valeur de x n'est pas bonne. rentrez des coordonnées entres 0 et 9");
            isWrongPosition =true;
            System.out.println(isWrongPosition);
    
        } else{
        this.x = x;
        } 
    }

    public int getY() {
        return this.y;
    }
public void setY(int y, boolean isWrongPosition) {
        isWrongPosition = false;
        if(y < 0 || y > 9 ){
            System.out.println("la valeur de y n'est pas bonne. rentrez des coordonnées entres 0 et 9");
            isWrongPosition =true;
            System.out.println(isWrongPosition);
    
        } else{
        this.y= y;
        } 
    }

public void setPosition(int x, int y , boolean isWrongPosition){
    isWrongPosition = false;
    if( y < 0 || y > 9 && x < 0 || x > 9 ){
        System.out.println("La position est hors de la carte");
        isWrongPosition = true;
    } else{
        System.out.println("La position a changé");
        this.x = x;
        this.y =y ;
    } 
} 


 public boolean isEmpty(Position pos, Case [][] map  ){
        if(pos.x < 0|| pos.x >= map.length|| pos.y <0|| pos.y>= map[0].length){
            return false;
        } 
        return true;
        /* 
        for(Animal anAnimal : desAnimaux){
            if(anAnimal.getposition().equals(p)){ // Un animal est dans la case
                return false;
            } 
        } 
        // la case est occupé par l'homme
        if(homme.getposition().equals(p)){
            return false;
        } 
        // La case n'est occupé ni par l'homme ni par un animal
        return true; 
        */
   }
}

