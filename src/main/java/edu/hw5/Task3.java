package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task3 {
    private Task3() {

    }

    public static Optional<LocalDate> parseData(String s) {
        return yyyymmddParse(s);
    }

    private static Optional<LocalDate> yyyymmddParse(String s) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            return yyyymmdParse(s);
        }
        return Optional.of(localDate);
    }

    private static Optional<LocalDate> yyyymmdParse(String s) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        } catch (DateTimeParseException e) {
            return mdyyyyParse(s);
        }
        return Optional.of(localDate);
    }

    private static Optional<LocalDate> mdyyyyParse(String s) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("M/d/yyyy"));
        } catch (DateTimeParseException e) {
            return mdyyParse(s);
        }
        return Optional.of(localDate);
    }

    private static Optional<LocalDate> mdyyParse(String s) {
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(s, DateTimeFormatter.ofPattern("M/d/yy"));
        } catch (DateTimeParseException e) {
            return wordParse(s);
        }
        return Optional.of(localDate);
    }

    private static Optional<LocalDate> wordParse(String s) {
        LocalDate localDate = LocalDate.now();
        if (s.equalsIgnoreCase("tomorrow")) {
            return Optional.of(localDate.plusDays(1));
        } else if (s.equalsIgnoreCase("today")) {
            return Optional.of(localDate);
        } else if (s.equalsIgnoreCase("yesterday")) {
            return Optional.of(localDate.minusDays(1));
        } else {
            return daysAgoParse(s);
        }
    }

    private static Optional<LocalDate> daysAgoParse(String s) {
        Pattern pattern = Pattern.compile("(\\d+)\\s+day(s)?\\s+ago");
        Matcher matcher = pattern.matcher(s.trim());
        if (matcher.matches()) {
            int daysAgo = Integer.parseInt(matcher.group(1));
            LocalDate date = LocalDate.now().minus(daysAgo, ChronoUnit.DAYS);
            return Optional.of(date);
        } else {
            return Optional.empty();
        }
    }

}
