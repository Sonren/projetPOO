package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

/**
 * La classe Vegetal représente un élément végétal générique.
 */
public class Vegetal {

    /** Le nom du végétal. */
    private String name;

    /** Le biome dans lequel le végétal se trouve. */
    private Biome biome;

    /** La position du végétal sur la carte. */
    private Position position;

    /** Indique si le végétal est mort ou non. */
    private boolean isDeadveg = false;

    /** Le nombre de bois associé au végétal. */
    private int nbbois = 3;

    /**
     * Constructeur de la classe Vegetal.
     *
     * @param n Le nom du végétal.
     * @param b Le biome dans lequel le végétal se trouve.
     * @param p La position du végétal sur la carte.
     */
    public  Vegetal (String n, Biome b, Position p){
            this.name = n;
            this.biome = b;
            this.position = p;
    }

    /**
     * Obtient le nom du végétal.
     *
     * @return Le nom du végétal.
     */
    public String getname(){
        return this.name;
    }
    
    /**
     * Obtient le biome dans lequel le végétal se trouve.
     *
     * @return Le biome du végétal.
     */
    public Biome getbiome(){
        return this.biome;
    }

    /**
     * Obtient la position du végétal sur la carte.
     *
     * @return La position du végétal.
     */
    public Position getposition(){
        return this.position;
    }

    /**
     * Vérifie si le végétal est mort.
     *
     * @return True si le végétal est mort, sinon False.
     */
    public boolean isDeadveg(){
        return this.isDeadveg;
    }

    /**
     * Obtient le nombre de bois associé au végétal.
     *
     * @return Le nombre de bois associé au végétal.
     */
    public int getnbbois(){
        return this.nbbois;
    }

    /**
     * Définit le nom du végétal.
     *
     * @param nom Le nouveau nom du végétal.
     */
    public void setname (String nom){
        this.name = nom;
    }

    /**
     * Définit le biome dans lequel le végétal se trouve.
     *
     * @param bio Le nouveau biome du végétal.
     */
    public void setbiome (Biome bio){
        this.biome = bio;
    }

    /**
     * Définit la position du végétal sur la carte.
     *
     * @param emplacement La nouvelle position du végétal.
     */
    public void setposition (Position emplacement){
        this.position = emplacement;
    }

    /**
     * Définit si le végétal est mort ou non.
     *
     * @param deadv Indique si le végétal est mort.
     */
    public void setisDeadveg(boolean deadv){
        this.isDeadveg = deadv;
    }

    /**
     * Définit le nombre de bois associé au végétal.
     *
     * @param nb Le nouveau nombre de bois associé au végétal.
     */
    public void setnbbois(int nb){
        this.nbbois = nb;
    }
}

