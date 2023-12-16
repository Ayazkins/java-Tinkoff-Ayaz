package edu.hw10.Task2.Calculators;

import edu.hw10.Task2.Annotations.Cache;

public interface FibCalculator {
    @Cache(persist = true)
    long fib(int number);
}