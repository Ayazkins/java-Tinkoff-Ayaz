package edu.hw4.Task4;

import edu.hw4.Animal;
import java.util.Comparator;

class NameComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(one.name().length(), two.name().length());
    }
}
