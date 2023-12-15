package Test;

import java.util.Scanner;
import class_Animal.Homme.Homme;
import class_Animal.Homme.Inventaire;
import class_Animal.Animal;
import class_Animal.Homme.Axe;
import class_Animal.Homme.Pickaxe;
import class_Animal.Homme.Tool;
import class_Biome.Biome;
import class_Carte.Case;
import class_Carte.Position;
import class_Vegetal.Arbre;
import class_Vegetal.Rocher;
import class_Vegetal.Vegetal;

public class testHomme {

    public static void main(String[] args) {
        testGetInvent();
        testSetInvent();
        testDemandeUtilisateur();
        testDemandeUtilisateurStr();
        testIsValidCoordinate();
        testIsEmpty();
        testGoodBiomeHuman();
        testHasTool();
        testFindTool();
        testFindVegetal();
        testFindRock();
        testFindAnimal();
        testMinerWithPickaxe();
        testMinerWithoutPickaxe();
    }

    public static void testGetInvent() {
        testHomme test = new testHomme();
        Position position_Homme = new Position(1, 1);
        Biome biome_homme = new Biome("Forest");
        Homme homme = new Homme("Francice", 30, 20, position_Homme, biome_homme);

        if (test.getInvent(homme) != null) {
            System.out.println("Test getInvent: Passed");
        } else {
            System.out.println("Test getInvent: Failed");
        }
    }

    public static void testSetInvent() {
        testHomme test = new testHomme();
        Position position_Homme = new Position(1, 1);
        Biome biome_homme = new Biome("Forest");
        Homme homme = new Homme("Francice", 30, 20, position_Homme, biome_homme);
        Inventaire inventaire = new Inventaire(1, 2, 3, 4, null);

        test.setInvent(homme, inventaire);

        if (test.getInvent(homme) == inventaire) {
            System.out.println("Test setInvent: Passed");
        } else {
            System.out.println("Test setInvent: Failed");
        }
    }

    public static void testDemandeUtilisateur() {
        testHomme test = new testHomme();
        Position position_Homme = new Position(1, 1);
        Biome biome_homme = new Biome("Forest");
        Homme homme = new Homme("Francice", 30, 20, position_Homme, biome_homme);
        Scanner scanner = new Scanner(System.in);

        boolean answer = test.demandeUtilisateur("Continue?", scanner);

        System.out.println("User's answer: " + answer);
    }

    public static void testDemandeUtilisateurStr() {
        testHomme test = new testHomme();
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Scanner scanner = new Scanner(System.in);

        String answer = test.demandeUtilisateurstr("Enter your name:", scanner);

        System.out.println("User's answer: " + answer);
    }

