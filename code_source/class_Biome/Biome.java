package class_Biome;

import java.util.ArrayList;
import class_Animal.Animal;
import class_Vegetal.Vegetal;

/**
 * La classe Biome représente un environnement naturel comprenant une faune et une flore.
 */
public class Biome {

	/** Lr nom du biome. */
	private String nom;

	/** La liste des animaux présents dans le biome. */
	protected ArrayList<Animal> faune;

	/** La liste des végétaux présents dans le biome */
	private ArrayList<Vegetal> flore;

	/**
	 * Constructeur de la classe Biome.
	 * 
	 * @param nom Le nom du biome.
	 */
	public Biome(String nom){
		this.nom = nom;
		this.faune = new ArrayList<>();
		this.flore = new ArrayList<>();
	}

	/**
	 * Obtient le nom du biome.
	 * 
	 * @return Le nom du biome.
	 */
	public String getName(){
		return nom;
	}

	/**
	 * Obtient la liste des animaux présents dans le biome.
	 * 
	 * @return La liste des animaux.
	 */
	public ArrayList<Animal> getfaune(){
		return this.faune;
	}
	
	/**
	 * Obtient la liste des végétaux présents dans le biome.
	 * 
	 * @return La liste des végétaux.
	 */
	public ArrayList<Vegetal> getflore(){
		return this.flore;
	}

	/**
	 * Affiche la faune du biome.
	 */
	public void afficheFaune (){
		System.out.println("Faune dans" + nom + ":");
		for (Animal animal: faune){
			System.out.println(animal.getname());
		}
	}

	/**
	 * Affiche la flore du biome.
	 */
	public void afficheFlore (){
		System.out.println("Flore dans" + nom + ":");
		for (Vegetal vegetal: flore){
			System.out.println(vegetal.getname());
		}
	}

	/**
	 * Ajoute un animal à la faune du biome.
	 * 
	 * @param animal L'animal à ajouter.
	 */
	public void addAnimaux (Animal animal){
		faune.add(animal);
		System.out.println(animal.getname() + "ajouté(e) à la faune de la" + nom);
	}

	/**
	 * Ajoute un végétal à la flore du biome.
	 * 
	 * @param vegetal Le végétal à ajouter.
	 */
	public void addPlante (Vegetal vegetal){
		flore.add(vegetal);
		System.out.println(vegetal.getname() + "ajouté(e) à la flore de la" + nom);
	}

	/**
	 * Retire un végétal de la flore du biome.
	 * 
	 * @param vegetal Le végétal à retirer.
	 */
	public void removePlante (Vegetal vegetal){
		if (flore.remove(vegetal)){
			System.out.println(vegetal.getname() + "a été extirpé(e) de la flore de la " + nom);
		}else{
			System.out.println(vegetal.getname() + "inexistant(e) dans la flore de la" + nom);
		}
	}

	/**
	 * Retire un animal de la faune du biome.
	 * 
	 * @param animal L'animal à retirer.
	 */
	public void removeAnimal (Animal animal){
		if (faune.remove(animal)){
			System.out.println(animal.getname() + "a été éléminé(e) de la faune de la " + nom);
		}else{
			System.out.println(animal.getname() + "inexistant(e) dans la faune de la" + nom);
		}
	}
}