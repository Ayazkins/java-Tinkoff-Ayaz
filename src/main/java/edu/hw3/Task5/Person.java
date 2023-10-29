package edu.hw3.Task5;

import org.jetbrains.annotations.Nullable;

public class Person {
    private final String name;
    private final String surname;

    public Person(String name, @Nullable String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
