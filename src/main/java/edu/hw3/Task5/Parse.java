package edu.hw3.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Parse {
    private Parse() {

    }

    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    private static final String SPACE = " ";

    public static List<Person> parseContacts(String[] names, String format) {
        ArrayList<Person> list = new ArrayList<>();
        for (String person : names) {
            String[] nameAndSurname = person.split(SPACE);
            if (nameAndSurname.length < 1 || nameAndSurname.length > 2) {
                throw new IllegalArgumentException();
            }
            if (nameAndSurname.length == 1) {
                list.add(new Person(nameAndSurname[0], null));
            } else {
                list.add(new Person(nameAndSurname[0], nameAndSurname[1]));
            }
        }
        if (!(Objects.equals(format, ASC) || Objects.equals(format, DESC))) {
            throw new IllegalArgumentException();
        }
        if (format.equals(ASC)) {
            list.sort(new AscPersonComporator());
        }

        if (format.equals(DESC)) {
            list.sort(new DeskComporatorPerson());
        }

        return list;
    }
}
