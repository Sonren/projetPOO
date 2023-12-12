package Test;
import class_Animal.Animal;
import class_Biome.Biome;
import class_Biome.Foret;
import class_Biome.Mer;
import class_Biome.Plaine;
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
        Biome biome = new Biome("Biome Générique"));

        // Création d'animaux et de plantes pour les tests
        Animal mouton = new Animal("Mouton");
        Animal loup = new Animal("Loup");
        Vegetal arbre = new Vegetal("Chêne", "Foret", 5 5 );
        Vegetal fraisier = new Vegetal("Fraisier");

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

        // Création d'animaux et de plantes pour les tests
        Animal zebre = new Animal("Zèbre");
        Animal cochon = new Animal("Cochon");
        Vegetal baobab = new Vegetal("Baobab");
        Vegetal herbe = new Vegetal("Herbe");

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
        plaine.afficheRochers();
    }

    public static void testForet(){
        // Création d'une forêt
        Foret foret = new Foret("Forêt Sauvage");

        // Création d'animaux et de plantes pour les tests
        Animal singe = new Animal("Singe");
        Animal elephant = new Animal("Elephant");
        Vegetal chêne = new Vegetal("Chêne");
        Vegetal chataigner = new Vegetal("Châtaigner");

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
        foret.afficheRochers();
        foret.afficheChampignons();
    
    }

    public static void testMer(){
        // Création d'une mer
        Mer mer = new Mer("Mer Virulente");

        // Création d'animaux et de plantes pour les tests
        Animal poisson = new Animal("Poisson");
        Vegetal algue = new Vegetal("Algue");
        Vegetal corail = new Vegetal("Corail");

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
        mer.afficheProfondeur();
    }
    }

    
