package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.Set;

public interface Validator {
    Set<ValidationError> validate(Animal animal);

}
