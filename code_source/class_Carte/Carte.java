package class_Carte;

import java.util.ArrayList;
import java.util.Scanner;

import class_Animal.*;
import class_Biome.*;
import java.util.Random;
import class_Carte.*;
import class_Vegetal.Vegetal;
import class_Animal.Carnivore;

public class Carte {

    private Case[][] map = new Case[100][100];
    //private ArrayList<Case> map = new ArrayList<>(); 
    private ArrayList<Animal> desAnimaux = new ArrayList<>() ;
    private int nbtour;
    private Homme homme;
    

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

   public boolean isEmpty(Position p){
        boolean empty = false;
        
        return empty;
        //TODO
   }

   public void verifmvtanimal(Animal pet, Position pos){
    //TODO
   } 

        
    



 
   public boolean verifflore(Animal pet){
        boolean isoccuped = false;
        for(Vegetal veg : getflore){
            if (veg.getposition() == pet.getposition()){
                isoccuped = true;
                return isoccuped;
            }
        }
        return isoccuped;
    }
   
    public String whatdiet (Animal an){
        if (isCarnivore(an)){
            return "Carnivore";
        }else if (isHerbivore(an)){
                return "Herbivore";
        }else if (isOmnivore(an)){
            return "Omnivore";
        }
    }

    public Animal findpet (Position pos){
        for(Animal ani : getfaune){
            if (ani.getposition() == pos){
                return ani;
            }//else leve exception
        }
    }


    public void carnivoreeatcarnivore (Animal predator, Animal hunter){
        if (predator.getstrength() >= hunter.getstrength()){
            hunter.looselevellife(2*predator.getstrength());
                if (!isDeadAnimal(hunter)){
                     fuite(hunter);
                     fuite(predator);
                }
        }
    }

    public void carnivoreeatherbivore (Animal predator, Animal brebis){
        brebis.looselevellife(2*predator.getstrength());
                    if (!isDeadAnimal(brebis)){
                        fuite(brebis);
                    }
    }

    //a voir pour rajouter des trucs sinon enlever procedure
    public void herbivoremeetherbivore (Animal brebis, Animal chevre){
        fuite(brebis);
        fuite(chevre);
    }

// voir pour gerer rencontre herbivore carnivore et omnivore
    public void animalmeetanimal(Animal pet){
    String diet; 
    String gibierdiet;
    Animal gibier;
        if (samePosition(pet)){
            diet = whatdiet(pet);
            gibier = findpet(pet.getposition());
            gibierdiet = whatdiet(gibier);
            if (((diet == "Carnivore") || (diet == "Omnivore")) && ((gibierdiet == "Carnivore") || (gibierdiet == "Omnivore"))){ //carnivore ou omnivorequi veut manger carnivore ou omnivore
                carnivoreeatcarnivore(pet, gibier);
            }else if (((diet == "Carnivore") || (diet == "Omnivore")) && (gibierdiet == "Herbivore")){ // carnivore ou omnivore qui mange herbivore
                carnivoreeatherbivore(pet, gibier);
            }else if ((diet == "Herbivore") && (gibierdiet == "Herbivore")){
                herbivoremeetherbivore(pet,gibier);
            }
        }
    } 


    public Position haut (Animal an){
        Position pos = an.getposition();
        pos.y -= 1;
        if (!(isEmpty(pos))) {
            if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }       
        }else{
            an.setposition (pos);
            return an.getposition();
        }
    }
         
    public Position bas (Animal an){
        Position pos = an.getposition();
        pos.y += 1;
        if ((!isEmpty(pos))) {
           if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }
        }else{
            an.setposition (pos);
            return an.getposition();
        }
    }

    public Position droite (Animal an){
        Position pos = an.getposition();
        pos.x += 1;
        if (!(isEmpty(pos))) {
            if ((verifmvtanimal(an)) && (verifflore(an))){
                //rajouter de update la position
            }
        }else{
            an.setposition (pos);
            return an.getposition();
        }
    }

    public Position gauche (Animal an){
        Position pos = an.getposition();
        pos.x -= 1;
        an.setposition (pos); 
    }
     public boolean isEmpty(Position p){
        if(p.x < 0|| p.x >= map.length|| p.y <0|| p.y>= map[0].length){
            return false;
        } 
        for(Animal anAnimal : desAnimaux){
            if(anAnimal.getposition().equals(p)){ // Un animal est dans la case
                return false;
            } 
        } 
        // la case est occupé par l'homme
        if(homme.getposition().equals(p)){
            return false;
        } 
        // La case n'est occupé ni par l'homme ni par un animal
        return true; 
   }
   //fonction pour prendre les réponses de l'utilisateur pour pas faire de scanner tout le temps
   public boolean demandeUtilisateur(String message){
    Scanner  sc =new Scanner(System.in);
    System.out.println(message + " Oui/Non");
    return sc.nextBoolean();

}


