package edu.hw4.Task1;

import edu.hw4.Animal;
import java.util.List;

public final class Task1 {
    private Task1() {

    }

    public static List<Animal> heightSort(List<Animal> animals) {
        if (animals == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return animals.stream().sorted(HeightComparator.heightComparator).toList();
    }
}

