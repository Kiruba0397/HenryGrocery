package com.ford;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<StockItem, Integer> items;
    
    

    public Basket() {
        items = new HashMap<>();
    }

    public void addItem(StockItem item) {
        addItem(item, 1);
    }

    public void addItem(StockItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }


    public double getTotalCost(LocalDate purchaseDate) {
        double total = 0.0;
        for (Map.Entry<StockItem, Integer> entry : items.entrySet()) {
            StockItem item = entry.getKey();
            int quantity = entry.getValue();
            double itemPrice = item.getDiscountedPrice(purchaseDate);
            total += itemPrice * quantity;
        }

        return total;
    }
}
