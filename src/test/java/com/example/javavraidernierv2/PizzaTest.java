package com.example.javavraidernierv2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PizzaTest {

    Pizza p = new Pizza("nature", 10.50,1);

    @Test
    @DisplayName("Test getter nom")
    void getNom() {
        assertEquals("nature", p.getNom());
    }

    @Test
    @DisplayName("Test setter nom")
    void setNom() {
        p.setNom("aze");
        assertEquals("aze", p.getNom() );
    }

    @Test
    @DisplayName("Test setNbIngredients")
    void setNb_ingredients() {
        assertAll(() -> assertEquals("nature", p.getNom()),
                ()->    assertEquals(10.50, p.getPrix()),
                ()->    assertEquals(1, p.getNb_ingredients()));
    }
}