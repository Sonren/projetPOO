package class_Biome;

/**
 * L'énumération Biomes représente les différents types de biomes.
 */
public enum Biomes {

 
  FORET("fôret"),
  PLAINE("plaine"),
  MER("mer");

  /**
   * Le nom du biome.
   */
  private final String nom;


  /**
   * Constructeur de l'énumération Biomes.
   *
   * @param nom Le nom du biome.
   */
  Biomes(String nom) {
    this.nom = nom;
  }

  /**
   * Obtient le nom du biome.
   *
   * @return Le nom du biome.
   */
  public String getNom() {
    return nom;
  }
}
