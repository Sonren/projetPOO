package class_Vegetal;

import class_Biome.Biome;
import class_Carte.Position;

public class Rocher {

    private Position pos;
    private Biome bio;
    private int nbcailloux;
    private String nom;
    
    
    public Rocher(Position pos, Biome bio, int r, String nom) {
        this.pos = pos;
        this.bio = bio;
        this.nbcailloux = r;
        this.nom = nom;
    }

    public Position getPos() {
        return this.pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public Biome getBio() {
        return this.bio;
    }

    public void setBio(Biome bio) {
        this.bio = bio;
    }

    public int getNbcailloux() {
        return this.nbcailloux;
    }

    public void setNbcailloux(int nbcailloux) {
        this.nbcailloux = nbcailloux;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}