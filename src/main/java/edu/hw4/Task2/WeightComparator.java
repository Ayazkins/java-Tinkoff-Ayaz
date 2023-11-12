package edu.hw4.Task2;

import edu.hw4.Animal;
import java.util.Comparator;

class WeightComparator implements Comparator<Animal> {
    public static WeightComparator weightComparator = new WeightComparator();

    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(two.weight(), one.weight());
    }
}
