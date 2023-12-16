package edu.hw10.Task1.Objects;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import edu.hw10.Task1.Annotations.NotNull;

public class GrownUpPerson {
    protected final String name;
    protected final int age;

    public GrownUpPerson(@NotNull String name, @Min(18) @Max(199) int age) {
        this.age = age;
        this.name = name;
    }

    public static GrownUpPerson create(@NotNull String name, @Min(18) @Max(199) int age) {
        return new GrownUpPerson(name, age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
