package edu.hw4.Task7;

import edu.hw4.Animal;
import java.util.List;

public final class Task7 {
    private Task7() {

    }

    public static Animal kOldestAnimal(List<Animal> animals, int k) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        if (k >= animals.size()) {
            throw new IllegalArgumentException("k is too big");
        }
        return animals.stream().sorted(new AgeComparator()).toList().get(k);
    }

}

