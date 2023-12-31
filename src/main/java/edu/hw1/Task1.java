package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTES = 60;

    @SuppressWarnings("ReturnCount")
    public static int minutesToSeconds(String time) {
        if (time == null) {
            return -1;
        }
        String[] array = time.split(":");
        if (array.length != 2) {
            return -1;
        }
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(array[0]);
            seconds = Integer.parseInt(array[1]);
        } catch (NumberFormatException exception) {
            return -1;
        }
        int answer;
        if (seconds >= SECONDS_IN_MINUTES || seconds < 0 || minutes < 0) {
            answer = -1;
        } else {
            answer = minutes * SECONDS_IN_MINUTES + seconds;
        }
        return answer;
    }
}
