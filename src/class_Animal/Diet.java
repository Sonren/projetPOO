package class_Animal;

public enum Diet {
  HERBIVORE("herbivore"),
  CARNIVORE("carnivore"),
  OMNIVORE("omnivore");

  private final String nom;

  Diet(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}