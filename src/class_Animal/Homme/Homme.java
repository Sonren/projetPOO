package class_Animal.Homme;

import java.util.ArrayList;
import java.util.Scanner;

import class_Animal.Animal;
import class_Biome.Biome;
import class_Biome.Biomes;
import class_Carte.Position;
import class_Vegetal.Vegetal;
import class_Carte.Case;
import class_Vegetal.Arbre;
import class_Vegetal.Arbrefruit;
import class_Vegetal.Rocher;

public class Homme extends Animal {
    ArrayList<Tool> ars = new ArrayList<Tool>();
    public Inventaire invent = new Inventaire(0, 0, 0, 0, ars);

    public Homme(String n, int l, int s,Position p, Biome b) {
        super(n,l,s,p,b);
    }
    
    //getters et setters
    public Inventaire getInvent() {
        return this.invent;
    }

    public void setInvent(Inventaire invent) {
        this.invent = invent;
    }

    public boolean demandeUtilisateur(String message, Scanner scanner){
        boolean answer;
        System.out.println(message + " Oui(true)/Non(false)"); 
        answer = scanner.nextBoolean();
        return answer;
    }

    public String demandeUtilisateurstr(String message, Scanner scanner){
        String answer;
        System.out.println(message); 
        scanner.nextLine();
        answer = scanner.nextLine();
        return answer;
    }

    public int demandeUtilisateurint(String message, Scanner scanner){
        int answer;
        System.out.println(message); 
        answer = scanner.nextInt();
        return answer;
    }
    
    public boolean isValidCoordinate(int value){
        return value >= 0 && value <=9 ;
    } 

    public void endgame(){
        System.exit(0);
    }
   

//--------------------------------------------------------------------------------------------------
    //fonction de vérification 

    /**
     * 
     * @param map
     * @param posarriv
     * @return
     */
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

    /**
     * 
     * @param pos
     * @param plain
     * @param forest
     */
    public void GoodBiomehuman(Position pos, Biome plain, Biome forest) {
        if (this.getbiome().getName() == Biomes.FORET.getNom()){
            if (pos.getY() < 4){
                System.out.println("vous etes dans la forêt");
            }else{
                if(pos.getY() < 9 && pos.getY() >=4){
                    this.setbiome(plain);
                    System.out.println("Vous changez de biome , vous arrivez dans la : " + this.getbiome().getName());
                }else if(pos.getY() >= 9){
                    System.out.println("Vous ne pouvez aller dans la mer");
                    pos.setPosition(pos.getX(), pos.getY() - 1);
                }
            }
        }else if(this.getbiome().getName() == Biomes.PLAINE.getNom()){
            if(pos.getY() < 9 && pos.getY() >=4){
                System.out.println("vous êtes dans la plaine");
            }else if(pos.getY() < 4){
                this.setbiome(forest);
                System.out.println("Vous changez de biome , vous arrivez dans la : " + this.getbiome().getName());
            }else if(pos.getY() >= 9){
                    System.out.println("Vous ne pouvez aller dans la mer");
                    pos.setPosition(pos.getX(), pos.getY() - 1);
            }
        }
    }

    /**
     * 
     * @param toolname
     * @return
     */
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

//--------------------------------------------------------------------------------------------------------
    //fonction de recherche

    /**
     * 
     * @param invent
     * @param name
     * @return
     */
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

    /**
     * 
     * @param temppos
     * @param gamemap
     * @param bio
     * @return
     */
    public Vegetal findVegetal(Position temppos, Case[][] gamemap, Biome bio){
        for(Vegetal veg : bio.getflore()){
            if(veg.getposition().getX() == temppos.getX() && veg.getposition().getY() == temppos.getY()){
                if(veg.isDeadveg() == false){
                    System.out.println("végétal rencontré = " + veg.getname());
                    return veg;
                }else{
                    System.out.println("l'abre a déja été coupé");
                    return veg;//on retourne ici l'animal mort et on gère le cas au dessus
                }
            }
        }
        bio.afficheFlore();
        System.out.println("aucun arbre trouvé");
        return null;
    }

