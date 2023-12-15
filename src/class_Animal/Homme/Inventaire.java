package class_Animal.Homme;

import java.util.ArrayList;


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

    public void ajouterBois(int quantity){
        this.qtebois = quantity;
    } 

    public void ajouterViande(int quantityV){
        this.qteviande = quantityV;
    } 
    
    public void ajouterCailloux(int qtyCailloux){
        this.qtecailloux = qtyCailloux;
    } 
    public void ajouterFruit(int qtyfruit){
        this.qtefruit = qtyfruit ;
    }
    public void ajouterOutil(Tool outil){
        arsenal.add(outil);
    } 

    public Tool getTool(String nameTool){
        for(Tool atool : arsenal ){
            if(atool.getName() == nameTool){
                return atool;
            } 
        } 
        return null; // l'outil n'a pas été trouvé
    } 
} 