package edu.hw4;

import edu.hw4.Task4.Task4;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void longestNameTest() {
        Animal a = new Animal("Dog", Animal.Type.DOG, Animal.Sex.M, 1, 50, 10, true);
        Animal b = new Animal("Car", Animal.Type.CAT, Animal.Sex.M, 1, 60, 10, true);
        Animal c = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 1, 70, 10, true);
        Animal d = new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1, 70, 10, true);
        List<Animal> test = new ArrayList<>();
        Collections.addAll(test, a, b, c, d);
        assertEquals(d, Task4.getLongestName(test));
    }
}
