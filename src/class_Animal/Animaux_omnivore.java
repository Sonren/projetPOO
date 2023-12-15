package class_Animal;

//enumeration des animaux omnivore
public enum Animaux_omnivore {
  OURS("ours"),
  HUMAIN("humain");

  private final String nom;

  Animaux_omnivore(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}