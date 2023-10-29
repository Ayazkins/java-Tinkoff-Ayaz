package edu.hw3.Task5;

import java.util.Comparator;

public class AscPersonComporator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getSurname() == null && o2.getSurname() == null) {
            return o1.getName().compareTo(o2.getName());
        }
        if (o1.getSurname() == null) {
            return o1.getName().compareTo(o2.getSurname());
        }
        if (o2.getSurname() == null) {
            return o1.getSurname().compareTo(o2.getName());
        }
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
