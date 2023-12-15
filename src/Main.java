

import class_Carte.Carte;
import class_Carte.Case;
import class_Carte.Position;
import class_Vegetal.Abres;
import class_Vegetal.Rocher;
import class_Vegetal.Rochers;
import class_Vegetal.Vegetal;
import class_Animal.Animal;
import class_Animal.Animaux_carnivore;
import class_Animal.Animaux_herbivore;
import class_Animal.Animaux_omnivore;
import class_Animal.Diet;
import class_Animal.Homme.Homme;
import class_Biome.Biome;
import class_Biome.Biomes;
import class_Biome.Foret;
import class_Biome.Mer;
import class_Biome.Plaine;
import java.util.Scanner;

public class Main{
    public static void main( String[] args ) throws Exception
    {
      System.out.println("_____________________________________________________________________________________________________________________________" + "\n");
      System.out.println("lancement de la simulation");
      System.out.println("_____________________________________________________________________________________________________________________________" + "\n");
      Carte worldcart = new Carte(null, 0);
      Case[][] worldmap = new Case[10][10];
      int turn = 0;
      Biome plaine = new Plaine(Biomes.PLAINE.getNom());
      Biome forêt = new Foret(Biomes.FORET.getNom());
      Biome mer = new Mer(Biomes.MER.getNom());
      Scanner scanner = new Scanner(System.in);
      boolean launchgame = false;
      worldcart = creationCarte(worldmap, turn, plaine, forêt, mer);
      Homme jean = worldcart.addHomme(plaine, worldmap, Animaux_omnivore.HUMAIN.getNom(), 5);
      creationvie(worldcart, worldmap, plaine, forêt, mer, turn, jean);
      while (true) {
        try {
          System.out.println("Voulez-vous jouer au jeu? (oui: true / non: false)");
          launchgame = scanner.nextBoolean();
            break; 
        } catch (java.util.InputMismatchException e) {
          System.out.println("Entrée invalide. Veuillez entrer true ou false.");
          scanner.nextLine(); 
        }
      }
      if(launchgame){
        while(tour(plaine, forêt, worldcart, jean, scanner, worldmap)){
          turn = turn + 1;
        }
        scanner.close();
        System.exit(0);
      }else if (!(launchgame)){
        scanner.close();
        System.exit(0);
      } 
    }

    public static String demandeUtilisateur(String message){
      String answer;
      Scanner scanner =new Scanner(System.in);
      System.out.println(message); 
      answer = scanner.nextLine();
      scanner.close();
      return answer;
  }

    public static boolean tour (Biome plain, Biome forest, Carte map, Homme michel, Scanner scan, Case[][] tabCase){
      boolean iscontinue = true;
      System.out.println("\n");
      iscontinue = michel.actionHomme(scan, tabCase, plain, forest);
      map.randommvtAllAnimaux(plain, forest);
      return iscontinue;
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

    public static void creationvie(Carte mapworld, Case[][] mapmonde, Biome pl, Biome f, Biome m, int tour, Homme jean) throws Exception{
      Animal loup1, loup2, singe1, singe2, singe3, elephant, ours, mouton1, mouton2, mouton3, lion1, lion2, vache1, vache2, vache3, vache4, vache5, zebre1, zebre2;
      Vegetal chene1, chene2, chene3, chene4, chene5, chene6, chene7, chene8, chene9, chene10, bananier1, bananier2, bananier3, bananier4, bananier5, bouleau1, bouleau2, bouleau3, bouleau4, bouleau5, cerisier1, cerisier2, cerisier3, cerisier4, cerisier5;
      Rocher cailloux1, cailloux2, cailloux3, cailloux4, cailloux5, groscailloux1, groscailloux2, groscailloux3, groscailloux4, groscailloux5;
      System.out.println("création de la carte");
      System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
      mapworld = creationCarte(mapmonde, tour, pl, f, m);
      System.out.println("La carte a été créer");
      System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
      System.out.println("Ajout de la faune sur la carte");
      System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
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
     System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
     System.out.println("Ajout de la flore sur la carte");
     System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
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
     System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
     System.out.println("Ajout des rochers sur la carte");
     System.out.println("____________________________________________________________________________________________________________________________________" + "\n");
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
    }




}




