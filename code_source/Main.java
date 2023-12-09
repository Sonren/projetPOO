import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Tool.Axe;
import Tool.Spear;
import Tool.Tool;
import class_Animal.Animal;
import class_Biome.Biome;
import class_Vegetal.Vegetal;

public class Main {










































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
/* 
public class Test {
 public static void main(String[] args) {
        // Test de la classe Biome
        testBiome();
    }

    public static void testBiome() {
        // Création d'un biome
        Biome biome = new Biome("Forêt Amazonienne");

        // Création d'animaux et de plantes pour les tests
        Animal lion = new Animal("Lion");
        Animal tigre = new Animal("Tigre");
        Vegetal arbre = new Vegetal("Chêne");
        Vegetal fleur = new Vegetal("Rose");

        // Test des méthodes de la classe Biome
        biome.addAnimaux(lion);
        biome.addAnimaux(tigre);
        biome.addPlante(arbre);
        biome.addPlante(fleur);

        // Affichage de la faune et de la flore
        biome.afficheFaune();
        biome.afficheFlore();

        // Retrait d'un animal et d'une plante
        biome.removeAnimal(tigre);
        biome.removePlante(fleur);

        // Affichage mis à jour de la faune et de la flore
        biome.afficheFaune();
        biome.afficheFlore();
    }
}
*/