package com.ford;

public class Henry {
    private String name;
    private int loyaltyPoints;

    public Henry() {
        this.name = "Henry";
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    public double applyDiscount(double cost) {
        if (this.loyaltyPoints >= 100) {
            cost *= 0.9;
            this.loyaltyPoints -= 100;
        }
        return cost;
    }
}