public void moveHomme(Homme homme, Position moveto){
    Position movefrom = homme.getposition();
    if(isEmpty(moveto)){
        homme.setposition(moveto);
    } 
    else { 
         if(moveto.x > movefrom.x){
            homme.droite(moveto);
         } 
        if(moveto.x < movefrom.x){
            homme.gauche(moveto);
         } 
        else if(moveto.y > movefrom.y){
            homme.bas(moveto);
         } 
        if(moveto.y < movefrom.y){
            homme.haut(moveto);
        } 
        if(moveto.x < movefrom.x && moveto.y < movefrom.y){
            homme.diagonalehautgauche(moveto);
        } 
        if(moveto.x > movefrom.x && moveto.y < movefrom.y){
            homme.diagonalehautdroit(moveto);
        } 
        if(moveto.x < movefrom.x && moveto.y > movefrom.y){
            homme.diagonalebasgauche(movefrom);
        } 
        if(moveto.x > movefrom.x && moveto.y > movefrom.y){
            homme.diagonalbasdroit(moveto);
        } 
    } 

    //gestion de l'element qui se trouve dans la case où l'homme souhaite y aller
    
} 

public void demanderCouperBois(Homme homme , Arbre arbre){

     boolean veutcouper = demandeUtilisateur("souhaites tu couper du bois?");
        if(veutcouper){
             couperBois(homme,outil,arbre);// à impléménter
        } else{
                System.out.println("L'homme ne veut pas couper du bois");
             } 
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



public void moveHomme(Homme homme, Position moveto){
    Position movefrom = homme.getposition();
    if(isEmpty(moveto)){
        homme.setposition(moveto);
    } 
    else { 
         if(moveto.x > movefrom.x){
            homme.droite(moveto);
         } 
        if(moveto.x < movefrom.x){
            homme.gauche(moveto);
         } 
        else if(moveto.y > movefrom.y){
            homme.bas(moveto);
         } 
        if(moveto.y < movefrom.y){
            homme.haut(moveto);
        } 
        if(moveto.x < movefrom.x && moveto.y < movefrom.y){
            homme.diagonalehautgauche(moveto);
        } 
        if(moveto.x > movefrom.x && moveto.y < movefrom.y){
            homme.diagonalehautdroit(moveto);
        } 
        if(moveto.x < movefrom.x && moveto.y > movefrom.y){
            homme.diagonalebasgauche(movefrom);
        } 
        if(moveto.x > movefrom.x && moveto.y > movefrom.y){
            homme.diagonalbasdroit(moveto);
        } 
    } 

    //gestion de l'element qui se trouve dans la case où l'homme souhaite y aller
    
} 

public void demanderCouperBois(Homme homme , Arbre arbre){

     boolean veutcouper = demandeUtilisateur("souhaites tu couper du bois?");
        if(veutcouper){
             couperBois(homme,outil,arbre);// à impléménter
        } else{
                System.out.println("L'homme ne veut pas couper du bois");
             } 
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



    public void randommvt(Animal pet){
        Random random = new Random();
        int rand = random.nextInt(4) +1;
        

        switch (rand){
            case 1:
                haut(pet);
                break;
            case 2:
                bas(pet);
                break;
            case 3:
                gauche(pet);
            case 4:
                droite(pet);
                break;
            default:

                break;
        }

    }
}
