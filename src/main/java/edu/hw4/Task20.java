package edu.hw4;

import edu.hw4.Task19.Validator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task20 {
    private Task20() {

    }

    public static Map<String, String> validateWithStrings(List<Animal> animals, Validator validator) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> !validator.validate(animal).isEmpty())
            .collect(Collectors.toMap(
                Animal::name,
                animal -> validator.validate(animal).stream().map(Object::toString).collect(Collectors.joining("\n"))
            ));
    }
}
