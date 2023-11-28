import java.util.ArrayList;

import code_source.class_carte.class_animal.Animal;

public class Biome {
	private String nom;
	private ArrayList<Animal> faune;
	private ArrayList<Vegetal> flore;

	public Biome(String nom){
		this.nom = nom;
		this.faune = new ArrayList<>();
		this.flore = new ArrayList<>();
	}

	public String getName(){
		return nom;
	}

	public void afficheFaune (){
		System.out.println("Faune dans" + nom + ":");
		for (Animal animal: faune){
			System.out.println(animal.getName());
		}
	}

	public void afficheFlore (){
		System.out.println("Flore dans" + nom + ":");
		for (Vegetal vegetal: flore){
			System.out.println(vegetal.getName());
		}
	}

	public void addAnimaux (Animal animal){
		faune.add(animal);
		System.out.println(animal.getName() + "ajouté(e) à la faune de la" + nom);
	}

	public void addPlante (Vegetal vegetal){
		flore.add(vegetal);
		System.out.println(vegetal.getName() + "ajouté(e) à la flore de la" + nom);
	}

	public void removePlante (Vegetal vegetal){
		if (flore.remove(vegetal)){
			System.out.println(vegetal.getName() + "a été extirpé(e) de la flore de la " + nom);
		}else{
			System.out.println(vegetal.getName() + "inexistant(e) dans la flore de la" + nom);
		}
	}

	public void removeAnimal (Animal animal){
		if (faune.remove(animal)){
			System.out.println(animal.getName() + "a été éléminé(e) de la faune de la " + nom);
		}else{
			System.out.println(animal.getName() + "inexistant(e) dans la faune de la" + nom);
		}
	}

