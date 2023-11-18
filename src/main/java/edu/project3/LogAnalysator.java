package edu.project3;

import edu.project3.CommandLIneParser.CommandParser;
import edu.project3.CommandLIneParser.SimpleCommandParser;
import edu.project3.FileGiver.LogFileGiver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LogAnalysator {
    private final static Logger LOGGER = LogManager.getLogger();
    private final CommandParser commandParser;
    private final  LogFileGiver logFileGiver;

    public LogAnalysator(CommandParser commandParser, LogFileGiver logFileGiver) {
        this.commandParser = commandParser;
        this.logFileGiver = logFileGiver;
    }

    public void analyze(String[] args) {
        ParsedArguments parsedArguments = commandParser.parseCommand(args);
        if (parsedArguments.path() == null) {
            LOGGER.info("Path is necessary");
            return;
        }
        List<String> logFiles = logFileGiver.getLogFiles(parsedArguments.path());
        if (logFiles.isEmpty()) {
            return;
        }
        
    }

}
