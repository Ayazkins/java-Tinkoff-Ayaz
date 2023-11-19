package edu.project3;

import edu.project3.CommandLIneParser.CommandParser;
import edu.project3.Exceptions.EmptyFileException;
import edu.project3.Exceptions.InvalidUrlException;
import edu.project3.Exceptions.NoPathException;
import edu.project3.FileGiver.LogFileGiver;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogAnalysator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final CommandParser commandParser;
    private final LogFileGiver logFileGiver;

    public LogAnalysator(CommandParser commandParser, LogFileGiver logFileGiver) {
        this.commandParser = commandParser;
        this.logFileGiver = logFileGiver;
    }

    public LogReport analyze(String[] args) throws NoPathException, EmptyFileException, InvalidUrlException {
        ParsedArguments parsedArguments = commandParser.parseCommand(args);
        if (parsedArguments.path() == null) {
            throw new NoPathException("Path is necessary");
        }
        List<LogRecord> filteredLogs =
            logFileGiver.getLogFiles(parsedArguments.path(), parsedArguments.from(), parsedArguments.to());
        if (filteredLogs.isEmpty()) {
            throw new EmptyFileException("No logs in file");
        }
        LogReport logReport = new LogReport();
        logReport.countValues(filteredLogs);
        return logReport;
    }
}
