package edu.hw3.Task6;

import java.util.Comparator;

public class StocksComparator implements Comparator<Stock> {
    public int compare(Stock stock1, Stock stock2) {
        if (stock1.getPrice() < stock2.getPrice()) {
            return 1;
        } else if (stock1.getPrice() > stock2.getPrice()) {
            return -1;
        }
        return 0;
    }
}
