package class_Biome;

import java.util.ArrayList;
import class_Animal.Animal;
import class_Vegetal.Rocher;
import class_Vegetal.Vegetal;

public class Biome {
	private String nom;
	protected ArrayList<Animal> faune;
	private ArrayList<Vegetal> flore;
	private ArrayList<Rocher> geologie;

	public Biome(String nom){
		this.nom = nom;
		this.faune = new ArrayList<Animal>();
		this.flore = new ArrayList<Vegetal>();
		this.geologie = new ArrayList<Rocher>();
	}

	public Biome(Biomes foret) {
	}

	public String getName(){
		return nom;
	}

	public ArrayList<Animal> getfaune(){
		return this.faune;
	}
	
	public ArrayList<Vegetal> getflore(){
		return this.flore;
	}

	public ArrayList<Rocher> getgeologie(){
		return this.geologie;
	}

	public void setName(String b){
		this.nom = b;
	}


	public void afficheFaune (){
		System.out.println("Faune dans " + this.nom + ":");
		for (Animal animal : this.getfaune() ){
			System.out.println(animal.getname());
			System.out.println(animal.getname() + " a la position x = " + animal.getposition().getX() + " y = " + animal.getposition().getY());		}
		System.out.println("\n");
	}

	public void afficheFlore (){
		System.out.println("Flore dans " + this.nom + ":");
		for (Vegetal vegetal : flore){
			System.out.println(vegetal.getname() + " a la position x = " + vegetal.getposition().getX() + " y = " + vegetal.getposition().getY());
		}
		System.out.println("\n");
	}

	public void affichegeologie (){
		System.out.println("Rocher dans " + this.nom + ":");
		for (Rocher roc: geologie){
			System.out.println(roc.getNom() + " a la position x = " + roc.getPos().getX() + " y = " + roc.getPos().getY());
		}
		System.out.println("\n");
	}

	public void addAnimaux (Animal animal){
		this.faune.add(animal);
		System.out.println(animal.getname() + " ajouté(e) dans la " + this.nom);
	}

	public void addPlante (Vegetal vegetal){
		flore.add(vegetal);
		System.out.println(vegetal.getname() + " ajouté(e) dans la " + this.nom);
	}

	public void addRocher (Rocher roc){
		geologie.add(roc);
		System.out.println(roc.getNom() + " ajouté(e) dans la " + this.nom);
	}

	public void removePlante (Vegetal vegetal){
		if (flore.remove(vegetal)){
			System.out.println(vegetal.getname() + "a été extirpé(e) de la flore de la " + nom);
		}else{
			System.out.println(vegetal.getname() + "inexistant(e) dans la flore de la" + nom);
		}
	}

	public void removeAnimal (Animal animal){
		if (faune.remove(animal)){
			System.out.println(animal.getname() + "a été éléminé(e) de la faune de la " + nom);
		}else{
			System.out.println(animal.getname() + "inexistant(e) dans la faune de la" + nom);
		}
	}

	public void removeRocher (Rocher roc){
		if (geologie.remove(roc)){
			System.out.println(roc.getNom() + "a été éléminé(e) de la faune de la " + nom);
		}else{
			System.out.println(roc.getNom() + "inexistant(e) dans la faune de la" + nom);
		}
	}
}