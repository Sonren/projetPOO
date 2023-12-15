package Test;

import class_Animal.Animal;
import class_Biome.Biome;
import class_Biome.Plaine;
import class_Carte.Carte;
import class_Carte.Case;
import class_Carte.Position;

public class testCarte {

    public static void main(String[] args) {
        testGetX();
        testSetX();
        testGetY();
        testSetY();
        testSetPosition();
        testGetBiome();
        testSetBiome();
        testGetPosition();
        testSetIsVegetal();
        testGetIsVegetal();
        testSetIsAnimal();
        testGetIsAnimal();
        testGetIsRocher();
        testSetIsRocher();
        testIsChampi();
        testSetIsChampi();
        testIsHomme();
        testSetIsHomme();
        testGetMap();
        testSetMap();
        testGetNbtour();
        testSetNbtour();
        testAddTour();
        testGetMap();
        testSetMap();
        testGetNbtour();
        testSetNbtour();
        testAddTour();
        testPreserveFaune();
        testAddCase();
    }

    public static void testGetX() {
        Position pos = new Position(3, 5);
        if (pos.getX() == 3) {
            System.out.println("Test getX: Passed");
        } else {
            System.out.println("Test getX: Failed");
        }
    }

    public static void testSetX() {
        Position pos = new Position(3, 5);
        pos.setX(7, false);
        if (pos.getX() == 7) {
            System.out.println("Test setX: Passed");
        } else {
            System.out.println("Test setX: Failed");
        }
    }

    public static void testGetY() {
        Position pos = new Position(3, 5);
        if (pos.getY() == 5) {
            System.out.println("Test getY: Passed");
        } else {
            System.out.println("Test getY: Failed");
        }
    }

    public static void testSetY() {
        Position pos = new Position(3, 5);
        pos.setY(8, false);
        if (pos.getY() == 8) {
            System.out.println("Test setY: Passed");
        } else {
            System.out.println("Test setY: Failed");
        }
    }

    public static void testSetPosition() {
        Position pos = new Position(3, 5);
        boolean result = pos.setPosition(2, 7);
        if (result && pos.getX() == 2 && pos.getY() == 7) {
            System.out.println("Test setPosition: Passed");
        } else {
            System.out.println("Test setPosition: Failed");
        }
    }

    public static void testGetBiome() {
        Case testCase = new Case();
        Biome testBiome = new Biome("TestBiome");
        testCase.setBiome(testBiome);
        if (testCase.getBiome() == testBiome) {
            System.out.println("Test getBiome: Passed");
        } else {
            System.out.println("Test getBiome: Failed");
        }
    }

    public static void testSetBiome() {
        Case testCase = new Case();
        Biome testBiome = new Biome("TestBiome");
        testCase.setBiome(testBiome);
        if (testCase.getBiome() == testBiome) {
            System.out.println("Test setBiome: Passed");
        } else {
            System.out.println("Test setBiome: Failed");
        }
    }

    public static void testGetPosition() {
        Case testCase = new Case();
        Position testPosition = new Position(1, 2);
        testCase.setPosition(testPosition);
        if (testCase.getPosition() == testPosition) {
            System.out.println("Test getPosition: Passed");
        } else {
            System.out.println("Test getPosition: Failed");
        }
    }

    public static void testSetIsVegetal() {
        Case testCase = new Case();
        testCase.setisvegetal(true);
        if (testCase.getisvegetal()) {
            System.out.println("Test setisvegetal: Passed");
        } else {
            System.out.println("Test setisvegetal: Failed");
        }
    }

    public static void testGetIsVegetal() {
        Case testCase = new Case();
        testCase.setisvegetal(true);
        if (testCase.getisvegetal()) {
            System.out.println("Test getisvegetal: Passed");
        } else {
            System.out.println("Test getisvegetal: Failed");
        }
    }

    public static void testSetIsAnimal() {
        Case testCase = new Case();
        testCase.setisanimal(true);
        if (testCase.getisanimal()) {
            System.out.println("Test setisanimal: Passed");
        } else {
            System.out.println("Test setisanimal: Failed");
        }
    }

    public static void testGetIsAnimal() {
        Case testCase = new Case();
        testCase.setisanimal(true);
        if (testCase.getisanimal()) {
            System.out.println("Test getisanimal: Passed");
        } else {
            System.out.println("Test getisanimal: Failed");
        }
    }

