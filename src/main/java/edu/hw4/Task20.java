package edu.hw4;

import edu.hw4.Task19.Validator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task20 {
    private Task20() {

    }

    public static Map<String, String> validateWithStrings(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream()
            .filter(animal -> !Validator.validate(animal).isEmpty())
            .collect(Collectors.toMap(
                Animal::name,
                animal -> Validator.validate(animal).stream().map(Object::toString).collect(Collectors.joining("\n"))
            ));
    }
}
