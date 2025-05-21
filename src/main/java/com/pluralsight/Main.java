package com.pluralsight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("🍌🍏SMOOTHIES🍏🍌");
        //Define menu of smoothies
        List<Smoothie> menu = Arrays.asList(
                new Smoothie("Strawberry Dream", 3.50, false, "Strawberry", "Milk"),
                new Smoothie("Green Boost", 4.99, true, "Spinach", "Apple", "Mint"),
                new Smoothie("Tropical Twist", 4.25, true, "Pineapple", "Mango", "Coconut Water"),
                new Smoothie("Berry Blast", 5.75, false, "Mixed Berries", "Yogurt"),
                new Smoothie("Power Up", 6.20, true, "Banana", "Protein Powder", "Almond Milk")
        );

        //Filter: Get smoothies costing less than $5.00
        List<Smoothie> underFiveDollars = menu.stream()
                .filter(s ->s.getPrice() < 5.0) //Lambda for filtering
                .collect(Collectors.toList()); //Collect results into a new list
        System.out.println("\nSmoothies under $5.00: ");
        underFiveDollars.forEach(System.out::println);

        //MapToDouble & Sum: Calculate the total price of all smoothies on the menu
        double totalMenuPrice = menu.stream()
                .mapToDouble(Smoothie::getPrice) //Method reference to get price
                .sum();
        System.out.println("\nTotal price of the full menu: $" + String.format("%.2f", totalMenuPrice));

        //Sorted: Sort smoothies by name alphabetically
        List<Smoothie> sortedByName = menu.stream()
                .sorted(Comparator.comparing(Smoothie::getName)) //Lambda for sorting criteria
                .collect(Collectors.toList());
        System.out.println("\nMenu sorted by name:");
        sortedByName.forEach(System.out::println);

        //ForEach: Print all smoothie names and their prices
        System.out.println("\nAll smoothie names and prices:");
        menu.forEach(s -> System.out.println(s.getName() + ": $" + String.format("%.2f", s.getPrice())));

        //Method that returns only Vegan Smoothies using .filter(...)
        List<Smoothie> fullMenu = Arrays.asList(
                new Smoothie("Tropical Twist", 4.25, false, "Pineapple", "Mango", "Coconut Milk"),
                new Smoothie("Green Power", 5.50, true, "Spinach", "Kale", "Apple", "Banana"),
                new Smoothie("Berry Bliss", 4.75, false, "Strawberry", "Blueberry", "Yogurt"),
                new Smoothie("Vegan Delight", 6.00, true, "Almond Milk", "Banana", "Peanut Butter", "Dates"),
                new Smoothie("Simple Banana", 3.00, true, "Banana", "Water")
        );

        List<Smoothie> veganSmoothies = fullMenu.stream()
                .filter(Smoothie::isVegan) //Uses the isVegan Method reference
                .collect(Collectors.toList());
        System.out.println("\nAvailable Vegan Smoothies");
        veganSmoothies.forEach(System.out::println);

        //Sort the Menu by Price
        List<Smoothie> menuToSort = Arrays.asList(
                new Smoothie("Tropical Twist", 4.25, false, "Pineapple", "Mango", "Coconut Milk"),
                new Smoothie("Green Power", 5.50, true, "Spinach", "Kale", "Apple", "Banana"),
                new Smoothie("Berry Bliss", 4.75, false, "Strawberry", "Blueberry", "Yogurt"),
                new Smoothie("Vegan Delight", 6.00, true, "Almond Milk", "Banana", "Peanut Butter", "Dates"),
                new Smoothie("Simple Banana", 3.00, true, "Banana", "Water")
        );

        List<Smoothie> sortedMenuByPrice = fullMenu.stream()
                .sorted(Comparator.comparingDouble(Smoothie::getPrice))
                .collect(Collectors.toList());
        System.out.println("\nMenu sorted by price (ascending):");
        sortedMenuByPrice.forEach(System.out::println);


        System.out.println("\n🍭🍫SNACKS🍫🍭");

        Basket<Snack> snackBasket = new Basket<>();
        snackBasket.addItem(new Snack("Cookie",1.50));
        snackBasket.addItem(new Snack("Muffin",2.00));
        snackBasket.addItem(new Snack("Brownie",2.25));

        System.out.println("\nSnack Basket Receipt");
        snackBasket.printReceipt();
        System.out.println("\nTotal Snack Basket Price: $" + String.format("%.2f", snackBasket.getTotalPrice()) );


    }
}