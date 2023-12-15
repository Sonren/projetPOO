package Test;

import java.util.ArrayList;
import class_Animal.Animal;
import class_Biome.Biome;
import class_Biome.Foret;
import class_Biome.Plaine;
import class_Carte.Position;
import class_Animal.Animaux_carnivore;
import class_Animal.Animaux_herbivore;
import class_Animal.Animaux_omnivore;
import class_Animal.Diet;

public class testAnimal {

     public static void main(String[] args) {
        testGetName();
        testGetLevelLife();
        testGetStrength();
        testGetPosition();
        testGetBiome();
        testIsDead();
        testGetHerbivoreFaune();
        testGetCarnivoreFaune();
        testGetOmnivoreFaune();
        testSetName();
        testSetLevelLife();
        testSetStrength();
        testSetPosition();
        testSetBiome();
        testSetIsDead();
        testGetNomCar();
        testGetNomHerb();
        testGetNomOmni();
        testGetNom();
    }

     public static void testGetName() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (testAnimal.getname().equals("Lion")) {
            System.out.println("Test getName: Passed");
        } else {
            System.out.println("Test getName: Failed");
        }
    }

    public static void testGetLevelLife() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (testAnimal.getlevellife() == 50) {
            System.out.println("Test getLevelLife: Passed");
        } else {
            System.out.println("Test getLevelLife: Failed");
        }
    }

    public static void testGetStrength() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (testAnimal.getstrength() == 30) {
            System.out.println("Test getStrength: Passed");
        } else {
            System.out.println("Test getStrength: Failed");
        }
    }

    public static void testGetPosition() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (testAnimal.getposition().getX() == 1 && testAnimal.getposition().getY() == 1) {
            System.out.println("Test getPosition: Passed");
        } else {
            System.out.println("Test getPosition: Failed");
        }
    }

    public static void testGetBiome() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (testAnimal.getbiome().equals(testBiome)) {
            System.out.println("Test getBiome: Passed");
        } else {
            System.out.println("Test getBiome: Failed");
        }
    }

    public static void testIsDead() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);

        if (!testAnimal.isDead()) {
            System.out.println("Test isDead: Passed");
        } else {
            System.out.println("Test isDead: Failed");
        }
    }

    public static void testGetHerbivoreFaune() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        ArrayList<Animal> herbivoreFaune = new ArrayList<Animal>();

        if (testAnimal.gethfaune().equals(herbivoreFaune)) {
            System.out.println("Test getHerbivoreFaune: Passed");
        } else {
            System.out.println("Test getHerbivoreFaune: Failed");
        }
    }

    public static void testGetCarnivoreFaune() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        ArrayList<Animal> carnivoreFaune = new ArrayList<Animal>();

        if (testAnimal.getcfaune().equals(carnivoreFaune)) {
            System.out.println("Test getCarnivoreFaune: Passed");
        } else {
            System.out.println("Test getCarnivoreFaune: Failed");
        }
    }

    public static void testGetOmnivoreFaune() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        ArrayList<Animal> omnivoreFaune = new ArrayList<>();

        if (testAnimal.getofaune().equals(omnivoreFaune)) {
            System.out.println("Test getOmnivoreFaune: Passed");
        } else {
            System.out.println("Test getOmnivoreFaune: Failed");
        }
    }

    public static void testSetName() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.setname("Tigre");

        if (testAnimal.getname().equals("Tigre")) {
            System.out.println("Test setName: Passed");
        } else {
            System.out.println("Test setName: Failed");
        }
    }

    public static void testSetLevelLife() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.setlevellife(60);

        if (testAnimal.getlevellife() == 60) {
            System.out.println("Test setLevelLife: Passed");
        } else {
            System.out.println("Test setLevelLife: Failed");
        }
    }

    public static void testSetStrength() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.setstrenght(40);

        if (testAnimal.getstrength() == 40) {
            System.out.println("Test setStrength: Passed");
        } else {
            System.out.println("Test setStrength: Failed");
        }
    }

    public static void testSetPosition() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.setposition(new Position(2, 2));

        if (testAnimal.getposition().getX() == 2 && testAnimal.getposition().getY() == 2) {
            System.out.println("Test setPosition: Passed");
        } else {
            System.out.println("Test setPosition: Failed");
        }
    }

    public static void testSetBiome() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        Biome newBiome = new Plaine("Plaine");
        testAnimal.setbiome(newBiome);

        if (testAnimal.getbiome().equals(newBiome)) {
            System.out.println("Test setBiome: Passed");
        } else {
            System.out.println("Test setBiome: Failed");
        }
    }

    public static void testSetIsDead() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.setisDead(true);

        if (testAnimal.isDead()) {
            System.out.println("Test setIsDead: Passed");
        } else {
            System.out.println("Test setIsDead: Failed");
        }
    }
    
    public static void testGetNomCar() {
        testAnimal test = new testAnimal();
        Animaux_carnivore loup = Animaux_carnivore.LOUP;
    
        if (test.getNom(loup).equals("loup")) {
            System.out.println("Test GetNom: Passed");
        } else {
            System.out.println("Test GetNom: Failed");
        }
    }
    
    private String getNom(Animaux_carnivore animal) {
        return animal.getNom();
    }
   
    public static void testGetNomHerb() {
        testAnimal test = new testAnimal();
        Animaux_herbivore vache = Animaux_herbivore.VACHE;
    
        if (test.getNom(vache).equals("vache")) {
            System.out.println("Test GetNom: Passed");
        } else {
            System.out.println("Test GetNom: Failed");
        }
    }
    
    private String getNom(Animaux_herbivore animal) {
        return animal.getNom();
    }

    public static void testGetNomOmni() {
        testAnimal test = new testAnimal();
        Animaux_omnivore ours = Animaux_omnivore.OURS;

        if (test.getNom(ours).equals("ours")) {
            System.out.println("Test GetNom: Passed");
        } else {
            System.out.println("Test GetNom: Failed");
        }
    }

    private String getNom(Animaux_omnivore animal) {
        return animal.getNom();
    }

    public static void testGetNom() {
        testAnimal test = new testAnimal();
        Diet herbivore = Diet.HERBIVORE;
        Diet carnivore = Diet.CARNIVORE;
        Diet omnivore = Diet.OMNIVORE;

        if (test.getNom(herbivore).equals("herbivore") &&
            test.getNom(carnivore).equals("carnivore") &&
            test.getNom(omnivore).equals("omnivore")) {
            System.out.println("Test GetNom: Passed");
        } else {
            System.out.println("Test GetNom: Failed");
        }
    }

    private String getNom(Diet diet) {
        return diet.getNom();
    }
}