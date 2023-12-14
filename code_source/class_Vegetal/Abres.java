package class_Vegetal;

public enum Abres {
  CHENE("chêne"),
  CERISIER("cerisier"),
  BANANIER("bananier"),
  BOULEAU("bouleau");

  private final String nom;

  Abres(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}