package class_Animal.Homme;

import java.util.Scanner;

import class_Animal.Animal;
import class_Animal.Carnivore;
import class_Animal.Herbivore;
import class_Animal.Homme.Axe;
import class_Animal.Homme.Pickaxe;
import class_Animal.Homme.Pickaxe;
import class_Animal.Omnivore;
import class_Biome.Biome;
import class_Carte.*;
import class_Vegetal.Arbre;
import class_Vegetal.Arbrefruit;
import class_Animal.Homme.*;

public class Homme extends Omnivore {
    public Inventaire invent;

    public Homme(String n, int l, int s,Position p, Biome b,Inventaire invent) {
        super(n,l,s,p,b);
        this.invent = invent;
    }
    
    //getters et setters
    public Inventaire getInvent() {
        return this.invent;
    }

    public void setInvent(Inventaire invent) {
        this.invent = invent;
    }

       public boolean demandeUtilisateur(String message){
    Scanner  scanner =new Scanner(System.in);
    System.out.println(message + " Oui/Non");
    return scanner.nextBoolean();

}
    public boolean isValidCoordinate(int value){
        return value >= 0 && value <=9 ;
    } 

    public Position correctMove(Case[][] cartCase )throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        boolean hasNothing = true;
        while(hasNothing){
            System.out.println("Entrez ls nouvelle coordonnée de x entre 0 et 9");
            int newX = scanner.nextInt();
            System.out.println("Entrez la nouvelle coordonnée de Y entre 0 et 9");
            int newY = scanner.nextInt();
            if (!isValidCoordinate(newX)|| !isValidCoordinate(newY) ){
                throw new IllegalArgumentException(" x et y doivent être compris entre 0 et 9");
            } 
            Position nextMove = new Position(newX, newY);
            
            if(this.getposition().isEmpty(nextMove , cartCase)){
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( nextMove);
            //cartCase[nextMove.getX()][nexMove.getY()].sethomme(true);  
            System.out.println("La nouvelle psoisiton a été définie");  
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
        } 
    }  
//-----------------------------------------------------------------------------------------------
    public Position haut (Case[][] cartCase){
        Position moveto = new Position(0,0);
        boolean wposition = false;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition);
        moveto.setY(moveto.getY()-1, wposition);
        if(this.getposition().isEmpty(moveto , cartCase)){
            System.out.println("La position a été changé");
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(cartCase);
        } 

    }
         
    public Position bas (Case[][] cartCase){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setY(moveto.getY()+1, wposition);
        if(this.getposition().isEmpty(moveto , cartCase)){
            System.out.println("La position a été changé");
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(cartCase);
        } 

    } 


    public Position droite (Case[][] cartCase  ){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX()+1, wposition);
        if(this.getposition().isEmpty(moveto , cartCase)){
            System.out.println("La position a été changé");
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(cartCase);
        } 
    }

     public Position gauche (Case[][] cartCase  ){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX()- 1, wposition);
        if(this.getposition().isEmpty(moveto , cartCase)){
            System.out.println("La position a été changé");
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(cartCase);
        } 
    }

     public Position diagonalehautgauche(Case [][] caseCart){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX()- 1, wposition);
        moveto.setY(moveto.getY() - 1, wposition);
        if(this.getposition().isEmpty(moveto , caseCart)){
            System.out.println("La position a été changé");
            //caseCart[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(caseCart);
        } 
    } 
    public Position diagonalehautdroit(Case [][] caseCart){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX() + 1, wposition);
        moveto.setY(moveto.getY() - 1, wposition);
        if(this.getposition().isEmpty(moveto , caseCart)){
            System.out.println("La position a été changé");
            //caseCart[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(caseCart);
        } 
    } 
    public Position diagonalebasgauche(Case [][] caseCart){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX()- 1, wposition);
        moveto.setY(moveto.getY() + 1, wposition);
        if(this.getposition().isEmpty(moveto , caseCart)){
            System.out.println("La position a été changé");
            //caseCart[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(caseCart);
        } 
    } 
    public Position diagonalbasdroit(Case [][] caseCart){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        moveto.setPosition(this.getposition().getX(), this.getposition().getY(), wposition); 
        moveto.setX(moveto.getX()+ 1, wposition);
        moveto.setY(moveto.getY() + 1, wposition);
        if(this.getposition().isEmpty(moveto , caseCart)){
            System.out.println("La position a été changé");
            //caseCart[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( moveto);
            //cartCase[moveto.getX()][moveto.getY()].sethomme(true);    
            return this.getposition();
        } else{
            System.out.println("ouuups! la case est déjà occupée");
            System.out.println("case d'arrivée : x " + moveto.getX() +"y" + moveto.getY() );
            return this.correctMove(caseCart);
        } 
    } 

