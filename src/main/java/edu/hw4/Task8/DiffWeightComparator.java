package edu.hw4.Task8;

import edu.hw4.Animal;
import java.util.Comparator;

class DiffWeightComparator implements Comparator<Animal> {
    public static DiffWeightComparator diffWeightComparator = new DiffWeightComparator();

    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(one.weight(), two.weight());
    }
}
