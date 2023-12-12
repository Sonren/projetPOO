package class_Biome;

public enum Biomes {
  FORET("fôret"),
  PLAINE("plaine"),
  MER("mer");

  private final String nom;

  Biomes(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }
}
