package edu.project3.FileGiver;

import edu.project3.Exceptions.BadReaderException;
import edu.project3.Exceptions.NoPathException;
import edu.project3.LogRecord;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleLogFileGiver implements LogGiver {
    private final static Logger LOGGER = LogManager.getLogger();

    public List<LogRecord> getLogFiles(String path, LocalDate start, LocalDate end) throws NoPathException {
        try {
            return filterLogsByTime(getLocal(path), start, end);
        } catch (Exception e) {
            throw new NoPathException("Path is invalid");
        }
    }

    private List<String> getLocal(String path) throws BadReaderException, NoPathException {
        List<String> list = new ArrayList<>();
        Path logPath = Paths.get(path);
        if (Files.exists(logPath)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                return list;
            } catch (IOException e) {
                throw new BadReaderException("Reading local file mistake");
            }
        } else {
            throw new NoPathException("File doesn't exist");
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
