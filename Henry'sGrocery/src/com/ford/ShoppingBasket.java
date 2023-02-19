package com.ford;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ShoppingBasket {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        Henry henry = new Henry();

        System.out.println("Available items:");
        for (StockItem item : inventory.getStockItems()) {
            System.out.printf("%s (%s) - %.2f\n", item.getName(), item.getUnit(), item.getCost());
        }

        Basket basket = new Basket();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of the item you want to add to the basket (or 'done' to finish):");
        String itemName = scanner.nextLine();

        while (!itemName.equals("done")) {
            StockItem stockItem = inventory.getStockItemByName(itemName);
            if (stockItem == null) {
                System.out.println("Item not found. Please try again.");
            } else {
                System.out.printf("Enter the quantity of %s you want to add to the basket: ", stockItem.getName());
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                basket.addItem(stockItem, quantity);

                System.out.printf("%d %s added to the basket.\n", quantity, stockItem.getName());
            }

            System.out.println("Please enter the name of the item you want to add to the basket (or 'done' to finish):");
            itemName = scanner.nextLine();
        }

        LocalDate purchaseDate = LocalDate.now();
        System.out.println("Enter the purchase date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        if (!dateStr.isEmpty()) {
            purchaseDate = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
        }

        double totalCost = basket.getTotalCost(henry,purchaseDate);
        System.out.printf("Total cost: %.2f\n", totalCost);
    }
}

