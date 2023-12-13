package class_Animal.Homme;

import java.util.Random;
import java.util.Scanner;

import class_Animal.Animal;
import class_Animal.Carnivore;
import class_Animal.Herbivore;
/*import class_Animal.Homme.Axe;
import class_Animal.Homme.Pickaxe;*/
import class_Animal.Omnivore;
import class_Biome.Biome;
import class_Carte.*;
import class_Carte.Case;
import class_Vegetal.Arbre;
import class_Vegetal.Arbrefruit;
//import class_Vegetal.Rocher;
import class_Vegetal.Vegetal;
//import class_Animal.Homme.*;

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

    public boolean isDead(){
        return this.levellife <= 0;

    }
    public boolean isTired(){
        return this.levellife < this.levellife/2 ;
    } 
     public boolean isEmpty(Case[][] map) {
    if (!isValidCoordinate(this.getposition().getX()) || !isValidCoordinate(this.getposition().getY())) {
        System.out.println("Coordonnées invalides. x et y doivent être compris entre 0 et 9");
        return false;
    }

    Case targetCase = map[this.getposition().getX()][this.getposition().getY()];

    if (targetCase.getisvegetal()) {
        // Si c'est un arbre, demander à l'homme s'il veut couper l'arbre
        if (demanderAction("Couper l'arbre")) {
            
            System.out.println("Vous avez coupé l'arbre.");
        }
        return false; // La case n'est pas vide, mais l'homme a fait une action.

    } else if (targetCase.getisanimal()) {
        // Si c'est un herbivore, demander à l'homme s'il veut chasser
        // Si c'est un carnivore, demander à l'homme s'il veut fuir
        if (targetCase.getisanimal()) {
            if (demanderAction("Chasser l'herbivore")) {
                chasserHerbivore(targetCase.getAnimal());
                System.out.println("Vous avez chassé l'herbivore.");
            }
        } else if (targetCase.getisanimal() instanceof Carnivore) {
            if (demandeUtilisateur("Fuir le carnivore")) {
               
            }
        }
        return false; // La case n'est pas vide, mais l'homme a fait une action.

    } else if (targetCase.getisrocher())) {
        // Si c'est un rocher, collecter des cailloux avec la pioche

    } else if (!targetCase.isEmpty()) {
        // Si la case est occupée par autre chose
        System.out.println("La case est occupée par autre chose.");
        return false;

    } else {
        // Si la case est vide
        System.out.println("La case est libre.");
        return true;
    }
}



       public boolean demandeUtilisateur(String message){
    Scanner  scanner =new Scanner(System.in);
    System.out.println(message + " Oui/Non");
    return scanner.nextBoolean();

}
public Position RandomMoveHommmme(Case[][] map ){
    Random random= new Random();
    int rand = random.nextInt(8) +1 ;

    switch(rand){
        case 1 :
            System.out.println("haut");
            return this.haut(map);
        case 2 :
            System.out.println("bas");
            return this.bas(map);
    
        case 3 :
            System.out.println("gauche");
            return this.gauche(map);
            
        case 4 :
            System.out.println("droit");
            return this.droite(map);
            
        case 5:
            System.out.println("diagonale haut gauche");
            return this.diagonalehautgauche(map);
            
        case 6 :
            System.out.println(" diagonale haut droit");
            return this.diagonalehautdroit(map);
            
        case 7 :
            System.out.println("diagonale bas gauche");
            return this.diagonalebasgauche(map);
            
        case 8 :
            System.out.println("diagonale bas droit");
            return this.diagonalebasgauche(map);
            
        default :
            System.out.println("le choix n'est pas valide!!");
    }  
    
    return this.getposition();
} 
    public boolean isValidCoordinate(int value){
        return value >= 0 && value <=9 ;
    } 

public Position correctMove(Case[][] cartCase )throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez la nouvelle coordonnée de x entre 0 et 9");
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
            System.out.println("La nouvelle positon a été définie");  
            return this.getposition();
             } else{
            System.out.println("ouuups! la case est déjà occupée");
        }   
    return nextMove;

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

    public String toString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel outil souhaites-tu utiliser Francis?:");
        System.out.println("1. Hache");
        System.out.println("2. Lance");
        System.out.println("3. Pioche");

        int choix = scanner.nextInt();
        String nomOutil = "";

        switch (choix) {
            case 1:
                nomOutil = "Hache";
                break;
            case 2:
                nomOutil = "Lance";
                break;
            case 3:
                nomOutil = "Pioche";
                break;
            default:
                System.out.println("aieeee, ton choix n'est pas valide");
        }

        return "Francis a choisi la " + nomOutil ;
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
             couperBois(arbre,this.getInvent());
        } else{
                System.out.println("Francis ne veut pas couper du bois");
             } 
}  

