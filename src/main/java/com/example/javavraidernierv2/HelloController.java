package com.example.javavraidernierv2;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TableView table;
    @FXML
    private TableColumn<Pizza, String> colNom;
    @FXML
    private TableColumn<Pizza, Double> colPrix;
    @FXML
    private TableColumn<Pizza, Integer> colIngredients;
    @FXML
    private TextField nomField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField nbIngredientsField;
    @FXML
    private Button addPizza;
    @FXML
    private Button deleteTab;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

         colNom.setCellValueFactory(new PropertyValueFactory<Pizza, String>("nom"));
         colPrix.setCellValueFactory(new PropertyValueFactory<Pizza, Double>("prix"));
         colIngredients.setCellValueFactory(new PropertyValueFactory<Pizza, Integer>("nb_ingredients"));


         List<Pizza> pizzas = pizzaDAO.getPizzas();

         for (int i = 0; i < pizzas.size(); i++){
             Pizza pizza = new Pizza();
             pizza.setNom(pizzas.get(i).getNom());
             pizza.setPrix(pizzas.get(i).getPrix());
             pizza.setNb_ingredients(pizzas.get(i).getNb_ingredients());
             table.getItems().add(pizzas);
         }

    }

    public void ajouterPizzaDansTab(String nom, double prix, int nb_ingredients){
        Pizza pizza = new Pizza(nom, prix, nb_ingredients);


        ObservableList<Pizza> pizzas = table.getItems();
        pizzas.add(pizza);
        table.setItems(pizzas);
    }

    public void ajouterPizza(){
        String nom = nomField.getText();
        double prix = Integer.parseInt(prixField.getText());
        int nb_ingr = Integer.parseInt(nbIngredientsField.getText());



        nomField.clear();
        prixField.clear();
        nbIngredientsField.clear();

        if(nomField.getText() != null && prixField.getText() != null && nbIngredientsField.getText() != null){
            ajouterPizzaDansTab(nom, prix, nb_ingr);
        }
    }

    public void supprimerToutesPizza(){
        table.getItems().clear();
        new pizzaDAO().deletePizzas();
    }

}