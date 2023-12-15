package class_Biome;

/**
 * La classe Mer représente un type de biome aquatique.
 * Elle étend la classe Biome
 */
public class Mer extends Biome {

    /*
     * La profondeur de la mer
     */
    private int profondeur;

    /**
     * Constructeur de la classe Mer.
     * 
     * @param nom nom de la mer.
     */
    public Mer(String nom){
        super(nom);
        this.profondeur = 5000;
    }

    /**
     * Obtient la profondeur actuelle de la mer.
     * 
     * @return La pronfondeur de la mer.
     */
    public int getProfondeur() {
        System.out.println(this.profondeur + "m");
        return this.profondeur;
    }

    /**
     * Modifie la pronfondeur de la mer avec la nouvelle valeur spécifiée.
     * 
     * @param newProfondeur La nouvelle profondeur de la mer.
     */
    public void setProfondeur(int newProfondeur) {
        if (newProfondeur >= 0) {
            this.profondeur = newProfondeur;
            System.out.println("Profondeur de la mer mise à jour : " + this.profondeur + "m");
        } else {
            System.out.println("Erreur : La profondeur de la mer ne peut pas être négative.");
        }
    }
}

