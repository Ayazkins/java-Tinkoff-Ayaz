package edu.project3;

import java.time.LocalDate;

public record ParsedArguments(String path, LocalDate from, LocalDate to, String format) {
}
