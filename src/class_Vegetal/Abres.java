package class_Vegetal;

/**
 * L'énumération Arbres représente différents types d'arbres (chene, cerisier, bananier, bouleau)
 */
public enum Abres {


  CHENE("chêne"),
  CERISIER("cerisier"),
  BANANIER("bananier"),
  BOULEAU("bouleau");

  private final String nom;

  /**
   * Constructeur de l'énumération Arbres.
   *
   * @param nom Le nom de l'arbre.
   */
  Abres(String nom) {
    this.nom = nom;
  }

  /**
   * Obtient le nom de l'arbre.
   *
   * @return Le nom de l'arbre.
   */
  public String getNom() {
    return nom;
  }
}