package edu.hw3.Task6;

public class Stock {
    public Stock(int price, String name) {
        this.price = price;
        this.name = name;
    }

    private final int price;
    private final String name;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
