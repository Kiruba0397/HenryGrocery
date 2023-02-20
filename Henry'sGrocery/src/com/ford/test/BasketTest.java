package com.ford.test;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ford.Basket;

import com.ford.StockItem;

public class BasketTest {
	
    @Test
    public void testSoupAndBreadOffer() {
        Basket basket = new Basket();

       
        LocalDate today = LocalDate.now();

        // Add 3 tins of soup and 2 loaves of bread
        basket.addItem(new StockItem("soup", "tin", 0.65, LocalDate.now()), 3);
        basket.addItem(new StockItem("bread", "loaf", 0.80, LocalDate.now()), 2);

        // Verify the total cost with soup and bread offer
        assertEquals(3.15, basket.getTotalCost(today));
    }
    
    @Test
    public void testAppleDiscount() {
        Basket basket = new Basket();

        LocalDate today = LocalDate.now();

        // Add 6 apples and a bottle of milk
        basket.addItem(new StockItem("apples", "bag", 0.10 , LocalDate.now()), 6);
        basket.addItem(new StockItem("milk", "bottle", 1.30, LocalDate.now()), 1);

        // Verify the total cost with apple discount
        assertEquals(1.90, basket.getTotalCost(today));
    }

    @Test
    public void testAppleDiscountFuture() {
        Basket basket = new Basket();
     
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(5);

        // Add 6 apples and a bottle of milk to be bought in 5 days time
        basket.addItem(new StockItem("apples", "bag", 0.10, LocalDate.now()), 6);
        basket.addItem(new StockItem("milk", "bottle", 1.30, LocalDate.now()), 1);

        // Verify the total cost with apple discount in the future
        assertEquals(1.84, basket.getTotalCost(future));
    }

    @Test
    public void testSoupBreadAndAppleDiscountFuture() {
        Basket basket = new Basket();
     
        LocalDate today = LocalDate.now();
        LocalDate future = today.plusDays(5);

        // Add 3 apples, 2 tins of soup and a loaf of bread to be bought in 5 days time
        basket.addItem(new StockItem("apples", "bag", 0.10, LocalDate.now()), 3);
        basket.addItem(new StockItem("soup", "tin", 0.65, LocalDate.now()), 2);
        basket.addItem(new StockItem("bread", "loaf", 0.80, LocalDate.now()), 1);

        // Verify the total cost with soup, bread and apple discount in the future
        assertEquals(1.97, basket.getTotalCost(future));
    }

}
