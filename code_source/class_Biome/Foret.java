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
        this.nbrochers = 100;
        this.nbchampignons =100;
    }

   /**
     * Vérifie si le nombre de rochers est inférieur à 50 et en ajoute 50, si c'est le cas.
     */
    public void addRocher() {
        if (nbrochers < 50) {
            nbrochers = nbrochers + 50;
            System.out.println("Ajout de rochers dans la forêt.");
        }
    }
    
    /**
     * Vérifie si le nombre de rochers est inférieur à 50 et en ajoute 50, si c'est le cas.
     */
    public void addChampignons() {
        if (nbchampignons < 50) {
            nbchampignons = nbchampignons + 50;
            System.out.println("Ajout de champignons dans la forêt.");
        }
    }

     public void setchampi(int r){
        this.nbchampignon = r;
    }

    public int getchampi(){
        return this.nbchampignon;
    }

    public void addchampignon(int r){
        this.nbchampignon += r;
    }

    public void removechampi(int r){
        this.nbchampignon -= r;
    }
}