public void contactCarnivore(Animal animal, Case[][]  cart){
    if(animal instanceof Carnivore && animal.getposition()==(this.getposition())){
            System.out.println("l'homme vient de rentrer en contact avec un carnivore");
     }
    
    boolean veutfuir = demandeUtilisateur("veux-tu fuir?");
    if(veutfuir){
        this.correctMove(cart);
        System.out.println("l'homme a changé de position");
    } else{
        if(this.getstrength() <= animal.getstrength()) {
            this.isDead();
        } else {
            this.levellife -= 5;
            this.correctMove(cart);
        }
    }

}  
// faire un to string qui demande l'outl à utiliser
public void chasser(Animal animal , Inventaire invent, Case [] [] carte){
    int qtyviande = 0;
    int qtyDommageOutil= 2*this.getstrength();
    int qtyDommage = 0;
    String nomOutil = "lance";
    if(animal instanceof Herbivore){
        if(this.hasTool(nomOutil)){
            Tool aTool = invent.getTool(nomOutil);
            System.out.println("L'homme utilise un outil");
            aTool.useoutil();
            animal.looselevellife(qtyDommageOutil);
            if(animal.isDeadAnimal(animal)){
                System.out.println("l'animal est mort");
                qtyviande = 5;
                invent.ajouterViande(qtyviande);
                //animal.supprimeranimal()
            }else{
                System.out.println("l'animal n'est pas mort");
            }
            
        }else {
            animal.looselevellife(qtyDommage);
            if(animal.isDeadAnimal(animal)){
                System.out.println("L'animal est mort");
                qtyviande = 5;
                invent.ajouterViande(qtyviande);
            } else {
                System.out.println("Dommageee! Tu n'as pas pu tuer l'animal");
            }
        }
    } else{
        if(animal instanceof Carnivore){
            contactCarnivore(animal, carte);
        }
    }

} // revoir le if( animal instanceof carnivore)

public void demanderChasser(Animal animal, Case [] [] carte){
    boolean veutchasser = demandeUtilisateur("Souhaites tu chasser l'animal?");
    if(veutchasser){
        chasser(animal, this.getInvent(), carte);
    } else{
        System.out.println("L'homme ne veut pas chasser l'animal");
    } 
} 

public void recolterfruit(Arbrefruit arbre, Inventaire iventaire){
    int qtyfruit = 0;
    int newqtyfruit = 0;
    if(arbre instanceof Arbrefruit){
        qtyfruit += arbre.getnbfruit() ;
        arbre.setnbfruit(newqtyfruit);
        iventaire.ajouterFruit(qtyfruit);
        System.out.println("Génial! On a recolté des fruits");
    } else{
        System.out.println("cette arbre n'a pas de fruits");
    }

}

public void demanderecolterFruit(Arbrefruit arbref){
    boolean recolterf = demandeUtilisateur("souhaites turecolter des fruits?");
    if(recolterf){
        recolterfruit(arbref, invent); 
    } else{
        System.out.println("l'homme ne souhaite pas recolter de fruits");
    } 
}
       
    //demander au prof comment faire un for avec une interface 
    public boolean hasTool(String toolName){
        for(Tool atool: invent.getArsenal()){
            if(atool.getName()== toolName){
                return true;
            }
        }
        return false;
    }

    public void fabriquerAxe(Inventaire invent){
        if(invent.getQtecailloux()>=3 && invent.getQtebois()>=2){
            invent.setQtebois(invent.getQtebois()-2);
            invent.setQtecailloux(invent.getQtecailloux()-3);

            invent.ajouterOutil(new Axe("axe"));

            System.out.println("bravo! tu viens de fabriquer une hache!");
        } else{
            System.out.println("Dommage, nous n'avons pas assez de ressources pour fabriquer une hache :(");
        } 

    } 

    public void fabriquerspear(Inventaire invent){
        if(invent.getQtecailloux() >=1 && invent.getQtebois()>=2){
            invent.setQtecailloux(invent.getQtecailloux()-1);
            invent.setQtebois(invent.getQtebois()-2);

            invent.ajouterOutil(new Spear("lance"));

            System.out.println("Bravo Francis! tu as fabriqué une lance");
        } else{
            System.out.println("oh oooh ... t'as pas assez de ressources");
        } 

    } 

    public void fabriquerPickaxe(Inventaire invent){
        if(invent.getQtecailloux() >=3 && invent.getQtebois()>=2){
            invent.setQtecailloux(invent.getQtecailloux()-3);
            invent.setQtebois(invent.getQtebois()-2);

            invent.ajouterOutil(new Pickaxe("Pioche"));

            System.out.println("Bravo Francis! tu as fabriqué une Pioche");
        } else{
            System.out.println("Aie, va falloir recolter plus de bois et caillous Francis!");
        } 
    } 

   @Override 
// problème car l'homme ne mange pas direct un animal mais il se sert dans l'inventaire
   public void eatMeat(Animal prey){
    if(isTired()){
        this.levellife += 3;
        System.out.println("Miam! Elle est bonne la nourriture");
        this.invent.setQteviande(invent.getQteviande()-5);
    } else{
        System.out.println("on dirait Francis il veut pas manger");
    } 
} 

@Override

public void eatPlant(Vegetal plant){
    if(isTired()){
        this.levellife =3;
        System.out.println("Francic il se régale");
        this.invent.setQtefruit(invent.getQtefruit()-5);
    } else{
        System.out.println("oooow , Franis n'a pas faim");
    } 
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

/* 
 * 
*/

 