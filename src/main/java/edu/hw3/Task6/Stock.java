package edu.hw3.Task6;

public class Stock {
    public Stock(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    private final Integer price;
    private final String name;

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
