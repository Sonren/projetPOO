    package class_Animal.Homme;

    //enumeration de tous les outils
    public enum Tools {
    HACHE("hache"),
    LANCE("lance"),
    PIOCHE("pioche");

    private final String nom;

    Tools(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    }