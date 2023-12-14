package Test;
import class_Animal.Animal;
import class_Biome.Biome;
import class_Biome.Foret;
import class_Biome.Mer;
import class_Biome.Plaine;
import class_Carte.Position;
import class_Vegetal.Vegetal;

public class testBiomes {
    public static void main(String[] args){
        //Test de toutes les classes liées aux Biomes
        testBiome();
    }

    public static void testingBiomes(){
        //Test de la classe Biome
        testBiome();

        //Test de la classe Plaine
        testPlaine();

        //Test de la classe Foret
        testForet();

        //Test de la classe Mer
        testMer();
    }

    public static void testBiome(){

        // Création d'un biome
        Biome biome = new Biome("Biome Générique");

        // Création des positions
        Position position_Mouton = new Position(20, 78);
        Position position_Loup = new Position(55, 54);
        Position position_arbre = new Position(25, 55);
        Position position_fraisier = new Position(30, 60);

        // Création d'animaux et de plantes pour les tests
        Animal mouton = new Animal("Mouton", 20, 10, position_Mouton, biome);
        Animal loup = new Animal("Loup", 50, 45, position_Loup, biome );
        Vegetal arbre = new Vegetal("arbre", biome, position_arbre);
        Vegetal fraisier = new Vegetal("Fraisier", biome, position_fraisier);

        // Test des méthodes de la classe Biome
        biome.addAnimaux(mouton);
        biome.addAnimaux(loup);
        biome.addPlante(arbre);
        biome.addPlante(fraisier);

        // Affichage de la faune et de la flore
        biome.afficheFaune();
        biome.afficheFlore();

        // Retrait d'un animal et d'une plante
        biome.removeAnimal(mouton);
        biome.removePlante(arbre);

        // Affichage mis à jour de la faune et de la flore
        biome.afficheFaune();
        biome.afficheFlore();
    }

    public static void testPlaine(){

        // Création d'une plaine
        Plaine plaine = new Plaine("Plaine Hostile");

        // Création des positions
        Position position_Zebre = new Position(40, 50);
        Position position_Cochon = new Position(33, 21);
        Position position_Baobab = new Position(52, 44);
        Position position_Herbe = new Position(1, 10);

        // Création d'animaux et de plantes pour les tests
        Animal zebre = new Animal("Zèbre", 41, 35, position_Zebre, plaine);
        Animal cochon = new Animal("Cochon", 26, 20, position_Cochon, plaine);
        Vegetal baobab = new Vegetal("Baobab", plaine, position_Baobab);
        Vegetal herbe = new Vegetal("Herbe", plaine, position_Herbe);

        // Test des méthodes de la classe Biome (superclasse de Plaine)
        plaine.addAnimaux(zebre);
        plaine.addAnimaux(cochon);
        plaine.addPlante(baobab);
        plaine.addPlante(herbe);

        // Affichage de la faune et de la flore
        plaine.afficheFaune();
        plaine.afficheFlore();

        // Test des méthodes spécifiques de la classe Plaine
        plaine.addRocher();

        // Affichage mis à jour de la faune, de la flore et des rochers
        plaine.afficheFaune();
        plaine.afficheFlore();
    }

    public static void testForet(){

        // Création d'une forêt
        Foret foret = new Foret("Forêt Sauvage");

        // Création des positions
        Position position_Singe = new Position(70, 80);
        Position position_Elephant = new Position(55, 54);
        Position position_Chêne = new Position(65, 59);
        Position position_Chataigner = new Position(69, 80);

        // Création d'animaux et de plantes pour les tests
        Animal singe = new Animal("Singe", 80, 74, position_Singe, foret);
        Animal elephant = new Animal("Elephant", 200, 185, position_Elephant, foret);
        Vegetal chêne = new Vegetal("Chêne", foret, position_Chêne);
        Vegetal chataigner = new Vegetal("Châtaigner", foret, position_Chataigner);

        // Test des méthodes de la classe Biome (superclasse de Foret)
        foret.addAnimaux(singe);
        foret.addAnimaux(elephant);
        foret.addPlante(chêne);
        foret.addPlante(chataigner);

        // Affichage de la faune et de la flore
        foret.afficheFaune();
        foret.afficheFlore();

        // Test des méthodes spécifiques de la classe Foret
        foret.addRocher();
        foret.addChampignons();

        // Affichage mis à jour de la faune, de la flore, des rochers et des champignons
        foret.afficheFaune();
        foret.afficheFlore();
    }

    public static void testMer(){

        // Création d'une mer
        Mer mer = new Mer("Mer Virulente");

        // Création des positions
        Position position_poisson = new Position(15, 10);
        Position position_algue = new Position(35, 24);
        Position position_corail = new Position(12, 20);

        // Création d'animaux et de plantes pour les tests
        Animal poisson = new Animal("Poisson", 10, 1, position_poisson, mer);
        Vegetal algue = new Vegetal("Algue", mer, position_algue);
        Vegetal corail = new Vegetal("Corail", mer, position_corail);

        // Test des méthodes de la classe Biome (superclasse de Mer)
        mer.addAnimaux(poisson);
        mer.addPlante(algue);
        mer.addPlante(corail);

        // Affichage de la faune et de la flore
        mer.afficheFaune();
        mer.afficheFlore();

        // Test des méthodes spécifiques de la classe Mer
        mer.setProfondeur(6000);

        // Affichage mis à jour de la faune, de la flore et de la profondeur
        mer.afficheFaune();
        mer.afficheFlore();
    }
}

    
