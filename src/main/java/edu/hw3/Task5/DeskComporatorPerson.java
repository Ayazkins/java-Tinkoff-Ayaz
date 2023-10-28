package edu.hw3.Task5;

import java.util.Comparator;

public class DeskComporatorPerson implements Comparator<Person> {
    @Override
    public int compare(Person o2, Person o1) {
        if (o1.surname == null && o2.surname == null) {
            return o1.name.compareTo(o2.name);
        }
        if (o1.surname == null) {
            return o1.name.compareTo(o2.surname);
        }
        if (o2.surname == null) {
            return o1.surname.compareTo(o2.name);
        }
        return o1.surname.compareTo(o2.surname);
    }
}
