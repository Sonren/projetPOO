package class_Biome;

public class Mer extends Biome {
    private int profondeur;

    public Mer(String nom){
        super(nom);
        this.profondeur = 0;
    }

    public int getProfondeur() {
        return this.profondeur;
    }

    public void setProfondeur(int newProfondeur) {
        if (newProfondeur >= 0) {
            this.profondeur = newProfondeur;
            System.out.println("Profondeur de la mer mise à jour : " + this.profondeur);
        } else {
            System.out.println("Erreur : La profondeur de la mer ne peut pas être négative.");
        }
    }
}

