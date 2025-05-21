package com.pluralsight;

public class Main {
    public static void main(String[] args) {

        Basket<Smoothie> smoothieBasket = new Basket<>();
        smoothieBasket.addItem(new Smoothie("Smoothie Dream",3.50,false,"Strawberry", "Milk", "Sugar"));
        smoothieBasket.addItem(new Smoothie("Tropical Twist",4.25,true,"Pineapple", "Mango", "Coconut Water"));

        System.out.println("\nSmoothie Basket Receipt:");
        smoothieBasket.printReceipt();
        System.out.println("Total Smoothie Basket Pice: $" + String.format("%.2f", smoothieBasket.getTotalPrice()));

    }
}