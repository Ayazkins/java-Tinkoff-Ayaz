package edu.hw4.Task8;

import edu.hw4.Animal;
import java.util.List;
import java.util.Optional;

public final class Task8 {
    private Task8() {

    }

    public static Optional<Animal> findHeaviestLowerk(List<Animal> animals, int k) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(DiffWeightComparator.diffWeightComparator);
    }
}


