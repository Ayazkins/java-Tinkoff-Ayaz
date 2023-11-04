package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task6 {
    private Task6() {

    }

    public static Map<Animal.Type, Animal> findHeavies(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.maxBy(Comparator.comparingInt(Animal::weight))
            ))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(null)));
    }
}
