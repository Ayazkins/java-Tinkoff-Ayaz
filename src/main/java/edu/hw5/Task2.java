package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {

    }

    private static final int AMOUNT_OF_MONTH = 12;
    private static final int DAY_THIRTEEN = 13;

    public static List<LocalDate> findFriday13th(int year) {
        if (year < 0) {
            throw new IllegalArgumentException();
        }

        List<LocalDate> dates = new ArrayList<>();
        for (int month = 1; month <= AMOUNT_OF_MONTH; ++month) {
            LocalDate localDate = LocalDate.of(year, month, DAY_THIRTEEN);
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                dates.add(localDate);
            }
        }
        return dates;
    }

    public static LocalDate nextFriday13th(LocalDate date) {
        TemporalAdjuster nextFriday13Adjuster = TemporalAdjusters.ofDateAdjuster(t -> {
            LocalDate nextDate = t.plusDays(1);
            while (nextDate.getDayOfMonth() != DAY_THIRTEEN) {
                nextDate = nextDate.plusDays(1);
            }
            while (nextDate.getDayOfWeek() != DayOfWeek.FRIDAY) {
                nextDate = nextDate.plusMonths(1);
            }
            return nextDate;
        });

        return date.with(nextFriday13Adjuster);

    }
}
