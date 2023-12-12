package fr.lynchmaniac;

//import fr.lynchmaniac.initialisation;
import fr.lynchmaniac.class_Carte.Carte;
import fr.lynchmaniac.class_Carte.Case;
import fr.lynchmaniac.class_Carte.Position;
import fr.lynchmaniac.class_Vegetal.Abres;
import fr.lynchmaniac.class_Vegetal.Arbre;
import fr.lynchmaniac.class_Vegetal.Rocher;
import fr.lynchmaniac.class_Vegetal.Rochers;
import fr.lynchmaniac.class_Vegetal.Vegetal;
import fr.lynchmaniac.class_Animal.Animal;
import fr.lynchmaniac.class_Animal.Animaux_carnivore;
import fr.lynchmaniac.class_Animal.Animaux_herbivore;
import fr.lynchmaniac.class_Animal.Animaux_omnivore;
import fr.lynchmaniac.class_Animal.Diet;
import fr.lynchmaniac.class_Animal.Herbivore;
import fr.lynchmaniac.class_Biome.Biome;
import fr.lynchmaniac.class_Biome.Biomes;
import fr.lynchmaniac.class_Biome.Foret;
import fr.lynchmaniac.class_Biome.Mer;
import fr.lynchmaniac.class_Biome.Plaine;

public class Main
{
    public static void main( String[] args )
    {
        //System.out.println( "Hell0 !" );
        initialisationjeu();
        creationvie();
        
    }

    public static void initialisationjeu() {
      System.out.println("lancement du jeu" + "\n ");
      //creationvie();
    
    }

    public static Carte creationCarte (Case[][] mapwrld, int t, Biome plaine, Biome foret, Biome mer){
      Carte gmap;
      Case c;
      gmap = new Carte (mapwrld, t);
      //remplissage de chaque case avec sa position et son biome
      for (int i = 0; i< 10; i = i+1 ){  //peut etre probleme sur les indices
          for (int j = 0; j< 10; j = j+1) {
            c= new Case();
            if (i <= 4) {
              c.setBiome(foret);
            } else if ((i >= 5  && i < 9)) {
              c.setBiome(plaine);
            } else {
              c.setBiome(mer);
            }
            c.setPosition(new Position(i, j));
            mapwrld = gmap.addcase(c);
          }
      }
      return gmap;
    }

