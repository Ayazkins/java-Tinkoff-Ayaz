package edu.hw4;

import edu.hw4.Task19.Task19;
import edu.hw4.Task19.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task19Test {
    @Test
    public void validationErrorTest() {
        Animal a = new Animal("Dog", Animal.Type.FISH, Animal.Sex.F, -2, -10, 10, true);
        Animal b = new Animal("Dog2", Animal.Type.FISH, Animal.Sex.F, -1, 60, 50, false);
        Animal c = new Animal("Bird", Animal.Type.SPIDER, Animal.Sex.F, 2, 70, 20, true);
        Animal d = new Animal("Bird2", Animal.Type.FISH, Animal.Sex.M, 5, 80, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        Map<String, Set<ValidationError>> output = Task19.validate(test);
        for (ValidationError validationError : output.get("Dog")) {
            assertTrue(validationError.fieldName().equals("age") || validationError.fieldName().equals("height"));
        }
        assertEquals("age", output.get("Dog2").stream().findFirst().get().fieldName());
    }
}
