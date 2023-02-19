package com.ford.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BasketTest {
	
    @Test
    public void testSoupAndBreadOffer() {
        Basket basket = new Basket();
        Henry henry = new Henry();
        LocalDate today = LocalDate.now();

        // Add 3 tins of soup and 2 loaves of bread
        basket.addItem(new StockItem("soup", "tin", 0.65, LocalDate.now()), 3);
        basket.addItem(new StockItem("bread", "loaf", 0.80, LocalDate.now()), 2);

        // Verify the total cost with soup and bread offer
        assertEquals(3.15, basket.getTotalCost(henry, today));
    }

}
