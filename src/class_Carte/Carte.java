package class_Carte;


import java.util.ArrayList;

import class_Animal.Animal;
import class_Animal.Animaux_carnivore;
import class_Animal.Animaux_herbivore;
import class_Animal.Animaux_omnivore;
import class_Animal.Diet;
import class_Animal.Homme.Homme;
import class_Biome.Biome;
import class_Biome.Plaine;
import class_Vegetal.Abres;
import class_Vegetal.Arbre;
import class_Vegetal.Arbrefruit;
import class_Vegetal.Rocher;
import class_Vegetal.Rochers;
import class_Vegetal.Vegetal;

public class Carte {

    private Case[][] map = new Case[10][10];
    private int nbtour;
    ArrayList<Animal> killedAnimals = new ArrayList<Animal>();;

    
    public Carte (Case[][] m, int nb){
        this.map = m;
        this.nbtour = nb;
    }

    //getters et setters
    public Case[][] getMap() {
        return this.map;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }

    public int getNbtour() {
        return this.nbtour;
    }

    public void setNbtour(int nbtour) {
        this.nbtour = nbtour;
    }

    public void addtour (){
        this.nbtour += 1;
    }
   
    public void preservefaune (){
        //TODO
    }

    public ArrayList<Animal> getKillesAnimal(){
        return this.killedAnimals;
    }

    public void addKilledAnimal(Animal animalKilled){
        this.getKillesAnimal().add(animalKilled);
    }

    public Case[][] addcase(Case cas) {
       map[cas.getPosition().getX()][cas.getPosition().getY()] = cas;
       return map;
    }

