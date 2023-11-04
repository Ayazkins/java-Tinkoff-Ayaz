package edu.hw4.Task2;

import edu.hw4.Animal;
import java.util.Comparator;

class WeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(two.weight(), one.weight());
    }
}
