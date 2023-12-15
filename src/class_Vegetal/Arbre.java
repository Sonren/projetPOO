package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

/**
 * La classe Arbre représente un type spécifique de végétal, un arbre.
 */
public class Arbre extends Vegetal{

    /** La hauteur de l'arbre. */
    private int hauteur = 0;

    /**
     * Constructeur de la classe Arbre.
     *
     * @param n Le nom de l'arbre.
     * @param b Le biome dans lequel l'arbre se trouve.
     * @param p La position de l'arbre sur la carte.
     */
    public Arbre (String n, Biome b, Position p){
        super(n,b,p);
    }

    /**
     * Obtient la hauteur de l'arbre.
     *
     * @return La hauteur de l'arbre.
     */
    public int gethauteur (){
        return this.hauteur;
    }

    /**
     * Définit la hauteur de l'arbre.
     *
     * @param h La nouvelle hauteur de l'arbre.
     */
    public void setnbbois (int h){
        this.hauteur = h;
    }


}