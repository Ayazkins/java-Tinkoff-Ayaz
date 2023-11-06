package edu.hw4.Task7;

import edu.hw4.Animal;
import java.util.Comparator;

class AgeComparator implements Comparator<Animal> {
    public static AgeComparator ageComparator = new AgeComparator();

    @Override
    public int compare(Animal one, Animal two) {
        return Integer.compare(two.age(), one.age());
    }
}

