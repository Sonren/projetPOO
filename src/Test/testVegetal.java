package Test;

import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Abres;
import class_Vegetal.Vegetal;
import class_Vegetal.Arbre;
import class_Vegetal.Arbrefruit;
import class_Vegetal.Rocher;
import class_Vegetal.Rochers;

public class testVegetal {

    public static void main(String[] args) {
        testGetters();
        testSetters();
        testGetNom();
        testGetHauteur();
        testGetname();
        testGetBiome();
        testGetPosition();
        testIsDeadveg();
        testGetnbbois();
        testSetnbbois();
        testGetnbfruit();
        testSetnbfruit();
        testGetposition();
        testSetposition();
        testGetBio();
        testSetBio();
        testSetisDeadroc();
        testIsDeadroc();
        testGetNbcailloux();
        testSetNbcailloux();
        testGetnamerock();
        testSetNom();
        testGetNomrock();
    }

    public static void testGetters() {
        Biome biome = new Biome("TestBiome");
        Position position = new Position(1, 2);
        Vegetal vegetal = new Vegetal("TestVegetal", biome, position);

        if ("TestVegetal".equals(vegetal.getname()) &&
            biome.equals(vegetal.getbiome()) &&
            position.equals(vegetal.getposition()) &&
            !vegetal.isDeadveg() &&
            2 == vegetal.getnbbois()) {
            System.out.println("Test Getters: Passed");
        } else {
            System.out.println("Test Getters: Failed");
        }
    }

    public static void testSetters() {
        Biome biome = new Biome("TestBiome");
        Position position = new Position(1, 2);
        Vegetal vegetal = new Vegetal("TestVegetal", biome, position);

        vegetal.setname("NewTestVegetal");
        if ("NewTestVegetal".equals(vegetal.getname())) {
            System.out.println("Test Setters (setName): Passed");
        } else {
            System.out.println("Test Setters (setName): Failed");
        }

        Biome newBiome = new Biome("NewTestBiome");
        vegetal.setbiome(newBiome);
        if (newBiome.equals(vegetal.getbiome())) {
            System.out.println("Test Setters (setBiome): Passed");
        } else {
            System.out.println("Test Setters (setBiome): Failed");
        }

        Position newPosition = new Position(3, 4);
        vegetal.setposition(newPosition);
        if (newPosition.equals(vegetal.getposition())) {
            System.out.println("Test Setters (setPosition): Passed");
        } else {
            System.out.println("Test Setters (setPosition): Failed");
        }

        vegetal.setisDeadveg(true);
        if (vegetal.isDeadveg()) {
            System.out.println("Test Setters (setIsDeadVeg): Passed");
        } else {
            System.out.println("Test Setters (setIsDeadVeg): Failed");
        }

        vegetal.setnbbois(5);
        if (5 == vegetal.getnbbois()) {
            System.out.println("Test Setters (setNbBois): Passed");
        } else {
            System.out.println("Test Setters (setNbBois): Failed");
        }
    }

