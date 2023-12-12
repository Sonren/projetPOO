package fr.lynchmaniac.class_Animal;

public enum Animaux_omnivore {
  OURS("ours");

  private final String nom;

  Animaux_omnivore(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}