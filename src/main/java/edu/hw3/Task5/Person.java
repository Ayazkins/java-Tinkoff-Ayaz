package edu.hw3.Task5;

import org.jetbrains.annotations.Nullable;

public class Person {
    public Person(String name, @Nullable String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String name;
    public String surname;
}