    /**
     * fonction qui va crée l'animal avec des caractéristique spéciale en fonction de son alimentation de son biome. Chaque animaux ont une position de base généré aléatoirement
     * @param diet définie le régime alimentaire de l'animal (Herbivore, Carnivore, Omnivore)
     * @param animale nom de l'animal (stocké dans les énumération dans le classe animal)
     * @param world plateau de jeu sur lequel les animaux vont être placé aléatoirement
     * @param bio le biome auquel appartienent les animaux (stoké dans l'énumération Biomes)
     * @param strg force de l'animal car deux animaux identique peuvent avoir une force différente
     * @return l'animal crée avec tout ces paramètre, on a bien vérifier que l'animal est dans le bon biome et a une position aléatoire
     */
    public Animal addanimal(String diet, String animale , Case[][] world, Biome bio, int strg){
        Animal pet; 
        Position posi = new Position(0, 0);
        if (diet == Diet.HERBIVORE.getNom()){
            if (animale == Animaux_herbivore.VACHE.getNom()){
                pet = new Animal(Animaux_herbivore.VACHE.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addherbivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.HERBIVORE.getNom() + " et c'est un(e) " + Animaux_herbivore.VACHE.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            }else if (animale == Animaux_herbivore.ZEBRE.getNom()){
                pet = new Animal(Animaux_herbivore.ZEBRE.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addherbivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.HERBIVORE.getNom() + " et c'est un(e) " + Animaux_herbivore.ZEBRE.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            } else if (animale == Animaux_herbivore.MOUTON.getNom()){
                pet = new Animal(Animaux_herbivore.MOUTON.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addherbivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.HERBIVORE.getNom() + " et c'est un(e) " + Animaux_herbivore.MOUTON.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            } else if (animale == Animaux_herbivore.ELEPHANT.getNom()){
                pet = new Animal(Animaux_herbivore.ELEPHANT.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                bio.addAnimaux(pet);
                pet.addherbivore(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.HERBIVORE.getNom() + " et c'est un(e) " + Animaux_herbivore.ELEPHANT.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            } else if (animale == Animaux_herbivore.SINGE.getNom()){
                pet = new Animal(Animaux_herbivore.SINGE.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addherbivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.HERBIVORE.getNom() + " et c'est un(e) " + Animaux_herbivore.SINGE.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            }
        }else if (diet == Diet.CARNIVORE.getNom()){ 
            if (animale == Animaux_carnivore.LION.getNom()){
                pet = new Animal(Animaux_carnivore.LION.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addcarnivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.CARNIVORE.getNom() + " et c'est un(e) " + Animaux_carnivore.LION.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            } else if (animale == Animaux_carnivore.LOUP.getNom()){
                pet = new Animal(Animaux_carnivore.LOUP.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addcarnivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.CARNIVORE.getNom() + " et c'est un(e) " + Animaux_carnivore.LOUP.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            }
        }else if (animale == Animaux_omnivore.OURS.getNom()){
            if (animale == Animaux_omnivore.OURS.getNom()){
                pet = new Animal (Animaux_omnivore.OURS.getNom(), 20, strg, posi = posi.ramdomPosition(bio, world), bio);
                pet.addomnivore(pet);
                bio.addAnimaux(pet);
                world[posi.getX()][posi.getY()].setisanimal(true);
                System.out.println("l'animal est " + Diet.OMNIVORE.getNom() + " et c'est un(e) " + Animaux_omnivore.OURS.getNom() + " position = x: " + pet.getposition().getX() + " y: " + pet.getposition().getY() + "\n");
                return pet;
            }
        }
        return pet = null;
    }

    public Homme addHomme(Biome bio, Case[][] map, String nom, int f){
        Homme human;
        Position posi = new Position(0, 0);
        human = new Homme(Animaux_omnivore.HUMAIN.getNom(), 60, f, posi = posi.ramdomPosition(bio, map), bio);
        human.addomnivore(human);
        bio.addAnimaux(human);
        map[posi.getX()][posi.getY()].setisanimal(true);
        System.out.println("l'animal est " + Diet.OMNIVORE.getNom() + " et c'est un(e) " + Animaux_omnivore.HUMAIN.getNom() + " position = x: " + human.getposition().getX() + " y: " + human.getposition().getY() + "\n");
        return human;
    }

    /**
     * fonction 
     * @param bio
     * @param map
     * @param name
     * @return
     */
    public Vegetal addarbre(Biome bio, Case[][] map, String name){
        Vegetal veg;
        Position posi = new Position(0, 0);
        if (name == Abres.CHENE.getNom()){
            veg = new Arbre(Abres.CHENE.getNom(), bio, posi = posi.ramdomPosition(bio, map));
            bio.addPlante(veg);
            map[posi.getX()][posi.getY()].setisvegetal(true);
            System.out.println("l'arbre est un " + Abres.CHENE.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + veg.getposition().getX() + " y: " + veg.getposition().getY() + "\n");
            return veg;
        }else if (name == Abres.BANANIER.getNom()){
            veg = new Arbrefruit(Abres.BANANIER.getNom(), bio, posi = posi.ramdomPosition(bio, map));
            bio.addPlante(veg);
            map[posi.getX()][posi.getY()].setisvegetal(true);
            System.out.println("l'arbre est un " + Abres.BANANIER.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + veg.getposition().getX() + " y: " + veg.getposition().getY() + "\n");
            return veg;
        }else if (name == Abres.CERISIER.getNom()){
            veg = new Arbrefruit(Abres.CERISIER.getNom(), bio, posi = posi.ramdomPosition(bio, map));
            bio.addPlante(veg);
            map[posi.getX()][posi.getY()].setisvegetal(true);
            System.out.println("l'arbre est un " + Abres.CERISIER.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + veg.getposition().getX() + " y: " + veg.getposition().getY() + "\n");
            return veg;
        }else if (name == Abres.BOULEAU.getNom()){
            veg = new Arbre(Abres.BOULEAU.getNom(), bio, posi = posi.ramdomPosition(bio, map));
            bio.addPlante(veg);
            map[posi.getX()][posi.getY()].setisvegetal(true);
            System.out.println("l'arbre est un " + Abres.BOULEAU.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + veg.getposition().getX() + " y: " + veg.getposition().getY() + "\n");
            return veg;
        }
        return veg = null;
    }

    public Rocher addrocher(Biome bio, Case[][] world, String nom){
        Rocher rock;
        Position posi = new Position(0, 0);
        if (nom == Rochers.CAILLOUX.getNom()){
            rock = new Rocher(posi = posi.ramdomPosition(bio, map), bio, 5, Rochers.CAILLOUX.getNom());
            bio.addRocher(rock);
            map[posi.getX()][posi.getY()].setisrocher(true);
            ((Plaine) bio).setnbrocher(((Plaine) bio).getnbrocher() + 1);
            System.out.println("le rocher est un " + Rochers.CAILLOUX.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + rock.getposition().getX() + " y: " + rock.getposition().getY() + "\n");
            return rock;
        }else if (nom == Rochers.GROS_CAILLOUX.getNom()){
            rock = new Rocher(posi = posi.ramdomPosition(bio, map), bio, 10, Rochers.GROS_CAILLOUX.getNom());
            bio.addRocher(rock);
            map[posi.getX()][posi.getY()].setisrocher(true);
            ((Plaine) bio).setnbrocher(((Plaine) bio).getnbrocher() + 1);
            System.out.println("le rocher est un " + Rochers.GROS_CAILLOUX.getNom() + " il se situe dans le biome : " + bio.getName() + " position = x: " + rock.getposition().getX() + " y: " + rock.getposition().getY() + "\n");
            return rock;
        }
        return rock = null;
    }

    public void randommvtAllAnimaux (Biome bio1, Biome bio2){
        for (Animal ani : bio1.getfaune()){ 
            if(!(ani instanceof Homme)){
                if (!ani.isDead()) {
                    ani.move(this.map);
                } else {
                    System.out.println("************************************************");
                    System.out.println("animal mort");
                    System.out.println("************************************************");
                }
            }
        }
        for (Animal deadani : bio1.getfaune()){
            if (deadani.isDead()) {
                this.addKilledAnimal(deadani);
            }
        }
        for (Animal killedAnimal : this.getKillesAnimal()) {
            bio1.getfaune().remove(killedAnimal);
        }
        for (Animal ani : bio2.getfaune()){ 
            if(!(ani instanceof Homme)){
                if (!ani.isDead()) {
                    ani.move(this.map);
                } else {
                    System.out.println("************************************************");
                    System.out.println("animal mort");
                    System.out.println("************************************************");
                }
            }
        }
        for (Animal deadani : bio2.getfaune()){
            if (deadani.isDead()) {
                this.addKilledAnimal(deadani);
            }
        }
        for (Animal killedAnimal : this.getKillesAnimal()) {
            bio2.getfaune().remove(killedAnimal);
        }
    }

}
