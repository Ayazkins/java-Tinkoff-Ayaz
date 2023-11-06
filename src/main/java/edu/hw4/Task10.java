package edu.hw4;

import java.util.List;

public final class Task10 {
    private Task10() {

    }

    public static List<Animal> listOfAnimalsWherePawsIsNotEqualAge(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws())
            .toList();
    }
}
