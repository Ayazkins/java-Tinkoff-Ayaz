package edu.project3.FileGiver;

import edu.project3.Exceptions.InvalidUrlException;
import edu.project3.LogRecord;
import java.time.LocalDate;
import java.util.List;

public interface LogFileGiver {
    List<LogRecord> getLogFiles(String path, LocalDate start, LocalDate end) throws InvalidUrlException;
}
