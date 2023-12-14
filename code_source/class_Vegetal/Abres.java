package class_Vegetal;

/**
 * L'énumération Arbres représente différents types d'arbres.
 */
public enum Abres {

  /**
   * Le chêne.
   */
  CHENE("chêne"),

  /**
   * Le cerisier.
   */
  CERISIER("cerisier"),

   /**
   * Le bananier.
   */
  BANANIER("bananier"),

  /**
   * Le bouleau.
   */
  BOULEAU("bouleau");

  /**
   * Le nom de l'arbre.
   */
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