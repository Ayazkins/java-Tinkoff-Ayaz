package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task19 {
    private Task19() {

    }

    public static Map<String, Set<ValidationError>> validate(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> !Validator.validate(animal).isEmpty())
            .collect(Collectors.toMap(
                Animal::name,
                animal -> Validator.validate(animal)
            ));
    }
}
