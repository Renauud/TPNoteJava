package com.example.javavraidernierv2;

public class Pizza {

    private String nom;
    private double prix;
    private int nb_ingredients;

    public Pizza(String nom, double prix, int nb_ingredients) {
        this.nom = nom;
        this.prix = prix;
        this.nb_ingredients = nb_ingredients;
    }
    public Pizza() {}

     public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNb_ingredients() {
        return nb_ingredients;
    }

    public void setNb_ingredients(int nb_ingredients) {
        this.nb_ingredients = nb_ingredients;
    }

}