    public static void testGetNom() {
        if ("chêne".equals(Abres.CHENE.getNom()) &&
            "cerisier".equals(Abres.CERISIER.getNom()) &&
            "bananier".equals(Abres.BANANIER.getNom()) &&
            "bouleau".equals(Abres.BOULEAU.getNom())) {
            System.out.println("Test getNom: Passed");
        } else {
            System.out.println("Test getNom: Failed");
        }
    }

    
    public static void testGetHauteur() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        if (arbre.gethauteur() == 0) {
            System.out.println("Test getHauteur: Passed");
        } else {
            System.out.println("Test getHauteur: Failed");
        }
    }
    
    public static void testGetname() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        if ("Chêne".equals(arbre.getname())) {
            System.out.println("Test getname: Passed");
        } else {
            System.out.println("Test getname: Failed");
        }
    }
    
    public static void testGetBiome() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        if ("Forêt".equals(arbre.getbiome().getName())) {
            System.out.println("Test getBiome: Passed");
        } else {
            System.out.println("Test getBiome: Failed");
        }
    }
    
    public static void testGetPosition() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        Position position = arbre.getposition();
        if (position.getX() == 1 && position.getY() == 2) {
            System.out.println("Test getPosition: Passed");
        } else {
            System.out.println("Test getPosition: Failed");
        }
    }
    
    public static void testIsDeadveg() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        if (!arbre.isDeadveg()) {
            System.out.println("Test isDeadveg: Passed");
        } else {
            System.out.println("Test isDeadveg: Failed");
        }
    }
    
    public static void testGetnbbois() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        if (arbre.getnbbois() == 2) {
            System.out.println("Test getnbbois: Passed");
        } else {
            System.out.println("Test getnbbois: Failed");
        }
    }
    
    public static void testSetnbbois() {
        Arbre arbre = new Arbre("Chêne", new Biome("Forêt"), new Position(1, 2));
        arbre.setnbbois(5);
        if (arbre.gethauteur() == 5) {
            System.out.println("Test setnbbois: Passed");
        } else {
            System.out.println("Test setnbbois: Failed");
        }
    }
    
    public static void testGetnbfruit() {
        Arbrefruit arbreFruit = new Arbrefruit("Bananier", new Biome("Forêt"), new Position(3, 4));
        if (arbreFruit.getnbfruit() == 10) {
            System.out.println("Test getnbfruit: Passed");
        } else {
            System.out.println("Test getnbfruit: Failed");
        }
    }
    
    public static void testSetnbfruit() {
        Arbrefruit arbreFruit = new Arbrefruit("Bananier", new Biome("Forêt"), new Position(3, 4));
        arbreFruit.setnbfruit(15);
        if (arbreFruit.getnbfruit() == 15) {
            System.out.println("Test setnbfruit: Passed");
        } else {
            System.out.println("Test setnbfruit: Failed");
        }
    }

    public static void testGetposition() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        if (rocher.getposition().getX() == 2 && rocher.getposition().getY() == 3) {
            System.out.println("Test getposition: Passed");
        } else {
            System.out.println("Test getposition: Failed");
        }
    }
    
    public static void testSetposition() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        rocher.setposition(new Position(4, 6));
        if (rocher.getposition().getX() == 4 && rocher.getposition().getY() == 6) {
            System.out.println("Test setposition: Passed");
        } else {
            System.out.println("Test setposition: Failed");
        }
    }
    
    public static void testGetBio() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        if (rocher.getBio().getName().equals("Montagne")) {
            System.out.println("Test getBio: Passed");
        } else {
            System.out.println("Test getBio: Failed");
        }
    }
    
    public static void testSetBio() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        rocher.setBio(new Biome("Colline"));
        if (rocher.getBio().getName().equals("Colline")) {
            System.out.println("Test setBio: Passed");
        } else {
            System.out.println("Test setBio: Failed");
        }
    }
    
    public static void testSetisDeadroc() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        rocher.setisDeadroc(true);
        if (rocher.isDeadroc()) {
            System.out.println("Test setisDeadroc: Passed");
        } else {
            System.out.println("Test setisDeadroc: Failed");
        }
    }
    
    public static void testIsDeadroc() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        if (!rocher.isDeadroc()) {
            System.out.println("Test isDeadroc: Passed");
        } else {
            System.out.println("Test isDeadroc: Failed");
         }
    }
    
    public static void testGetNbcailloux() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        if (rocher.getNbcailloux() == 5) {
            System.out.println("Test getNbcailloux: Passed");
        } else {
            System.out.println("Test getNbcailloux: Failed");
        }
    }
    
    public static void testSetNbcailloux() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        rocher.setNbcailloux(10);
        if (rocher.getNbcailloux() == 10) {
            System.out.println("Test setNbcailloux: Passed");
        } else {
            System.out.println("Test setNbcailloux: Failed");
        }
    }
    
    public static void testGetnamerock() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        if (rocher.getname().equals("Granite")) {
            System.out.println("Test getname: Passed");
        } else {
            System.out.println("Test getname: Failed");
        }
    }
    
    public static void testSetNom() {
        Rocher rocher = new Rocher(new Position(2, 3), new Biome("Montagne"), 5, "Granite");
        rocher.setNom("Marbre");
        if (rocher.getname().equals("Marbre")) {
            System.out.println("Test setNom: Passed");
        } else {
            System.out.println("Test setNom: Failed");
        }
    }
    
    public static void testGetNomrock() {
        Rochers grosCailloux = Rochers.GROS_CAILLOUX;
        if (grosCailloux.getNom().equals("gros cailloux")) {
            System.out.println("Test getNom (GROS_CAILLOUX): Passed");
        } else {
            System.out.println("Test getNom (GROS_CAILLOUX): Failed");
        }
    
        Rochers cailloux = Rochers.CAILLOUX;
        if (cailloux.getNom().equals("cailoux")) {
            System.out.println("Test getNom (CAILLOUX): Passed");
         } else {
            System.out.println("Test getNom (CAILLOUX): Failed");
        }
    }
}
    



