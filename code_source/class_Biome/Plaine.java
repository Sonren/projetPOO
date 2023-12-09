package class_Biome;

public class Plaine extends Biome {
    private int nbrochers;
    
    public Plaine(String nom) {
        super(nom);
        this.nbrochers = 0;
    }

    public void addRocher(int quantity, int maxRochers) {
        if (nbrochers + quantity <= maxRochers) {
            nbrochers += quantity;
            System.out.println("Ajout de " + quantity + " rochers à la plaine. Il y a maintenant " + nbrochers + " rochers.");
        } else {
            System.out.println("Erreur : Impossible d'ajouter plus de rochers que le nombre maximum autorisé (" + maxRochers + ").");
        }
    }
}