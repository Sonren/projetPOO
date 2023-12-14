package class_Animal.Homme;

import java.util.Scanner;

import class_Animal.Animal;
import class_Biome.Biome;
import class_Carte.Position;
import class_Vegetal.Vegetal;
import class_Carte.Case;
import class_Vegetal.Rocher;
import class_Vegetal.Rochers;

public class Homme extends Animal {
    public Inventaire invent = new Inventaire(0, 0, 0, 0, null);
    private boolean isDead;

    public Homme(String n, int l, int s,Position p, Biome b) {
        super(n,l,s,p,b);
        this.isDead = false;
    }
    
    //getters et setters
    public Inventaire getInvent() {
        return this.invent;
    }

    public void setInvent(Inventaire invent) {
        this.invent = invent;
    }

    public boolean demandeUtilisateur(String message){
        boolean answer;
        Scanner scanner =new Scanner(System.in);
        System.out.println(message + " Oui(true)/Non(false)"); 
        answer = scanner.nextBoolean();
        scanner.close();
        return answer;
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
            
            if(nextMove.isEmpty(cartCase)){
            //cartCase[this.getposition().getX()][this.getposition().getY()].sethomme(false);// faire le booleen ishomme dans carte
            this.setposition( nextMove);
            //cartCase[nextMove.getX()][nexMove.getY()].sethomme(true);  
            System.out.println("La nouvelle psoisiton a été définie");  
            return this.getposition();
            } else{
             System.out.println("ouuups! la case est déjà occupée");
            } 
        }
        return null;
    }
    //-----------------------------------------------------------------------------------------------
    public boolean isEmpty (Case[][] map, Position posarriv){
        boolean empty = false;
        if(map[posarriv.getX()][posarriv.getY()].getisanimal()){
            return empty;
        }else if (map[posarriv.getX()][posarriv.getY()].getisvegetal()){
            return empty;
        }else if (map[posarriv.getX()][posarriv.getY()].getisrocher()){
            return empty;
        }else{
            empty = true;
            return empty;
        }
    }
    
    
    public Position haut (Case[][] cartCase){
        Position moveto = new Position(0,0);
        boolean goodHPosition = false;
        boolean result;
        System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
        goodHPosition = moveto.setPosition(this.getposition().getX(), this.getposition().getY() - 1);
        System.out.println("posH : x = " + moveto.getX() + " y = " + moveto.getY());
        result = testPosition(moveto, cartCase);
        if(result){
            if(goodHPosition){
                if(cartCase[moveto.getX()][moveto.getY()].getisanimal() == true){
                    if (cartCase[moveto.getX()][moveto.getY()].getisanimal() == true){
                    System.out.println("rencontre un animal");
                    }else{
                        System.out.println("*******************");
                        System.out.println("position changé");
                        System.out.println("*******************");
                        cartCase[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                        this.setposition(moveto);
                        cartCase[moveto.getX()][moveto.getY()].setisanimal(true);
                        return moveto;
                    }
                }
            }else{
                System.out.println("la position n'est pas correcte, veullez en saisir une nouvelle");
                //appel procedure deplacement
            }
        }else{
            if(isGoodBiomehuman(moveto)){
                if(cartCase[moveto.getX()][moveto.getY()].getisvegetal()){
                    return hommeMeetVegetal(cartCase, moveto);
                }else if (cartCase[moveto.getX()][moveto.getY()].getisrocher()){
                    System.out.println("il y a un rocher sur la case");
                    return hommeMeetRocher(cartCase, moveto);
                }else if (cartCase[moveto.getX()][moveto.getY()].getisanimal()){
                    System.out.println("il y a un animal sur la case");
                    //on apelle la fonction human meet animal 
                }
            }else{
                System.out.println("on doit changer de biome");
                //appel change biome
            }
        }
        return moveto = null;
    }

    public Position hommeMeetVegetal(Case[][] map, Position pos){
        Vegetal findveg;
        System.out.println("il y a un vegetal sur la case");
        if(demandeUtilisateur("Voulez vous coupez du bois ?")){
            findveg = findVegetal(pos, map, this.getbiome());
            couperBois(findveg, map, pos);
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(pos);
            map[pos.getX()][pos.getY()].setisanimal(true);
            return this.getposition();
        }else{
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(pos);
            map[pos.getX()][pos.getY()].setisanimal(true);
            return this.getposition();
        }
    }

    public Animal findAnimal(Position moveto, Case[][] map, Biome bio) {
        for (Animal animal: bio.getfaune()){
            
            if(animal.getposition().getX() == moveto.getX() && animal.getposition().getY() == moveto.getY()){
                if (animal.isDead() == false){
                    System.out.println("y'a un " + animal.getname());
                    return animal;
                }else{
                    System.out.println("oh l'animal est mort");
                    return animal;
                }
            }
        }
        bio.afficheFaune();
        System.out.println("on a pas trouvé un animal");
        return null;
    }
   
    public Position HommeMeetCarnivore(Case[][] cart, Position pos){
        boolean veutfuir = demandeUtilisateur("francis souhaites tu fuir?");
        Animal findanimal = findAnimal(pos, cart, this.getbiome());
        if (findanimal.isDead() == true){
            System.out.println("oohh cet animal est mort");
            cart[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(pos);
            cart[pos.getX()][pos.getY()].setisanimal(true);
            return this.getposition();
        }  
        if (findanimal!= null){
            if (findanimal.isCarnivore() || findanimal.isOmnivore()){
                if(veutfuir){
                    this.correctMove(cart);
                    return this.getposition();
                }else{
                    if(this.getstrength()<= findanimal.getstrength()){
                        this.isDead = true;
                    } 
                }
            } 
        }
    System.out.println("on a pas trouvé d'animal");
    return null;
} 


    public void chasser(Animal animal, Case[][] map, Position pos){
        // on va dire qu'un herbivore ramène 3 viandes
        int qtyViandeH = 3 ;
        if(animal.isHerbivore()==true){
            if(this.hasTool(Tools.LANCE.getNom())){
                System.out.println(" On a bien la lance, tu peux chasser");
                this.getInvent().ajouterViande(qtyViandeH);
                this.levellife +=3 ;
                map[pos.getX()][pos.getY()].setisanimal(false);
                animal.killedAnimal(animal);
                System.out.println(" Nous avons rajouté 3 morceaux de viandes à l'inventaire");
            }else{
                System.out.println("Francis tu n'as pas d'outils on va utiliser le mains");
                this.levellife -= 3;
                this.getInvent().ajouterViande(qtyViandeH);
                System.out.println( "on a pu récupérer 3 morceaux de viande dans l'inventaire");
                map[pos.getX()][pos.getY()].setisanimal(false);
                animal.killedAnimal(animal);
                System.out.println("Tu as  " + this.getlevellife()+ "de points de vie");
            }
        } else{
            if(animal.isCarnivore()== true){
                this.HommeMeetCarnivore(map, pos);
            } 
        } 
        
     System.out.println("Cet animal n'est pas un herbivore! et on na chasse que les herbivore");
         
    }


    public Position hommeMeetRocher(Case[][] map, Position pos){
        Rocher findrock;
        System.out.println("il y a un rocher sur la case");
        if(demandeUtilisateur("Voulez vous le minez ?")){
            findrock = findRock(pos, map, this.getbiome());
            miner(findrock, map, pos);
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(pos);
            map[pos.getX()][pos.getY()].setisanimal(true);
            return this.getposition();
        }else{
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(pos);
            map[pos.getX()][pos.getY()].setisanimal(true);
            return this.getposition();
        }
    }

    public Rocher findRock(Position temppos, Case[][] gamemap, Biome bio){
        for(Rocher rok : bio.getgeologie()){
            if(rok.getposition().getX() == temppos.getX() && rok.getposition().getY() == temppos.getY()){
                if(rok.isDeadroc() == false){
                    System.out.println("Rocher rencontré = " + rok.getname());
                    return rok;
                }else{
                    System.out.println("Le rocher a déja été miner");
                    return rok;//on retourne ici le rocher mort et on gère le cas au dessus
                }
            }
        }
        bio.affichegeologie();
        System.out.println("aucun rocher trouvé");
        return null;
    }

    public void miner(Rocher rock, Case[][] map, Position pos){
        if(this.hasTool(Tools.HACHE.getNom())){
            System.out.println("vous utilisez une pioche pour miner");
            this.getInvent().ajouterCailloux(rock.getNbcailloux());
            map[pos.getX()][pos.getY()].setisrocher(false);
            System.out.println(rock.getNbcailloux() + " cailloux on été ajouté a l'inventaire");
        }else{
            System.out.println("Vous minez a la main");
            this.levellife -= 5;
            this.getInvent().ajouterCailloux(rock.getNbcailloux());
            System.out.println(rock.getNbcailloux() + " cailloux on été ajouté a l'inventaire");
            map[pos.getX()][pos.getY()].setisrocher(false);
            System.out.println("votre niveau de vie actuel : " + this.getlevellife());
        }
    }

    public void couperBois(Vegetal arbre, Case[][] map, Position pos){
        if(this.hasTool(Tools.HACHE.getNom())){
            System.out.println("vous utilisez une Hache pour couper du bois");
            this.getInvent().ajouterBois(arbre.getnbbois());
            map[pos.getX()][pos.getY()].setisvegetal(false);
            System.out.println(arbre.getnbbois() + " morceaux de bois ont été ajouté a l'inventaire");
        }else{
            System.out.println("Vous coupez l'abre a la main");
            this.levellife -= 3;
            this.getInvent().ajouterBois(arbre.getnbbois());
            System.out.println(arbre.getnbbois() + " morceaux de bois ot été ajouté a l'inventaire");
            map[pos.getX()][pos.getY()].setisvegetal(false);
            System.out.println("votre niveau de vie actuel : " + this.getlevellife());
        }
    }
    public boolean hasTool(String toolname){
        boolean hastool = false;
        if(toolname == Tools.HACHE.getNom()){
            Tool tolfind = findTool(this.getInvent(), Tools.HACHE.getNom());
            if(tolfind != null){
                if (tolfind instanceof Axe){
                    hastool = true;
                    return hastool;
                }
            }else{
                return hastool;
            }
        }else if(toolname == Tools.PIOCHE.getNom()){
            Tool tolfind = findTool(this.getInvent(), Tools.PIOCHE.getNom());
            if(tolfind != null){
                if (tolfind instanceof Pickaxe){
                    hastool = true;
                    return hastool;
                }
            }else{
                return hastool;
            }
        }else if(toolname == Tools.LANCE.getNom()){
            Tool tolfind = findTool(this.getInvent(), Tools.LANCE.getNom());
            if(tolfind != null){
                if (tolfind instanceof Spear){
                    hastool = true;
                    return hastool;
                }
            }else{
                return hastool;
            }
        }
        System.out.println("l'outil que vous voulez utiliser n'existe pas");
        return hastool;
    }

    public Tool findTool(Inventaire invent, String name){
        if(invent.getArsenal() == null){
            System.out.println("Vous n'avez pas l'outil : " + name);
        return null;
        }else{
            for(Tool tol : invent.getArsenal()){
                if(tol.getName() == name){
                    return tol;
                }
            }
        }
        System.out.println("Vous n'avez pas l'outil : " + name);
        return null;
    }

    public Vegetal findVegetal(Position temppos, Case[][] gamemap, Biome bio){
        for(Vegetal veg : bio.getflore()){
            if(veg.getposition().getX() == temppos.getX() && veg.getposition().getY() == temppos.getY()){
                if(veg.isDeadveg() == false){
                    System.out.println("végétal rencontré = " + veg.getname());
                    return veg;
                }else{
                    System.out.println("l'abre a déja été coupé");
                    return veg;//on retourne ici l'arbre mort et on gère le cas au dessus
                }
            }
        }
        bio.afficheFlore();
        System.out.println("aucun arbre trouvé");
        return null;
    }

            

    public boolean isGoodBiomehuman(Position pos) {
        boolean goodbiome = true;
        if (this.getbiome().getName() == "forêt"){
            if (pos.getY() < 4){
                return goodbiome; //l'animal se situe dans la forêt
            }else{
                goodbiome = false;
                return goodbiome;
            }
        }else if (this.getbiome().getName() == "plaine"){ 
                    if ((pos.getY() < 9) && (pos.getY() >= 4)){
                        return goodbiome; //l'animal se situe dans la plaine 
                    }else{
                        goodbiome = false;
                        return goodbiome;
                    }
        }else{ 
            System.out.println("animal dans la mer");
            goodbiome = false;
            return goodbiome; //aucun animal ne peut aller dans la mer 
        }
    }


                
         
    public Position bas (Case[][] cartCase){
        Position moveto = new Position(0,0);
        boolean wposition = false ;
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setY(moveto.getY()+1, wposition);
        if(moveto.isEmpty(cartCase)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX()+1, wposition);
        if(moveto.isEmpty(cartCase)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX()- 1, wposition);
        if(moveto.isEmpty(cartCase)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX()- 1, wposition);
        moveto.setY(moveto.getY() - 1, wposition);
        if(moveto.isEmpty(caseCart)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX() + 1, wposition);
        moveto.setY(moveto.getY() - 1, wposition);
        if(moveto.isEmpty(caseCart)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX()- 1, wposition);
        moveto.setY(moveto.getY() + 1, wposition);
        if(moveto.isEmpty(caseCart)){
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
        wposition = moveto.setPosition(this.getposition().getX(), this.getposition().getY()); 
        moveto.setX(moveto.getX()+ 1, wposition);
        moveto.setY(moveto.getY() + 1, wposition);
        if(moveto.isEmpty(caseCart)){
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

    
        public void afficherInventaire() {

            System.out.println("Voici ce qu'il y a dans l'inventaire ");
            System.out.println("Quantité de viande : " + this.invent.getQtebois());
            System.out.println("Quantité de fruit : " + this.invent.getQtecailloux());
            System.out.println("Quantité de bois : " + this.invent.getQtefruit());
            System.out.println("Quantité de cailloux : " + this.invent.getQteviande());

            System.out.println("Voici les outils que tu as dans ton inventaire");
            
            for(Tool outil : this.invent.getArsenal()){
                System.out.println(outil.getName());

            } 
        }
    
    }
    



        /*String nomOutil ="Axe";
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
        //  Carte.supprimer(arbre);*/
    

    /*public void demanderCouperBois(Arbre arbre){

        boolean veutcouper = demandeUtilisateur("souhaites tu couper du bois?");
            if(veutcouper){
                couperBois(arbre,invent);
            } else{
                    System.out.println("Francis ne veut pas couper du bois");
                } 
    }  

    public void chasser(Animal animal , Inventaire invent){

        //TODO
    }

    /*public void demanderChasserherbivore(Homme homme, Herbivore herbivore){
        boolean veutchasser = demandeUtilisateur("Souhaites tu chasser l'animal?");
        if(veutchasser){
            //TODO chasser(homme,outil,herbivore); // à implémenter
        } else{
            System.out.println("L'homme ne veut pas chasser l'animal");
        } 
    } 

    public void demanderecolterFruit(Homme homme, Arbrefruit arbref){
        boolean recolterf = demandeUtilisateur("souhaites turecolter des fruits?");
        if(recolterf){
            //TODO recolterfruit(homme, arbref); // a impléménter
        } else{
            System.out.println("l'homme ne souhaite pas recolter de fruits");
        } 
    }

    public void contactCarnivore(Homme homme){
        TODO for(Animal animal : desAnimaux){
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
        recolterbois(outil,vegetal)?? si pas encore d'outil utilise sa force 
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
    }*/
}

       