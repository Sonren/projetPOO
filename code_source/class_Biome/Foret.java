package class_Biome;

/**
 * La classe Foret représente un type de biome forestier.
 * Elle étend la classe Biome.
 */
public class Foret extends Biome {

    /**
     * Le nombre de rochers dans la forêt.
     */
    private int nbrochers;

    /**
     * Le nombre de champignons dans la forêt.
     */
    private int nbchampignons;

    /**
     * Constructeur de la classe Foret.
     * 
     * @param nom Le nom de la forêt.
     */
    public Foret(String nom) {
        super(nom);
        this.nbrochers = 0;
        this.nbchampignons =0;
    }

    /**
     * Ajoute une quantité spécifiée de rochers à la forêt, sous réserve de ne pas dépasser la limite maximale.
     * 
     * @param quantity La quantité de rochers à ajouter.
     * @param maxRochers Le nombre maximum autorisé de rochers dans la forêt.
     */
    public void addRocher(int quantity, int maxRochers) {
        if (nbrochers + quantity <= maxRochers) {
            nbrochers += quantity;
            System.out.println("Ajout de " + quantity + " rochers dans la forêt. Il y a maintenant " + nbrochers + " rochers.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de rochers que le nombre maximum autorisé (" + maxRochers + ").");
        }
    }
    
    /**
     * Ajoute une quantité spécifiée de champignons à la forêt, sous réserve de ne pas dépasser la limite maximale.
     * 
     * @param quantity La quantité de rochers à ajouter.
     * @param maxChampignons Le nombre maximum autorisé de rochers dans la forêt. 
     */
    public void addChampignons(int quantity, int maxChampignons) {
        if (nbchampignons + quantity <= maxChampignons) {
            nbchampignons += quantity;
            System.out.println("Ajout de " + quantity + " champignons dans la forêt. Il y a maintenant " + nbchampignons + " champignons.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de champignons que le nombre maximum autorisé (" + maxChampignons + ").");
    }
    }
}