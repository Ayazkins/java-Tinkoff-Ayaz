package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.Set;

public final class DefaultValidator implements Validator {
    public DefaultValidator() {

    }

    public Set<ValidationError> validate(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.age() < 0) {
            errors.add(new ValidationError("age", "Age cannot be negative"));
        }

        if (animal.weight() < 0) {
            errors.add(new ValidationError("weight", "Weight cannot be negative"));
        }

        if (animal.height() < 0) {
            errors.add(new ValidationError("height", "Height cannot be negative"));
        }

        return errors;

    }
}
