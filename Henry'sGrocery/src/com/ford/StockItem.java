package com.ford;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class StockItem {
    private String name;
    private String unit;
    private double cost;
    private LocalDate expiryDate;

    public StockItem(String name, String unit, double cost, LocalDate expiryDate) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getDiscountedPrice(LocalDate purchaseDate) {
        if (ChronoUnit.DAYS.between(purchaseDate, expiryDate) <= 2) {
            return cost * 0.8;
        } else {
            return cost;
        }
    }
}
