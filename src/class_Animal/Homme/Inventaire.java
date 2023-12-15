package class_Animal.Homme;

import java.util.ArrayList;

/**
 * La classe Inventaire représente l'inventaire d'un homme dans le jeu.
 * Il stocke la quantité de différentes ressources (bois, fruits, viande, cailloux) ainsi qu'une liste d'outils.
 */
public class Inventaire {
    private int qtebois;
    private int qtefruit;
    private int qteviande;
    private int qtecailloux;
    private ArrayList<Tool> arsenal = new ArrayList<Tool>();

    public Inventaire(int qtebois, int qtefruit, int qteviande, int qtecailloux, ArrayList<Tool> arsenal) {
        this.qtebois = qtebois;
        this.qtefruit = qtefruit;
        this.qteviande = qteviande;
        this.qtecailloux = qtecailloux;
        this.arsenal = arsenal;
    }
    

    //les getters et les setters
    public int getQtebois() {
        return this.qtebois;
    }

    public void setQtebois(int qtebois) {
        this.qtebois = qtebois;
    }

    public int getQtefruit() {
        return this.qtefruit;
    }

    public void setQtefruit(int qtefruit) {
        this.qtefruit = qtefruit;
    }

    public int getQteviande() {
        return this.qteviande;
    }

    public void setQteviande(int qteviande) {
        this.qteviande = qteviande;
    }

    public int getQtecailloux() {
        return this.qtecailloux;
    }

    public void setQtecailloux(int qtecailloux) {
        this.qtecailloux = qtecailloux;
    }

    public ArrayList<Tool> getArsenal() {
        return this.arsenal;
    }

    public void setArsenal(ArrayList<Tool> arsenal) {
        this.arsenal = arsenal;
    }

    /**
     * Ajoute une quantité spécifiée de bois à l'inventaire.
     *
     * @param quantity La quantité de bois à ajouter.
     */
    public void ajouterBois(int quantity){
        this.qtebois += quantity;
    } 

    /**
     * Ajoute une quantité spécifiée de viande à l'inventaire.
     *
     * @param quantityV La quantité de viande à ajouter.
     */
    public void ajouterViande(int quantityV){
        this.qteviande += quantityV;
    } 
    
    /**
    * Ajoute une quantité spécifiée de cailloux à l'inventaire.
    *
    * @param qtyCailloux La quantité de cailloux à ajouter.
    */
    public void ajouterCailloux(int qtyCailloux){
        this.qtecailloux += qtyCailloux;
    } 

    /**
     * Ajoute une quantité spécifiée de fruits à l'inventaire.
     *
     * @param qtyfruit La quantité de fruits à ajouter.
     */
    public void ajouterFruit(int qtyfruit){
        this.qtefruit += qtyfruit ;
    }

    /**
     * Ajoute un outil spécifié à l'arsenal de l'inventaire.
     *
     * @param outil L'outil à ajouter.
     */
    public void ajouterOutil(Tool outil){
        arsenal.add(outil);
    } 

    /**
     * Obtient un outil spécifié de l'arsenal de l'inventaire.
     *
     * @param nameTool Le nom de l'outil à rechercher.
     * @return L'outil correspondant au nom spécifié, ou null s'il n'est pas trouvé.
     */
    public Tool getTool(String nameTool){
        for(Tool atool : arsenal ){
            if(atool.getName() == nameTool){
                return atool;
            } 
        } 
        return null; // l'outil n'a pas été trouvé
    } 
} 