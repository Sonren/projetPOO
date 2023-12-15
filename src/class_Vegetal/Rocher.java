package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

/**
 * La classe Rocher représente un élément naturel sous la forme d'un rocher.
 */
public class Rocher {

    /** La position du rocher sur la carte. */
    private Position pos;

    /** Le biome dans lequel le rocher se trouve. */
    private Biome bio;

    /** Le nombre de cailloux dans le rocher. */
    private int nbcailloux;

    /** Le nom du rocher. */
    private String nom;

    /** Indique si le rocher est mort ou non. */
    private boolean isDeadroc = false;
    
    /**
     * Constructeur de la classe Rocher.
     *
     * @param pos      La position du rocher sur la carte.
     * @param bio      Le biome dans lequel le rocher se trouve.
     * @param r        Le nombre de cailloux dans le rocher.
     * @param nom      Le nom du rocher.
     */
    public Rocher(Position pos, Biome bio, int r, String nom) {
        this.pos = pos;
        this.bio = bio;
        this.nbcailloux = r;
        this.nom = nom;
    }

    /**
     * Obtient la position du rocher sur la carte.
     *
     * @return La position du rocher.
     */
    public Position getposition() {
        return this.pos;
    }

    /**
     * Définit la position du rocher sur la carte.
     *
     * @param pos La nouvelle position du rocher.
     */
    public void setposition(Position pos) {
        this.pos = pos;
    }

    /**
     * Obtient le biome dans lequel le rocher se trouve.
     *
     * @return Le biome du rocher.
     */
    public Biome getBio() {
        return this.bio;
    }

    /**
     * Définit le biome dans lequel le rocher se trouve.
     *
     * @param bio Le nouveau biome du rocher.
     */
    public void setBio(Biome bio) {
        this.bio = bio;
    }

    /**
     * Définit si le rocher est mort ou non.
     *
     * @param rok Indique si le rocher est mort.
     */
    public void setisDeadroc(boolean rok){
        this.isDeadroc = rok;
    }

    
    /**
     * Vérifie si le rocher est mort.
     *
     * @return True si le rocher est mort, sinon False.
     */
    public boolean isDeadroc(){
        return this.isDeadroc;
    }

    /**
     * Obtient le nombre de cailloux dans le rocher.
     *
     * @return Le nombre de cailloux dans le rocher.
     */
    public int getNbcailloux() {
        return this.nbcailloux;
    }

    /**
     * Définit le nombre de cailloux dans le rocher.
     *
     * @param nbcailloux Le nouveau nombre de cailloux dans le rocher.
     */
    public void setNbcailloux(int nbcailloux) {
        this.nbcailloux = nbcailloux;
    }

    
    /**
     * Obtient le nom du rocher.
     *
     * @return Le nom du rocher.
     */
    public String getname() {
        return this.nom;
    }

    /**
     * Définit le nom du rocher.
     *
     * @param nom Le nouveau nom du rocher.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
}