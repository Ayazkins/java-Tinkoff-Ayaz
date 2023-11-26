package edu.project3.FileGiver;

import edu.project3.Exceptions.BadReaderException;
import edu.project3.Exceptions.InvalidUrlException;
import edu.project3.Exceptions.NoPathException;
import edu.project3.LogRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;
import java.util.stream.Stream;

public class UrlLogGiver implements LogGiver {
    @Override
    public List<LogRecord> getLogFiles(String path, LocalDate start, LocalDate end)
        throws InvalidUrlException, NoPathException {
        try {
            return filterLogsByTime(getUrl(path), start, end);
        } catch (Exception e) {
            throw new InvalidUrlException("URL is invalid");
        }
    }

    private List<String> getUrl(String path) throws MalformedURLException, BadReaderException {
        URL url = new URL(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new BadReaderException("Reading url mistake");
        }
    }

    private List<LogRecord> filterLogsByTime(List<String> logs, LocalDate startTime, LocalDate endTime) {
        Stream<LogRecord> logStream = logs.stream().map(LogRecord::parse);
        if (startTime != null) {
            logStream = logStream.filter(log -> log.getTimestamp().isAfter(ChronoLocalDateTime.from(startTime)));
        }
        if (endTime != null) {
            logStream = logStream.filter(log -> log.getTimestamp().isBefore(endTime.atStartOfDay()));
        }
        return logStream.toList();
    }
}