    public static void testIsValidCoordinate() {
        testHomme test = new testHomme();
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));

        if (test.isValidCoordinate(5)) {
            System.out.println("Test isValidCoordinate: Passed");
        } else {
            System.out.println("Test isValidCoordinate: Failed");
        }
    }

    private Inventaire getInvent(Homme homme) {
        return homme.getInvent();
    }

    private void setInvent(Homme homme, Inventaire inventaire) {
        homme.setInvent(inventaire);
    }

    private boolean demandeUtilisateur(String message, Scanner scanner) {
        return new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest")).demandeUtilisateur(message, scanner);
    }

    private String demandeUtilisateurstr(String message, Scanner scanner) {
        return new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest")).demandeUtilisateurstr(message, scanner);
    }

    private boolean isValidCoordinate(int value) {
        return new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest")).isValidCoordinate(value);
    }

    public static void testIsEmpty() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Case[][] map = new Case[10][10];

        // Assuming the map is initialized properly
        boolean result = homme.isEmpty(map, new Position(2, 2));

        if (result) {
            System.out.println("Test isEmpty: Passed");
        } else {
            System.out.println("Test isEmpty: Failed");
        }
    }

    public static void testGoodBiomeHuman() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Biome plain = new Biome("Plain");
        Biome forest = new Biome("Forest");

        homme.GoodBiomehuman(new Position(1, 5), plain, forest);

        // Manually verify the output in the console
    }

    public static void testHasTool() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Tool axe = new Axe("Axe");

        // Assuming the inventaire is initialized properly
        homme.getInvent().ajouterOutil(axe);

        boolean result = homme.hasTool("Hache");

        if (result) {
            System.out.println("Test hasTool: Passed");
        } else {
            System.out.println("Test hasTool: Failed");
        }
    }

    public static void testFindTool() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Axe axe = new Axe("Axe");
        homme.getInvent().ajouterOutil(axe);

        Tool result = homme.findTool(homme.getInvent(), "Axe");

        if (result != null && result instanceof Axe) {
            System.out.println("Test findTool: Passed");
        } else {
            System.out.println("Test findTool: Failed");
        }
    }

    public static void testFindVegetal() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Biome forest = new Biome("Forest");
        Vegetal tree = new Arbre("Chêne", forest, new Position(1, 2));

        // Assuming the biome's flore is initialized properly
        forest.addPlante(tree);

        Vegetal result = homme.findVegetal(new Position(1, 2), new Case[10][10], forest);

        if (result != null && result instanceof Arbre) {
            System.out.println("Test findVegetal: Passed");
        } else {
            System.out.println("Test findVegetal: Failed");
        }
    }

    public static void testFindRock() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Biome forest = new Biome("Forest");
        Rocher rock = new Rocher(new Position(1, 2), forest, 10, "Gros Caillou");

        // Assuming the biome's geologie is initialized properly
        forest.addRocher(rock);

        Rocher result = homme.findRock(new Position(1, 2), new Case[10][10], forest);

        if (result != null && result instanceof Rocher) {
            System.out.println("Test findRock: Passed");
        } else {
            System.out.println("Test findRock: Failed");
        }
    }

    public static void testFindAnimal() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Biome forest = new Biome("Forest");
        Animal animal = new Animal("Lion", 50, 30, new Position(1, 2), forest);

        // Assuming the biome's faune is initialized properly
        forest.addAnimaux(animal);

        Animal result = homme.findAnimal(new Position(1, 2), new Case[10][10], forest);

        if (result != null && result instanceof Animal) {
            System.out.println("Test findAnimal: Passed");
        } else {
            System.out.println("Test findAnimal: Failed");
        }
    }
    
    public static void testMinerWithPickaxe() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Rocher rock = new Rocher(new Position(1, 2), new Biome("Forest"), 5, "Gros Caillou");
        Pickaxe pickaxe = new Pickaxe("Pioche");
        homme.getInvent().ajouterOutil(pickaxe);
    
        Case[][] map = new Case[10][10];
        map[1][2] = new Case();
        map[1][2].setisrocher(true);
    
        homme.miner(rock, map, new Position(1, 2));
    
        if (homme.getInvent().getQtecailloux() == 5 && !map[1][2].getisrocher()) {
            System.out.println("Test minerWithPickaxe: Passed");
         } else {
            System.out.println("Test minerWithPickaxe: Failed");
        }
    }
    
    public static void testMinerWithoutPickaxe() {
        Homme homme = new Homme("John", 30, 20, new Position(1, 1), new Biome("Forest"));
        Rocher rock = new Rocher(new Position(1, 2), new Biome("Forest"), 5, "Gros Caillou");
    
        Case[][] map = new Case[10][10];
         map[1][2] = new Case();
        map[1][2].setisrocher(true);
    
        homme.miner(rock, map, new Position(1, 2));
    
        if (homme.getInvent().getQtecailloux() == 5 && !map[1][2].getisrocher() && homme.getlevellife() == 25) {
            System.out.println("Test minerWithoutPickaxe: Passed");
        } else {
            System.out.println("Test minerWithoutPickaxe: Failed");
        }
    }
}