    public static void creationvie(){
      Carte mapworld;
      Case[][] mapmonde = new Case[10][10];
      int turn = 0;
      Biome pl = new Plaine(Biomes.PLAINE.getNom());
      Biome f = new Foret(Biomes.FORET.getNom());
      Biome m = new Mer(Biomes.MER.getNom());
      Animal loup1, loup2, singe1, singe2, singe3, elephant, ours, mouton1, mouton2, mouton3, lion1, lion2, vache1, vache2, vache3, vache4, vache5, zebre1, zebre2;
      Vegetal chene1, chene2, chene3, chene4, chene5, chene6, chene7, chene8, chene9, chene10, bananier1, bananier2, bananier3, bananier4, bananier5, bouleau1, bouleau2, bouleau3, bouleau4, bouleau5, cerisier1, cerisier2, cerisier3, cerisier4, cerisier5;
      Rocher cailloux1, cailloux2, cailloux3, cailloux4, cailloux5, groscailloux1, groscailloux2, groscailloux3, groscailloux4, groscailloux5;
      mapworld = creationCarte(mapmonde, turn, pl, f, m);
      affichemap(mapmonde);
      loup1 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LOUP.getNom(),mapmonde, f, 8);
      loup2 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LOUP.getNom(),mapmonde, f, 7);
      singe1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.SINGE.getNom(),mapmonde, f, 0);
      singe2 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.SINGE.getNom(),mapmonde, f, 0);
      singe3 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.SINGE.getNom(),mapmonde, f, 0);
      elephant = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.ELEPHANT.getNom(),mapmonde, f, 0);
      ours = mapworld.addanimal(Diet.OMNIVORE.getNom(), Animaux_omnivore.OURS.getNom(),mapmonde, f, 12);
      mouton1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(),mapmonde, pl, 0);
      mouton2 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(),mapmonde, pl, 0);
      mouton3 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(),mapmonde, pl, 0);
      lion1 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LION.getNom(),mapmonde, pl, 10);
      lion2 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LION.getNom(),mapmonde, pl, 11);
      vache1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.VACHE.getNom(),mapmonde, pl, 0);
      vache2 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.VACHE.getNom(),mapmonde, pl, 0);
      vache3 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.VACHE.getNom(),mapmonde, pl, 0);
      vache4 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.VACHE.getNom(),mapmonde, pl, 0);
      vache5 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.VACHE.getNom(),mapmonde, pl, 0);
      zebre1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.ZEBRE.getNom(),mapmonde, pl, 0);
      zebre2 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.ZEBRE.getNom(),mapmonde, pl, 0);
      chene1 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene2 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene3 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene4 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene5 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene6 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene7 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene8 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene9 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      chene10 = mapworld.addarbre(f, mapmonde, Abres.CHENE.getNom());
      bananier1 = mapworld.addarbre(f, mapmonde, Abres.BANANIER.getNom());
      bananier2 = mapworld.addarbre(f, mapmonde, Abres.BANANIER.getNom());
      bananier3 = mapworld.addarbre(f, mapmonde, Abres.BANANIER.getNom());
      bananier4 = mapworld.addarbre(f, mapmonde, Abres.BANANIER.getNom());
      bananier5 = mapworld.addarbre(f, mapmonde, Abres.BANANIER.getNom());
      bouleau1 = mapworld.addarbre(pl, mapmonde, Abres.BOULEAU.getNom());
      bouleau2 = mapworld.addarbre(pl, mapmonde, Abres.BOULEAU.getNom());
      bouleau3 = mapworld.addarbre(pl, mapmonde, Abres.BOULEAU.getNom());
      bouleau4 = mapworld.addarbre(pl, mapmonde, Abres.BOULEAU.getNom());
      bouleau5 = mapworld.addarbre(pl, mapmonde, Abres.BOULEAU.getNom());
      cerisier1 = mapworld.addarbre(pl, mapmonde, Abres.CERISIER.getNom());
      cerisier2 = mapworld.addarbre(pl, mapmonde, Abres.CERISIER.getNom());
      cerisier3 = mapworld.addarbre(pl, mapmonde, Abres.CERISIER.getNom());
      cerisier4 = mapworld.addarbre(pl, mapmonde, Abres.CERISIER.getNom());
      cerisier5 = mapworld.addarbre(pl, mapmonde, Abres.CERISIER.getNom());
      cailloux1 = mapworld.addrocher(pl, mapmonde, Rochers.CAILLOUX.getNom());
      cailloux2 = mapworld.addrocher(pl, mapmonde, Rochers.CAILLOUX.getNom());
      cailloux3 = mapworld.addrocher(pl, mapmonde, Rochers.CAILLOUX.getNom());
      cailloux4 = mapworld.addrocher(pl, mapmonde, Rochers.CAILLOUX.getNom());
      cailloux5 = mapworld.addrocher(pl, mapmonde, Rochers.CAILLOUX.getNom());
      groscailloux1 = mapworld.addrocher(pl, mapmonde, Rochers.GROS_CAILLOUX.getNom());
      groscailloux2 = mapworld.addrocher(pl, mapmonde, Rochers.GROS_CAILLOUX.getNom());
      groscailloux3 = mapworld.addrocher(pl, mapmonde, Rochers.GROS_CAILLOUX.getNom());
      groscailloux4 = mapworld.addrocher(pl, mapmonde, Rochers.GROS_CAILLOUX.getNom());
      groscailloux5 = mapworld.addrocher(pl, mapmonde, Rochers.GROS_CAILLOUX.getNom());
      pl.afficheFaune(pl);
      f.afficheFaune(f);
      pl.afficheFlore();
      f.afficheFlore();
      pl.affichegeologie();

      mapworld.randommvtAllAnimaux(pl);
      mapworld.randommvtAllAnimaux(f);
      
      
      
      /*lion1 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LION.getNom(), mapmonde, pl, new Position(2, 7), 20);
      lion2 = mapworld.addanimal(Diet.CARNIVORE.getNom(), Animaux_carnivore.LION.getNom(), mapmonde, pl, new Position(3, 7), 10);
      lion1.droite(lion1, mapmonde);
      System.out.println(Animaux_carnivore.LION.getNom() + " se situe a la position x = " + lion1.getposition().getX() + " y = " + lion1.getposition().getY());
      mouton1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(), mapmonde, pl, new Position(3, 6), 0);
      lion1.haut(lion1, mapmonde);
      System.out.println(Animaux_carnivore.LION.getNom() + " se situe a la position x = " + lion1.getposition().getX() + " y = " + lion1.getposition().getY());
      mouton1 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(), mapmonde, pl, new Position(3, 4), 0);
      mouton2 = mapworld.addanimal(Diet.HERBIVORE.getNom(), Animaux_herbivore.MOUTON.getNom(), mapmonde, pl, new Position(4, 4), 0);
      mouton1.droite(mouton1, mapmonde);
      System.out.println(Animaux_herbivore.MOUTON.getNom() + " se situe a la position x = " + mouton1.getposition().getX() + " y = " + mouton1.getposition().getY());
      System.out.println(Animaux_herbivore.MOUTON.getNom() + " se situe a la position x = " + mouton2.getposition().getX() + " y = " + mouton2.getposition().getY());
      //pl.afficheFlore();
      //f.afficheFlore();
      //pl.afficheFaune();
      //f.afficheFaune();
      //pl.affichegeologie();
      ((Foret) f).setchampi(2);
      //System.out.println(Animaux_herbivore.MOUTON.getNom() + " se situe a la position x = " + mouton1.getposition().getX() + " y = " + mouton1.getposition().getY()); 
      */
    }

  public static void affichemap (Case[][] map){
      //Case c;
      Position p;
      int x;
      int y;
      for(int a = 0; a < 10; a = a + 1){
          for(int b = 0; b < 10; b = b + 1){
              //c = map[a][b];
              p = map[a][b].getPosition();
              x = p.getX();
              y = p.getY();
          }
      }
  }

}





































 /*static void checkAge(int age) {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
      System.out.println("coucou");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

public static void main(String[] args) {

    for (String item : args) {
      try {
          checkAge(15); // Set age to 15 (which is below 18...)

          Axe axe1 = new Axe();
          axe1.setForce(5);
          axe1.setMaterial("");
          Axe axe2 = new Axe("Bois");
          Axe axe3 = new Axe();

          List<Axe> axes = new ArrayList<Axe>();
          axes.add(axe1);
          axes.add(axe2);
          axes.add(axe3);

          for (Axe axe : axes) {
            System.out.println(axe.getLife());
            System.out.println(axe.getMaterial());
          }

          Spear spear1 = new Spear();
          Spear spear2 = new Spear();
          Spear spear3 = new Spear();
          
          List<Tool> spears = new ArrayList<Tool>();
          spears.add(spear1);
          spears.add(spear2);
          spears.add(spear3);

          List<Tool> tools = new ArrayList<Tool>();
          tools.add(axe1);
          tools.add(spear1);
          tools.add(axe2);
          tools.add(spear2);
          tools.add(axe3);
          tools.add(spear3);


          List<Tool> footballeurs = tools.stream()
            .filter(p -> p instanceof Axe)
            .map(p -> (Axe) p)
            .collect(Collectors.toList());

          List<Tool> footballeurs2 = new ArrayList<>();
          for (Tool spear : spears) {
            System.out.println(spear.getLife());
            if (spear instanceof Spear) {
              System.out.println(((Spear) spear).getReach());
            } else {
              System.out.println(((Axe) spear).getMaterial());
            }
          }
          
          //pour les cin
          Scanner s=new Scanner(System.in);
          String mot = s.nextLine();  

  }
} */

