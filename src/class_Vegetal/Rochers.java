package class_Vegetal;

/**
 * L'énumération Rochers représente différents types de rochers (cailloux et gros cailloux).
 */
public enum Rochers {

  
  GROS_CAILLOUX("gros cailloux"),
  CAILLOUX("cailoux");

  /**
   * Le nom du rocher.
   */
  private final String nom;

  /**
   * Constructeur de l'énumération Rochers.
   *
   * @param nom Le nom du rocher.
   */
  Rochers(String nom) {
    this.nom = nom;
  }

   /**
   * Obtient le nom du rocher.
   *
   * @return Le nom du rocher.
   */
  public String getNom() {
    return nom;
  }
}