public void couperBois(Arbre arbre, Inventaire inventaire){
    int quantity =0;
    int minStrength= 10;
    String nomOutil ="Axe";
    //vérifier si il a l'axe dans son inventaire
    if(this.hasTool(nomOutil)){
        Tool aTool = inventaire.getTool(nomOutil);
        System.out.println("l'homme utilise l'outil");
        aTool.useoutil();
        // si chene quantity =5
        // donc quantity +=5
        inventaire.ajouterBois(quantity);
    } else{
        if(this.getstrength() >= minStrength ){
            System.out.println("L'homme coupe l'abre à la main");
            // si chene quantity = 10 Arbres.CHENE.getnom
            inventaire.ajouterBois(quantity);
        } else{
            System.out.println("L'homme n'a pas assez de force");
        } 
    } 
    //  Carte.supprimer(arbre);
} 
public void demanderCouperBois(Arbre arbre){

     boolean veutcouper = demandeUtilisateur("souhaites tu couper du bois?");
        if(veutcouper){
             couperBois(arbre,invent);
        } else{
                System.out.println("Francis ne veut pas couper du bois");
             } 
}  

public void chasser(Animal animal , Inventaire invent){

    
}

public void demanderChasserherbivore(Homme hoeme, Herbivore herbivore){
    boolean veutchasser = demandeUtilisateur("Souhaites tu chasser l'animal?");
    if(veutchasser){
        chasser(homme,outil,herbivore); // à implémenter
    } else{
        System.out.println("L'homme ne veut pas chasser l'animal");
    } 
} 

public void demanderecolterFruit(Homme homme, Arbrefruit arbref){
    boolean recolterf = demandeUtilisateur("souhaites turecolter des fruits?");
    if(recolterf){
        recolterfruit(homme, arbref); // a impléménter
    } else{
        System.out.println("l'homme ne souhaite pas recolter de fruits");
    } 
}

public void contactCarnivore(Homme homme){
    for(Animal animal : desAnimaux){
        if(animal instanceof Carnivore && animal.getposition().equals(homme.getposition())){
            System.out.println("l'homme vient de rentrer en contact avec un carnivore");
        }
    } 
    boolean veutfuir = demandeUtilisateur("veux-tu fuir?");
    // implémenter la logique derrière
}  
       
    //demander au prof comment faire un for avec une interface 
    public boolean hasTool(String toolName){
        for(Tool atool: invent.getArsenal()){
            if(atool.getName().equals(toolName)){
                return true;
            }
        }
        return false;
    }
    //public void 
/*recolterbois(outil,vegetal)?? si pas encore d'outil utilise sa force 
pareil pour recolter Fruit
    public void recolterBois(int quantity){
        invent.ajouterBois(quantity);
        System.out.println(this.getname() + "a recolté" + quantity + "de bois"  );
    } 

    public void recolterFruit(int quantity){
        invent.ajouterFruit(quantity);
        System.out.println(this.getname() + "a recolté" + quantity + "de fruits");
    } 

    public void chasse(Animal prey){     
    }  
    //commet faire pour ajouter un outil créer dans l'inventaire 
    //comment questioner l'inventaire
}
*/}

