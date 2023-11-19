package edu.project3.CommandLIneParser;

import edu.project3.ParsedArguments;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleCommandParser implements CommandParser {
    private final static Logger LOGGER = LogManager.getLogger();

    public ParsedArguments parseCommand(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String logPath = null;
        LocalDate fromDate = null;
        LocalDate toDate = null;
        String outputFormat = "markdown";
        for (int i = 0; i < args.length; i += 2) {
            int index = i;
            String arg = args[index];
            switch (arg) {
                case "--path":
                    logPath = args[index + 1];
                    break;
                case "--format":
                    outputFormat = args[index + 1];
                    break;
                case "--to":
                    toDate = LocalDate.parse(args[index + 1], dateTimeFormatter);
                    break;
                case "--from":
                    fromDate = LocalDate.parse(args[index + 1], dateTimeFormatter);
                    break;
                default:
                    LOGGER.info("Wrong command \n"
                        + "\"Usage: java -jar nginx-log-stats.jar --path <log_file_path> "
                        + "[--from <start_date>] [--to <end_date>] [--format <output_format>]\"");
                    throw new IllegalArgumentException("Wrong path");
            }
        }
        return new ParsedArguments(logPath, fromDate, toDate, outputFormat);
    }
}
