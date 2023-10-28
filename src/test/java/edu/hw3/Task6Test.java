package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @DisplayName("Simple test")
    @Test
    void SimpleTest() {
        Stock stock1 = new Stock(100, "Stock1");
        Stock stock2 = new Stock(50, "Stock2");
        Stock stock3 = new Stock(200, "Stock3");
        StockMarket stockMarket = new Market();
        stockMarket.add(stock1);
        stockMarket.add(stock3);
        stockMarket.add(stock2);
        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock3);
        stockMarket.remove(stock3);
        assertThat(stockMarket.mostValuableStock()).isEqualTo(stock1);
    }

    @DisplayName("Try get empty test")
    @Test
    void EmptyTest() {
        StockMarket stockMarket = new Market();

        try{
            stockMarket.mostValuableStock();
        }
        catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("No stocks");
        }
    }
}
