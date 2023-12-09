package class_Biome;

public class Foret extends Biome {
    private int nbrochers;
    private int nbchampignons;
    
    public Foret(String nom) {
        super(nom);
        this.nbrochers = 0;
        this.nbchampignons =0;
    }

    public void addRocher(int quantity, int maxRochers) {
        if (nbrochers + quantity <= maxRochers) {
            nbrochers += quantity;
            System.out.println("Ajout de " + quantity + " rochers dans la forêt. Il y a maintenant " + nbrochers + " rochers.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de rochers que le nombre maximum autorisé (" + maxRochers + ").");
        }
    }
    
    public void addChampignons(int quantity, int maxChampignons) {
        if (nbchampignons + quantity <= maxChampignons) {
            nbchampignons += quantity;
            System.out.println("Ajout de " + quantity + " champignons dans la forêt. Il y a maintenant " + nbchampignons + " champignons.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de champignons que le nombre maximum autorisé (" + maxChampignons + ").");
    }
    }
}