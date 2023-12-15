package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

/**
 * La classe Arbrefruit représente un type spécifique d'arbre qui produit des fruits.
 * Elle étend la classe Arbre.
 */
public class Arbrefruit extends Arbre {

    /** Le nombre de fruits sur l'arbre. */
    private int nbfruit;

    /**
     * Constructeur de la classe Arbrefruit.
     *
     * @param n Le nom de l'arbre fruitier.
     * @param b Le biome dans lequel l'arbre fruitier se trouve.
     * @param p La position de l'arbre fruitier sur la carte.
     */
    public Arbrefruit (String n,Biome b, Position p){
        super (n,b,p);
        this.nbfruit = 5;
    }

    /**
     * Obtient le nombre de fruits sur l'arbre fruitier.
     *
     * @return Le nombre de fruits sur l'arbre fruitier.
     */
    public int getnbfruit(){
        return this.nbfruit;
    }

    
    /**
     * Définit le nombre de fruits sur l'arbre fruitier.
     *
     * @param fr Le nouveau nombre de fruits sur l'arbre fruitier.
     */
    public void setnbfruit(int fr){
        this.nbfruit = fr;
    }  
}