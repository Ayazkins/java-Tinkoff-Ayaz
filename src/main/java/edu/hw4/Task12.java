package edu.hw4;

import java.util.List;

public final class Task12 {
    private Task12() {

    }

    public static Integer weightMoreThatHeight(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
                .filter(animal -> animal.weight() > animal.height()).map(e -> 1).reduce(0, Integer::sum);
    }
}