    public static void testGetIsRocher() {
        Case testCase = new Case();
        testCase.setisrocher(true);
        if (testCase.getisrocher()) {
            System.out.println("Test getisrocher: Passed");
        } else {
            System.out.println("Test getisrocher: Failed");
        }
    }

    public static void testSetIsRocher() {
        Case testCase = new Case();
        testCase.setisrocher(true);
        if (testCase.getisrocher()) {
            System.out.println("Test setisrocher: Passed");
        } else {
            System.out.println("Test setisrocher: Failed");
        }
    }

    public static void testIsChampi() {
        Case testCase = new Case();
        testCase.setischampi(true);
        if (testCase.ischampi()) {
            System.out.println("Test ischampi: Passed");
        } else {
            System.out.println("Test ischampi: Failed");
        }
    }

    public static void testSetIsChampi() {
        Case testCase = new Case();
        testCase.setischampi(true);
        if (testCase.ischampi()) {
            System.out.println("Test setischampi: Passed");
        } else {
            System.out.println("Test setischampi: Failed");
        }
    }

    public static void testIsHomme() {
        Case testCase = new Case();
        testCase.setisHomme(true);
        if (testCase.isHomme()) {
            System.out.println("Test isHomme: Passed");
        } else {
            System.out.println("Test isHomme: Failed");
        }
    }

    public static void testSetIsHomme() {
        Case testCase = new Case();
        testCase.setisHomme(true);
        if (testCase.isHomme()) {
            System.out.println("Test setisHomme: Passed");
        } else {
            System.out.println("Test setisHomme: Failed");
        }
    }

    public static void testGetMap() {
        Case[][] testMap = new Case[10][10];
        Carte testCarte = new Carte(testMap, 0);
        if (testCarte.getMap() == testMap) {
            System.out.println("Test getMap: Passed");
        } else {
            System.out.println("Test getMap: Failed");
        }
    }

    public static void testSetMap() {
        Case[][] testMap = new Case[10][10];
        Carte testCarte = new Carte(testMap, 0);
        Case[][] newMap = new Case[5][5];
        testCarte.setMap(newMap);
        if (testCarte.getMap() == newMap) {
            System.out.println("Test setMap: Passed");
        } else {
            System.out.println("Test setMap: Failed");
        }
    }

    public static void testGetNbtour() {
        Carte testCarte = new Carte(new Case[10][10], 5);
        if (testCarte.getNbtour() == 5) {
            System.out.println("Test getNbtour: Passed");
        } else {
            System.out.println("Test getNbtour: Failed");
        }
    }

    public static void testSetNbtour() {
        Carte testCarte = new Carte(new Case[10][10], 0);
        testCarte.setNbtour(10);
        if (testCarte.getNbtour() == 10) {
            System.out.println("Test setNbtour: Passed");
        } else {
            System.out.println("Test setNbtour: Failed");
        }
    }

    public static void testAddTour() {
        Carte testCarte = new Carte(new Case[10][10], 0);
        testCarte.addtour();
        if (testCarte.getNbtour() == 1) {
            System.out.println("Test addTour: Passed");
        } else {
            System.out.println("Test addTour: Failed");
        }
    }

    public static void testPreserveFaune() {
        Case[][] testMap = new Case[10][10];
        Carte testCarte = new Carte(testMap, 0);

        // Créer une faune fictive pour le test
        Biome testBiome = new Plaine("Plaine");
        Animal testAnimal = new Animal("Vache", 20, 10, new Position(1, 1), testBiome);
        testBiome.addAnimaux(testAnimal);
        testMap[1][1].setisanimal(true);

        // Appeler la méthode et vérifier si la faune est préservée
        testCarte.preservefaune();

        if (testBiome.getfaune().size() == 1 && testMap[1][1].getisanimal()) {
            System.out.println("Test preserveFaune: Passed");
        } else {
            System.out.println("Test preserveFaune: Failed");
        }
    }

    public static void testAddCase() {
        Case[][] testMap = new Case[10][10];
        Carte testCarte = new Carte(testMap, 0);

        // Créer une nouvelle case pour ajouter
        Case newCase = new Case();
        newCase.setPosition(new Position(2, 2));

        // Appeler la méthode et vérifier si la case est ajoutée
        testCarte.addcase(newCase);

        if (testCarte.getMap()[2][2] == newCase) {
            System.out.println("Test addCase: Passed");
        } else {
            System.out.println("Test addCase: Failed");
        }
    }
}