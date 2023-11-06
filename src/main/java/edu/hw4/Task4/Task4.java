package edu.hw4.Task4;

import edu.hw4.Animal;
import java.util.List;

public final class Task4 {
    private Task4() {

    }

    public static Animal getLongestName(List<Animal> list) {
        if (list == null) {
            throw new IllegalArgumentException("List should not be empty");
        }
        return list.stream().max(NameComparator.nameComparator).get();
    }
}




