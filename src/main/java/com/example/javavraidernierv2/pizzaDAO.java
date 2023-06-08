package com.example.javavraidernierv2;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class pizzaDAO {
    public static List<Pizza> getPizzas() {

        List<Pizza> pizzas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/zell6u_javaEval", "zell6u_appli", "32120430");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pizza");

            while (rs.next()) {
                Pizza pizza = new Pizza(rs.getString(2), rs.getDouble(3), rs.getInt(4));
                pizzas.add(pizza);
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    return pizzas;
    }

    public void addPizza(Pizza pizza){
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/zell6u_javaEval", "zell6u_appli", "32120430");

            PreparedStatement statement = con.prepareStatement("INSERT INTO Pizza(nom, prix, nb_ingredients) VALUES(?,?,?);");
            statement.setString(1, pizza.getNom());
            statement.setDouble(2, pizza.getPrix());
            statement.setInt(3, pizza.getNb_ingredients());

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletePizzas(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/zell6u_javaEval", "zell6u_appli", "32120430");

            PreparedStatement statement = con.prepareStatement("DELETE FROM Pizza");

            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}

