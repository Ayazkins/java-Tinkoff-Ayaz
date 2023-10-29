package edu.hw3.Task6;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Market implements StockMarket {
    private final Queue<Stock> stocks;

    public Market() {
        stocks = new PriorityQueue<>(new StocksComparator());
    }

    public void add(Stock stock) {
        stocks.add(stock);
    }

    /** Удалить акцию */
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    /** Самая дорогая акция */
    public Stock mostValuableStock() {
        if (stocks.isEmpty()) {
            throw new NoSuchElementException("No stocks");
        }
        return stocks.peek();
    }
}
