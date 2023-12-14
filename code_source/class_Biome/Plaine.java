package class_Biome;

/**
 * La classe Plaine représente un type de biome spécifique.
 * Elle étend la classe abstraite Biome.
 */
public class Plaine extends Biome {

    /**
     * Le nombre de rochers dans la plaine.
     */
    private int nbrochers;

    /**
     * Constructeur de la classe Plaine.
     *
     * @param nom Le nom de la plaine.
     */
    public Plaine(String nom) {
        super(nom);
        this.nbrochers = 100;
    }

    /**
     * Vérifie si le nombre de rochers est inférieur à 50 et en ajoute 50, si c'est le cas.
     */
    public void addRocher() {
        if (nbrochers < 50) {
            nbrochers = nbrochers + 50;
            System.out.println("Ajout de rochers à la plaine.");
        }
    }

    /**
     * Définit le nombre de rochers dans la forêt.
     *
     * @param r Le nouveau nombre de rochers.
     */
    public void setnbrocher (int r){
        this.nbrochers = r;
    }

    /**
     * Obtient le nombre actuel de rochers dans la forêt.
     *
     * @return Le nombre de rochers dans la forêt.
     */
    public int getnbrocher(){
        return this.nbrochers;
    }

    /**
     * Retire un nombre spécifié de rochers de la forêt.
     *
     * @param r Le nombre de rochers à retirer.
     */
    public void removerocher(int r){
        this.nbrochers -= r;
    }
}