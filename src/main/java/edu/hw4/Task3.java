package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task3 {
    private Task3() {

    }

    public static Map<Animal.Type, Integer> countTypes(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream().collect(Collectors.toMap(Animal::type, e -> 1, Integer::sum));
    }
}
