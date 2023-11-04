package edu.hw4;

import java.util.List;

public final class Task14 {
    private Task14() {

    }

    public static Boolean isDogHigherThanK(List<Animal> animals, int k) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .anyMatch(animal -> animal.height() > k);
    }
}
