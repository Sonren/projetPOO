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
        testLooseLevelLife();
        testKilledAnimal();
        testIsHerbivore();
        testIsCarnivore();
        testIsOmnivore();

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

    public static void testAddHerbivore() {
        Biome testBiome = new Foret("Foret");
        testAnimal test = new testAnimal();
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        test.addherbivore(testAnimal);

        if (test.gethfaune().contains(testAnimal)) {
            System.out.println("Test addHerbivore: Passed");
        } else {
            System.out.println("Test addHerbivore: Failed");
        }
    }

    public static void testRemoveHerbivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new testAnimal();
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        test.addherbivore(testAnimal);
        test.removeherbivore(testAnimal);

        if (!test.gethfaune().contains(testAnimal)) {
            System.out.println("Test removeHerbivore: Passed");
        } else {
            System.out.println("Test removeHerbivore: Failed");
        }
    }

    public static void testAddCarnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Tigre", 60, 40, new Position(2, 2), testBiome);
        test.addcarnivore(testAnimal);

        if (test.getcfaune().contains(testAnimal)) {
            System.out.println("Test addCarnivore: Passed");
        } else {
            System.out.println("Test addCarnivore: Failed");
        }
    }

    public static void testRemoveCarnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Tigre", 60, 40, new Position(2, 2), testBiome);
        test.addcarnivore(testAnimal);
        test.removecarnivore(testAnimal);

        if (!test.getcfaune().contains(testAnimal)) {
            System.out.println("Test removeCarnivore: Passed");
        } else {
            System.out.println("Test removeCarnivore: Failed");
        }
    }

    public static void testAddOmnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Ours", 70, 50, new Position(3, 3), testBiome);
        test.addomnivore(testAnimal);

        if (test.getofaune().contains(testAnimal)) {
            System.out.println("Test addOmnivore: Passed");
        } else {
            System.out.println("Test addOmnivore: Failed");
        }
    }

    public static void testRemoveOmnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Ours", 70, 50, new Position(3, 3), testBiome);
        test.addomnivore(testAnimal);
        test.removeomnivore(testAnimal);

        if (!test.getofaune().contains(testAnimal)) {
            System.out.println("Test removeOmnivore: Passed");
        } else {
            System.out.println("Test removeOmnivore: Failed");
        }
    }

    public static void testLooseLevelLife() {
        Biome testBiome = new Foret("Foret");
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        testAnimal.looselevellife(20);

        if (testAnimal.getlevellife() == 30) {
            System.out.println("Test looseLevelLife: Passed");
        } else {
            System.out.println("Test looseLevelLife: Failed");
        }
    }

    public static void testKilledAnimal() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        test.killedAnimal(testAnimal);

        if (testAnimal.isDead()) {
            System.out.println("Test killedAnimal: Passed");
        } else {
            System.out.println("Test killedAnimal: Failed");
        }
    }

    public static void testIsHerbivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Lion", 50, 30, new Position(1, 1), testBiome);
        test.addherbivore(testAnimal);

        if (testAnimal.isHerbivore()) {
            System.out.println("Test isHerbivore: Passed");
        } else {
            System.out.println("Test isHerbivore: Failed");
        }
    }

    public static void testIsCarnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Tigre", 60, 40, new Position(2, 2), testBiome);
        test.addcarnivore(testAnimal);

        if (testAnimal.isCarnivore()) {
            System.out.println("Test isCarnivore: Passed");
        } else {
            System.out.println("Test isCarnivore: Failed");
        }
    }

    public static void testIsOmnivore() {
        Biome testBiome = new Foret("Foret");
        Animal test = new Animal("loup", 50, 50, new Position(2, 1), testBiome);
        Animal testAnimal = new Animal("Ours", 70, 50, new Position(3, 3), testBiome);
        test.addomnivore(testAnimal);

        if (testAnimal.isOmnivore()) {
            System.out.println("Test isOmnivore: Passed");
        } else {
            System.out.println("Test isOmnivore: Failed");
        }
    }
}
