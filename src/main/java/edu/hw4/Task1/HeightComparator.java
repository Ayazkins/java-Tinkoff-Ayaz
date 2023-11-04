package edu.hw4.Task1;

import edu.hw4.Animal;
import java.util.Comparator;

class HeightComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(one.height(), two.height());
    }
}

