package com.pluralsight;

public class Snack implements PricedItem{
    private String name;
    private double price;

    public Snack(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return name + (" $" + String.format("%.2f" , price) + ")");
    }
}
