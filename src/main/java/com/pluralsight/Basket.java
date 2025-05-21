package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; //Not strictly needed for this Basket version, but good for general stream use


//A generic Basket that can hold any type T that extends PricedItem.
//It can add items, calculate total price, and print a receipt.
public class Basket <T extends PricedItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    //Calculates total price using a stream
    public double getTotalPrice() {
        return items.stream().mapToDouble(PricedItem::getPrice).sum();
    }

    //Prints a receipt for all items in the basket
    public void printReceipt() {
        items.forEach(item -> System.out.println(item.getName() + ": $" + String.format("%.2f", item.getPrice())));
    }

    public <T> List<T> createBasket(T item) {
        List<T> allItems = new ArrayList<>();
        allItems.add(item);
        return allItems;
    }

}
