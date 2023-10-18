package edu.project1;

public sealed interface Result {
    record Defeat() implements Result {
    }

    record Win() implements Result {
    }

    record FailedStart() implements Result {
    }

    record StopPlaying() implements Result {
    }

    record Typo() implements Result {

    }

    record Right() implements Result {

    }

    record Wrong() implements Result {

    }

    record Go() implements Result {

    }

    record Finish() implements Result {

    }
}
