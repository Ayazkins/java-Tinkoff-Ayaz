package edu.hw4;

import java.util.List;

public final class Task9 {
    private Task9() {

    }

    public static Integer amountOfPaws(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }
}
