package class_Animal.Homme;

import java.util.ArrayList;

import javax.tools.Tool;

public class Inventaire {
    private int qtebois;
    private int qtefruit;
    private int qteviande;
    private int qtecailloux;
    private ArrayList<Tool> arsenal = new ArrayList<>();

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




}