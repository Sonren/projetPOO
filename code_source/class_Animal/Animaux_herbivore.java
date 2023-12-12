package fr.lynchmaniac.class_Animal;

public enum Animaux_herbivore {
  VACHE("vache"),
  MOUTON("mouton"),
  SINGE("singe"),
  ELEPHANT("éléphant"),
  ZEBRE("zèbre");

  private final String nom;

  Animaux_herbivore(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}