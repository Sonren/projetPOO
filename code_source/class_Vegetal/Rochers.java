package class_Vegetal;

public enum Rochers {
  GROS_CAILLOUX("gros cailloux"),
  CAILLOUX("cailoux");


  private final String nom;

  Rochers(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}
