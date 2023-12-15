package class_Animal;

//enumeration des animaux carnivore
public enum Animaux_carnivore {
  LOUP("loup"),
  LION("lion");

  private final String nom;

  Animaux_carnivore(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}