package class_Biome;
/**
 * La classe Plaine représente un type de biome spécifique.
 * Elle étend la classe Biome 
 * */
public class Plaine extends Biome {

    /**
     * Le nombre de rochers dans la plaine
     */
    private int nbrochers;

    /**
     * Constructeur de la classe Plaine.
     * 
     * @param nom Le nom de la plaine 
     */
    public Plaine(String nom) {
        super(nom);
        this.nbrochers = 0;
    }

    /**
     * Ajpoute une quantité spécifiée de rochers à la plaine, sous réserve de ne pas dépasser la limite maximale.
     * 
     * @param quantity La quantité de rochers à ajouter.
     * @param maxRochers Le nombre maximum autorisé de rochers dans la plaine.
     */
    public void addRocher(int quantity, int maxRochers) {
        if (nbrochers + quantity <= maxRochers) {
            nbrochers += quantity;
            System.out.println("Ajout de " + quantity + " rochers à la plaine. Il y a maintenant " + nbrochers + " rochers.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de rochers que le nombre maximum autorisé (" + maxRochers + ").");
        }
    }
}