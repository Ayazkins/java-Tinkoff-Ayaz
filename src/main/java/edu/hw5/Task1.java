package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class Task1 {
    private Task1() {

    }

    public static Duration calculateDuration(List<String> stringList) {
        Duration duration = Duration.ZERO;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        for (String str : stringList) {
            String[] parsed = str.split(" - ");
            if (parsed.length != 2) {
                throw new IllegalArgumentException();
            }
            LocalDateTime begin = LocalDateTime.parse(parsed[0], dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(parsed[1], dateTimeFormatter);
            Duration curDuration = Duration.between(begin, end);
            duration = duration.plus(curDuration);
        }
        return duration.dividedBy(stringList.size());
    }
}
