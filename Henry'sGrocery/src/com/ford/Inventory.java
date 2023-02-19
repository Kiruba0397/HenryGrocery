package com.ford;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<StockItem> stockItems;

    public Inventory() {
        stockItems = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate in5Days = today.plusDays(5);

        stockItems.add(new StockItem("Soup", "tin", 0.65, today.plusDays(1)));
        stockItems.add(new StockItem("Bread", "loaf", 0.80, today.plusDays(2)));
        stockItems.add(new StockItem("Milk", "bottle", 1.30, in5Days));
        stockItems.add(new StockItem("Apples", "single", 0.10, today.plusDays(3)));
    }

    public List<StockItem> getStockItems() {
        return stockItems;
    }

    public StockItem getStockItemByName(String name) {
        for (StockItem item : stockItems) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }
}
