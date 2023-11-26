package edu.project3;

import edu.project3.CommandLIneParser.CommandParser;
import edu.project3.Exceptions.EmptyFileException;
import edu.project3.Exceptions.InvalidUrlException;
import edu.project3.Exceptions.NoPathException;
import edu.project3.FileGiver.LogGiver;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogAnalysator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final CommandParser commandParser;
    private final LogGiver fileLogGiver;
    private final LogGiver urlLogGiver;

    public LogAnalysator(CommandParser commandParser, LogGiver fileLogGiver, LogGiver urlLogGiver) {
        this.commandParser = commandParser;
        this.fileLogGiver = fileLogGiver;
        this.urlLogGiver = urlLogGiver;
    }

    public LogReport analyze(String[] args) throws NoPathException, EmptyFileException, InvalidUrlException {
        ParsedArguments parsedArguments = commandParser.parseCommand(args);
        if (parsedArguments.path() == null) {
            throw new NoPathException("Path is necessary");
        }
        List<LogRecord> filteredLogs =
            getLogs(parsedArguments.path(), parsedArguments.from(), parsedArguments.to());
        if (filteredLogs.isEmpty()) {
            throw new EmptyFileException("No logs in file");
        }
        LogReport logReport = new LogReport();
        logReport.countValues(filteredLogs);
        return logReport;
    }

    private List<LogRecord> getLogs(String path, LocalDate start, LocalDate end)
        throws NoPathException, InvalidUrlException {
        if (path.startsWith("http")) {
            return urlLogGiver.getLogFiles(path, start, end);
        } else {
            return fileLogGiver.getLogFiles(path, start, end);
        }
    }
}
