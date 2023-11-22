package com;


public class Axe extends Tool {

    String material;

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Axe() {

    }


    public Axe(String material) {
        this.material = material;
    }
    
}