    /**
     * 
     * @param temppos
     * @param gamemap
     * @param bio
     * @return
     */
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

    /**
     * 
     * @param moveto
     * @param map
     * @param bio
     * @return
     */
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

//----------------------------------------------------------------------------------------------------------------
    //fonction d'action

    /**
     * procédure qui permet a l'Homme de miner des rochers et donc de récupérer une quantité de cailloux dans son inventaire
     * @param rock le rocher qui se situe a la position ou l'homme veut aller
     * @param map plateau de jeu ou sont contenu les objet et l'Homme
     * @param pos Position d'arrivé de l'Homme 
     */
    public void miner(Rocher rock, Case[][] map, Position pos){
        if(this.hasTool(Tools.PIOCHE.getNom())){
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

    /**
     * procédure qui permet de couper du bois et qui rajoute du bois a l'inventaire
     * @param arbre l'arbre qui se situe a la position ou l'homme veut aller
     * @param map plateau de jeu ou sont contenu les objet et l'Homme
     * @param pos Position d'arrivé de l'Homme
     */
    public void couperBois(Vegetal arbre, Case[][] map, Position pos){
        if(this.hasTool(Tools.HACHE.getNom())){
            System.out.println("vous utilisez une Hache pour couper du bois");
            this.getInvent().ajouterBois(arbre.getnbbois());
            map[pos.getX()][pos.getY()].setisvegetal(false);
            System.out.println(arbre.getnbbois() + " morceau de bois on été ajouté a l'inventaire");
        }else{
            System.out.println("Vous coupez l'abre a la main");
            this.levellife -= 3;
            this.getInvent().ajouterBois(arbre.getnbbois());
            System.out.println(arbre.getnbbois() + " morceau de bois on été ajouté a l'inventaire");
            map[pos.getX()][pos.getY()].setisvegetal(false);
            System.out.println("votre niveau de vie actuel : " + this.getlevellife());
        }
    }

    /**
     * procédure qui permet a l'Homme de récupérer des fruits sur l'arbre sur laquelle il tombe
     * @param vegfind arbre sur lequel l'Homme doit se trouver
     * @param wrlmaple plateau de jeu ou sont contenu les objet et l'Homme
     * @param arrivedpos Position d'arrivé de l'Homme
     */
    public void recoltefruit(Vegetal vegfind, Case[][] wrlmap, Position arrivedpos){
        System.out.println("vous avez ramassé : " + ((Arbrefruit) vegfind).getnbfruit() + " fruits");
        this.getInvent().ajouterFruit(((Arbrefruit) vegfind).getnbfruit());
        wrlmap[arrivedpos.getX()][arrivedpos.getY()].setisvegetal(false); 
    }

//------------------------------------------------------------------------------------------------------------
    //fonction qui gère les rencontres

    /**
     * Interagit avec un élément végétal sur une case spécifique.
     * @param map     La carte contenant les cases et les éléments.
     * @param pos     Position sur laquelle l'Homme doit arriver.
     * @param sca     Scanner pour la saisie utilisateur.
     * @return        La nouvelle position de l'Homme après l'interaction.
     */
    public Position hommeMeetVegetal(Case[][] map, Position pos, Scanner sca){
        Vegetal findveg;
        System.out.println("il y a un vegetal sur la case");
        findveg = findVegetal(pos, map, this.getbiome());
        if(findveg instanceof Arbrefruit){
            if(demandeUtilisateur("voulez vous ramassez des fruits", sca)){
                recoltefruit(findveg, map, pos);
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
        }else if(findveg instanceof Arbre){
            if(demandeUtilisateur("voulez vous coupez du bois", sca)){
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
        return null;
    }

    /**
     * Interagit avec un animal carnivore sur une case spécifique.
     * @param cart     La carte contenant les cases et les éléments.
     * @param pos      Position sur laquelle l'Homme doit arriver.
     * @param scanne   Scanner pour la saisie utilisateur.
     * @param plaine   le Biome plaine qui est utilisé dans correctMove
     * @param foret    le Biome foret qui est utilisé dans correctMove
     * @return         La nouvelle position de l'Homme après l'interaction.
     */
    public Position HommeMeetCarnivore(Case[][] cart, Position pos, Scanner scanne, Biome plaine, Biome foret){
        boolean veutfuir = demandeUtilisateur("francis souhaites tu fuir?", scanne);
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
                    this.correctMove(cart, scanne, plaine, foret);
                    return this.getposition();
                }else{
                    if(this.getstrength()<= findanimal.getstrength()){
                        this.isDead = true;
                        System.out.println("Vous etes mort");
                        this.endgame();
                    } 
                }
            } 
        }
        System.out.println("on a pas trouvé d'animal");
        return null;
    }

    /**
     * Interagit avec un animal herbivore sur une case spécifique.
     * @param map      La carte contenant les cases et les éléments.
     * @param pos      Position sur laquelle l'Homme doit arriver.
     * @param scan     Scanner pour la saisie utilisateur.
     * @param pla      le Biome plaine qui est utilisé dans correctMove
     * @param fo       le Biome foret qui est utilisé dans correctMove
     * @return         La nouvelle position de l'Homme après l'interaction.
     */
    public Position chasser(Case[][] map, Position pos, Scanner scan, Biome pla, Biome fo){
        Animal findanimal;
        findanimal = this.findAnimal(pos, map, this.getbiome());
        int qtyViandeH = 3 ;
        if(findanimal.isHerbivore()==true){
            if(this.hasTool(Tools.LANCE.getNom())){
                System.out.println(" On a bien la lance, tu peux chasser");
                this.getInvent().ajouterViande(qtyViandeH);
                this.levellife +=3 ;
                map[pos.getX()][pos.getY()].setisanimal(false);
                findanimal.killedAnimal(findanimal);
                System.out.println(" Nous avons rajouté 3 morceaux de viandes à l'inventaire");
                System.out.println("*******************");
                System.out.println("position changé");
                System.out.println("*******************");
                map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition(pos);
                map[pos.getX()][pos.getY()].setisanimal(true);
                return this.getposition();
            }else{
                System.out.println("Francis tu n'as pas d'outils on va utiliser les mains");
                this.levellife -= 3;
                this.getInvent().ajouterViande(qtyViandeH);
                System.out.println( "on a pu récupérer 3 morceaux de viande dans l'inventaire");
                map[pos.getX()][pos.getY()].setisanimal(false);
                findanimal.killedAnimal(findanimal);
                System.out.println("Tu as  " + this.getlevellife()+ "de points de vie");
                System.out.println("*******************");
                System.out.println("position changé");
                System.out.println("*******************");
                map[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
                this.setposition(pos);
                map[pos.getX()][pos.getY()].setisanimal(true);
                return this.getposition();
            }
        } else{
            if(findanimal.isCarnivore() == true|| findanimal.isOmnivore() == true){
                return this.HommeMeetCarnivore(map, pos, scan, pla, fo);
            } 
        } 
        System.out.println("Cet animal n'est pas un herbivore! et on na chasse que les herbivore");
        return null;
    }

    /**
     * Interagit avec un rocher sur une case spécifique.
     * @param map      La carte contenant les cases et les éléments.
     * @param pos      Position sur laquelle l'Homme doit arriver.
     * @param scan     Scanner pour la saisie utilisateur.
     * @return         La nouvelle position de l'Homme après l'interaction.
     */
    public Position hommeMeetRocher(Case[][] map, Position pos, Scanner scan){
        Rocher findrock;
        System.out.println("il y a un rocher sur la case");
        if(demandeUtilisateur("Voulez vous le minez ?", scan)){
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


//-----------------------------------------------------------------------------------------------
    //Mouvement haut bas droite gauche

    /**
     * Déplace l'Homme vers le haut sur la carte, en vérifiant si la position d'arrivé ne comporte aucun conflit et ci-orrige le conflit si jamais il y en a.
     *
     * @param cartCase   La carte contenant les cases et les éléments.
     * @param pla        Le biome plaine.
     * @param fore       Le biome forêt.
     * @param scanner    Scanner pour la saisie utilisateur.
     * @return           La nouvelle position de l'Homme après le déplacement.
     */
    public Position haut (Case[][] cartCase, Biome pla, Biome fore, Scanner scanner){
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
                this.actionHomme(scanner, cartCase, pla, fore);
            }
        }else{
            GoodBiomehuman(moveto, pla, fore);
            if(cartCase[moveto.getX()][moveto.getY()].getisvegetal()){
                return hommeMeetVegetal(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisrocher()){
                System.out.println("il y a un rocher sur la case");
                return hommeMeetRocher(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisanimal()){
                System.out.println("il y a un animal sur la case");
                return chasser(cartCase, moveto, scanner, pla, fore);
            }
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            cartCase[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(moveto);
            cartCase[moveto.getX()][moveto.getY()].setisanimal(true);
        }
        return null;
    }
         
    /**
     * Déplace l'Homme vers le bas sur la carte, en vérifiant si la position d'arrivé ne comporte aucun conflit et ci-orrige le conflit si jamais il y en a.
     *
     * @param cartCase   La carte contenant les cases et les éléments.
     * @param pla        Le biome plaine.
     * @param fore       Le biome forêt.
     * @param scanner    Scanner pour la saisie utilisateur.
     * @return           La nouvelle position de l'Homme après le déplacement.
     */
    public Position bas (Case[][] cartCase, Biome pla, Biome fore, Scanner scanner){
        Position moveto = new Position(0,0);
        boolean goodHPosition = false;
        boolean result;
        System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
        goodHPosition = moveto.setPosition(this.getposition().getX(), this.getposition().getY() + 1);
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
                this.actionHomme(scanner, cartCase, pla, fore);
            }
        }else{
            GoodBiomehuman(moveto, pla, fore);
            if(cartCase[moveto.getX()][moveto.getY()].getisvegetal()){
                return hommeMeetVegetal(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisrocher()){
                System.out.println("il y a un rocher sur la case");
                return hommeMeetRocher(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisanimal()){
                System.out.println("il y a un animal sur la case");
                return chasser(cartCase, moveto, scanner, pla, fore); 
            }
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            cartCase[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(moveto);
            cartCase[moveto.getX()][moveto.getY()].setisanimal(true);
        }
        return null;
    }

    /**
     * Déplace l'Homme vers le droite sur la carte, en vérifiant si la position d'arrivé ne comporte aucun conflit et ci-orrige le conflit si jamais il y en a.
     *
     * @param cartCase   La carte contenant les cases et les éléments.
     * @param pla        Le biome plaine.
     * @param fore       Le biome forêt.
     * @param scanner    Scanner pour la saisie utilisateur.
     * @return           La nouvelle position de l'Homme après le déplacement.
     */
    public Position droite (Case[][] cartCase, Biome pla, Biome fore, Scanner scanner){
       Position moveto = new Position(0,0);
        boolean goodHPosition = false;
        boolean result;
        System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
        goodHPosition = moveto.setPosition(this.getposition().getX() + 1, this.getposition().getY());
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
                this.actionHomme(scanner, cartCase, pla, fore);
            }
        }else{
            GoodBiomehuman(moveto, pla, fore);
            if(cartCase[moveto.getX()][moveto.getY()].getisvegetal()){
                return hommeMeetVegetal(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisrocher()){
                System.out.println("il y a un rocher sur la case");
                return hommeMeetRocher(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisanimal()){
                System.out.println("il y a un animal sur la case");
                return chasser(cartCase, moveto, scanner, pla, fore);
            }
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            cartCase[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(moveto);
            cartCase[moveto.getX()][moveto.getY()].setisanimal(true);
        }
        return null;
    }

    /**
     * Déplace l'Homme vers la gauche sur la carte, en vérifiant si la position d'arrivé ne comporte aucun conflit et ci-orrige le conflit si jamais il y en a.
     *
     * @param cartCase   La carte contenant les cases et les éléments.
     * @param pla        Le biome plaine.
     * @param fore       Le biome forêt.
     * @param scanner    Scanner pour la saisie utilisateur.
     * @return           La nouvelle position de l'Homme après le déplacement.
     */
    public Position gauche (Case[][] cartCase, Biome pla, Biome fore, Scanner scanner){
        Position moveto = new Position(0,0);
        boolean goodHPosition = false;
        boolean result;
        System.out.println("x = " + this.getposition().getX() + " y = " + this.getposition().getY());
        goodHPosition = moveto.setPosition(this.getposition().getX() - 1, this.getposition().getY());
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
                this.actionHomme(scanner, cartCase, pla, fore);
            }
        }else{
            GoodBiomehuman(moveto, pla, fore);
            if(cartCase[moveto.getX()][moveto.getY()].getisvegetal()){
                return hommeMeetVegetal(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisrocher()){
                System.out.println("il y a un rocher sur la case");
                return hommeMeetRocher(cartCase, moveto, scanner);
            }else if (cartCase[moveto.getX()][moveto.getY()].getisanimal()){
                System.out.println("il y a un animal sur la case");
                return chasser(cartCase, moveto, scanner, pla, fore);
            }
            System.out.println("*******************");
            System.out.println("position changé");
            System.out.println("*******************");
            cartCase[this.getposition().getX()][this.getposition().getY()].setisanimal(false);
            this.setposition(moveto);
            cartCase[moveto.getX()][moveto.getY()].setisanimal(true);
        }
        return null;
    }


    /**
     * Demande à l'utilisateur de saisir de nouvelles coordonnées (x, y) et crée une nouvelle position.
     *
     * @param sc Le scanner pour la saisie utilisateur.
     * @return La nouvelle position créée à partir des coordonnées saisies.
     */
    public Position askPosition(Scanner sc){
        System.out.println("Entrez la nouvelle coordonnée de x entre 0 et 9");
        int newX = sc.nextInt();
        System.out.println("Entrez la nouvelle coordonnée de Y entre 0 et 9");
        int newY = sc.nextInt();
        Position nextMove = new Position(newX, newY);
        return nextMove;
    }

    /**
     * Demande à l'utilisateur de choisir une direction de déplacement et effectue le déplacement en conséquence.
     *
     * @param cartCase La carte contenant les cases et les éléments.
     * @param scanner  Le scanner pour la saisie utilisateur.
     * @param pl       Le biome plaine.
     * @param f        Le biome forêt.
     * @return         La nouvelle position après le déplacement, ou la position actuelle si le choix est invalide.
     */
    public Position correctMove(Case[][] cartCase, Scanner scanner, Biome pl, Biome f){

        System.out.println("Vers ou voulez vous allez ? ");
        System.out.println("1. Vers le haut");
        System.out.println("2. Vers le bas");
        System.out.println("3. Vers la droite");
        System.out.println("4. Vers la gauche");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return haut(cartCase, biome, biome, scanner);
                
            case 2:
                return bas(cartCase, pl, f, scanner);
            
            case 3:
                return droite(cartCase, pl, f, scanner);
                
            case 4:
                return gauche(cartCase, pl, f, scanner);
                
            default:
                return this.getposition();
        }
    }
       
    

//-------------------------------------------------------------------------------------------------------------------------------------------------------
    //action que l'utilisateur peut effectuer

    /**
     * Demande à l'utilisateur de choisir une action parmi plusieurs options.
     *
     * @param scan Le scanner pour la saisie utilisateur.
     * @return Le choix de l'utilisateur.
     */
    public int askAction (Scanner scan){
        int answer;
        answer = demandeUtilisateurint("Que veux tu faire ? " + "\n" + "\n" + "1. Afficher l'inventaire" + "\n" + "2. Me déplacer" + "\n" + "3. Manger" + "\n" + "4. Fabriquer un outil" + "\n" + "5. Afficher le contenu de la plaine" + "\n" + "6. Afficher le contenue de la forêt" + "\n" + "7. Afficher sa position" + "\n" + "8. Quitter la simulation" + "\n", scan);
        return answer;
    }
    
    /**
     * Exécute une action spécifique en fonction du choix de l'utilisateur.
     *
     * @param scanner Le scanner pour la saisie utilisateur.
     * @param map     La carte contenant les cases et les éléments.
     * @param pla     Le biome plaine.
     * @param fo      Le biome forêt.
     * @return        Un indicateur indiquant si le jeu doit continuer après l'action.
     */
    public boolean actionHomme(Scanner scanner, Case[][] map, Biome pla, Biome fo) {
        boolean gamecontinue = true;
        int choice;
        
        choice = askAction(scanner);
        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8){
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8) {
            System.out.println("Veuillez rentrer un choix valide");
            askAction(scanner);
            }
        }

        switch (choice) {
            case 1:
                this.afficherInventaire();
                return gamecontinue;
                
            case 2:
                this.askdeplacer(map, pla, fo, scanner);
                return gamecontinue;
            
            case 3:
                this.askmanger(scanner);
                return gamecontinue;
                
            case 4:
                this.askfabriquerOutil(scanner);
                return gamecontinue;

            case 5:
                pla.afficheFaune();
                pla.afficheFlore();
                return gamecontinue;

            case 6:
                fo.afficheFaune();
                fo.afficheFlore();
                fo.affichegeologie();
                return gamecontinue;
            
            case 7:
                System.out.println("\n" + "Vous êtes dans la " + this.getbiome().getName() + " a la position : x = " + this.getposition().getX() + " y = " + this.getposition().getY() + "\n");
                return gamecontinue;

            case 8:
                System.exit(0);
                gamecontinue = false;
                return gamecontinue;

            default:
                System.out.println("Choix invalide.");
                return gamecontinue;
        }
    }

    /**
     * Demande à l'utilisateur de choisir un type de nourriture (viande ou fruit) et effectue l'action de manger.
     *
     * @param scan Le scanner pour la saisie utilisateur.
     */
    public void askmanger (Scanner scan){
        String reponse;
        reponse = demandeUtilisateurstr("\n" + "Que voulez vous manger ? (viande, fruit)", scan);
        manger(scan, reponse);
         
    }

    /**
     * Demande à l'utilisateur de choisir un type de nourriture (viande ou fruit) et effectue l'action de manger, il recommence jusqu'a ce que la saisie soit bonne.
     *
     * @param sc     Le scanner pour la saisie utilisateur.
     * @param answer Le type de nourriture choisi par l'utilisateur.
     */
    public void manger (Scanner sc, String answer){
        if(answer.equals("viande")){
            this.mangerViande(sc);
            System.out.println("Francis mange de la viande");
        } else if(answer.equals("fruit")){
            this.mangerFruit(sc);
            System.out.println("Francis mange des fruits");
        }else if(!(answer.equals("viande")) && !(answer.equals("fruit"))){
            System.out.println("veuillez donner une nourriture correcte");
            askmanger(sc);
        }
    }


    /**
     * Permet à l'animal de manger des fruits en demandant à l'utilisateur la quantité à consommer.
     *
     * @param scanner Le scanner pour la saisie utilisateur.
     */
    public void mangerFruit(Scanner scanner) {
        if (this.invent.getQtefruit() > 0) {
            System.out.println("Combien de fruits voulez-vous manger ?");
            int quantite = scanner.nextInt();
            if (quantite > 0 && quantite <= this.invent.getQtefruit()) {
                System.out.println("Vous mangez " + quantite + " fruits.");
                this.invent.setQtefruit(this.invent.getQtefruit()-quantite);; // Retirer la quantité de fruits de l'inventaire
                this.levellife += quantite * 2; // Ajuster les points de vie en fonction de la quantité de fruits
            } else {
                System.out.println("Quantité invalide ou insuffisante.");
            }
        } else {
            System.out.println("Vous n'avez pas de fruits dans votre inventaire.");
        }
    }


        
    /**
     * Permet à l'animal de manger de la viande en demandant à l'utilisateur la quantité à consommer.
     *
     * @param scanner Le scanner pour la saisie utilisateur.
     */
    public void mangerViande(Scanner scanner) {
        if (this.invent.getQteviande() > 0) {
            System.out.println("Combien de viande veux-tu manger ?");
            int quantite = scanner.nextInt();
            if (quantite > 0 && quantite <= this.invent.getQteviande()) {
                System.out.println("Vous mangez " + quantite + " morceaux de viande.");
                this.invent.setQteviande(this.invent.getQteviande()-quantite); // Retirer la quantité  de viande de l'inventaire
                this.levellife += quantite * 2; // Ajuster les points de vie en fonction de la quantité de viande
            } else {
                System.out.println("Quantité invalide ou insuffisante.");
            }
        } else {
            System.out.println("Vous n'avez pas de viande dans votre inventaire.");
        }
    }

    /**
     * Demande à l'utilisateur de choisir un outil à fabriquer et appelle la méthode correspondante pour la fabrication.
     *
     * @param scan Le scanner pour la saisie utilisateur.
     */
    public void askfabriquerOutil(Scanner scan){ 
        String answer;

        answer =demandeUtilisateurstr("\n" + "Quel outil voulez-vous fabriquer ? (hache, pioche, lance)", scan);
        fabriquerOutil(scan, answer);
    }

    /**
     * Fabrique un outil en fonction du type spécifié par l'utilisateur.
     *
     * @param sc  Le scanner pour la saisie utilisateur.
     * @param ans Le type d'outil à fabriquer (pioche, hache, lance).
     */
    public void fabriquerOutil (Scanner sc, String ans){
        if(ans.equals("pioche")){
            System.out.println("Francis veut fabriquer une pioche");
            this.fabriquerPickaxe();
        }else if (ans.equals("hache")){
            System.out.println("Francis souhaite fabriquer une hache");
            this.fabriquerAxe();
        }else if (ans.equals("lance")){
            System.out.println("Francis souhaite fabriquer une lance");
            this.fabriquerspear();
        }else if(!(ans.equals("pioche")) && !(ans.equals("hache")) && !(ans.equals("lance"))){
            System.out.println("Veuillez choisir un outil correct");
            askfabriquerOutil(sc);
        }
    }

    /**
     * Fabrique une lance à condition d'avoir les ressources nécessaires.
     * La fabrication nécessite 1 caillou et 2 morceaux de bois.
     */
    public void fabriquerspear(){
        if(this.invent.getQtecailloux() >=1 && this.invent.getQtebois()>=2){
            this.invent.setQtecailloux(this.invent.getQtecailloux()-1);
            this.invent.setQtebois(this.invent.getQtebois()-2);
            invent.ajouterOutil(new Spear("lance"));
            System.out.println("Bravo Francis! tu as fabriqué une lance");
        } else{
            System.out.println("oh oooh ... t'as pas assez de ressources");
        } 
    } 

    /**
     * Fabrique une hache à condition d'avoir les ressources nécessaires.
     * La fabrication nécessite 2 morceaux de bois et 3 cailloux.
     */
    public void fabriquerAxe(){
        if(this.invent.getQtecailloux()>=3 && this.invent.getQtebois()>=2){
            this.invent.setQtebois(this.invent.getQtebois()-2);
            this.invent.setQtecailloux(this.invent.getQtecailloux()-3);
            this.invent.ajouterOutil(new Axe("axe"));
            System.out.println("bravo! tu viens de fabriquer une hache!");
        } else{
            System.out.println("Dommage, nous n'avons pas assez de ressources pour fabriquer une hache :(");
        } 
    }

    /**
     * Fabrique une pioche à condition d'avoir les ressources nécessaires.
     * La fabrication nécessite 3 cailloux et 2 morceaux de bois.
     */
    public void fabriquerPickaxe(){
        if(this.invent.getQtecailloux() >=3 && this.invent.getQtebois()>=2){
            this.invent.setQtecailloux(this.invent.getQtecailloux()-3);
            this.invent.setQtebois(this.invent.getQtebois()-2);
            this.invent.ajouterOutil(new Pickaxe("Pioche"));
            System.out.println("Bravo Francis! tu as fabriqué une Pioche");
        } else{
            System.out.println("Aie, va falloir recolter plus de bois et caillous Francis!");
        } 
    } 

    /**
     * Affiche le contenu de l'inventaire, y compris la quantité de ressources et la liste des outils.
     */
    public void afficherInventaire() {
        if(this.getInvent() != null){
            System.out.println("\n" + "Voici ce qu'il y a dans l'inventaire ");
            System.out.println("Quantité de viande : " + this.invent.getQteviande());
            System.out.println("Quantité de fruit : " + this.invent.getQtefruit());
            System.out.println("Quantité de bois : " + this.invent.getQtebois());
            System.out.println("Quantité de cailloux : " + this.invent.getQtecailloux());

            System.out.println("Voici les outils que tu as dans ton inventaire");
            if(this.getInvent().getArsenal() != null){
                for(Tool outil : this.invent.getArsenal()){
                    System.out.println(outil.getName());

                }
            }else{
                System.out.println("Vous n'avez aucun outil dans l'arsenal");
            }
        }else{
            System.out.println("l'inventaire est vide");
        }
    }

    /**
     * Demande à l'utilisateur la direction dans laquelle il souhaite se déplacer et appelle la méthode correspondante.
     *
     * @param mapcart La carte contenant les cases et les éléments.
     * @param plaine  Le biome de la plaine.
     * @param flo     Le biome de la forêt.
     * @param scann   Le scanner pour la saisie utilisateur.
     */
    public void askdeplacer (Case [][] mapcart , Biome plaine, Biome flo, Scanner scann){
        String answer; 

        answer = demandeUtilisateurstr("dans quel direction voulez-vous allez (haut, bas, droite, gauche)", scann);
        this.deplacer(mapcart, plaine, flo, scann, answer);
    }

    /**
     * Déplace l'animal dans la direction spécifiée par l'utilisateur.
     *
     * @param mapcart La carte contenant les cases et les éléments.
     * @param plaine  Le biome de la plaine.
     * @param flo     Le biome de la forêt.
     * @param scann   Le scanner pour la saisie utilisateur.
     * @param reponse La direction dans laquelle l'animal souhaite se déplacer (haut, bas, droite, gauche).
     */
    public void deplacer (Case [][] mapcart , Biome plaine, Biome flo, Scanner scann, String reponse){
        if(reponse.equals("haut")){
            System.out.println("Francis  souhaite aller en haut");
            this.haut(mapcart,plaine,flo, scann);
        }else if(reponse.equals("bas")){
            System.out.println("Francis  souhaite aller en bas");
            this.bas(mapcart, plaine, flo, scann);
        }else if(reponse.equals("gauche")){
            System.out.println("Francis  souhaite aller à gauche");
            this.gauche(mapcart, plaine, flo, scann);
        }else if(reponse.equals("droite")){
            System.out.println("Francis  souhaite aller à droite");
            this.droite(mapcart, plaine, flo, scann);
        }else if(!(reponse.equals("haut")) && !(reponse.equals("bas")) && !(reponse.equals("droite")) && !(reponse.equals("gauche"))){
            System.out.println("Veuillez-fournir une position correcte");
            askdeplacer(mapcart, plaine, flo, scann);
        }
    }
}

       