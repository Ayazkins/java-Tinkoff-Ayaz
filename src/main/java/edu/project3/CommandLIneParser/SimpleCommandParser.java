package edu.project3.CommandLIneParser;

import edu.project3.ParsedArguments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleCommandParser implements CommandParser {
    private final static Logger LOGGER = LogManager.getLogger();

    public ParsedArguments parseCommand(String[] args) {
        String logPath = null;
        String fromDate = null;
        String toDate = null;
        String outputFormat = null;
        for (int i = 0; i < args.length; ++i) {
            String arg = args[i];
            switch (arg) {
                case "--path":
                    logPath = args[++i];
                    break;
                case "--format":
                    outputFormat = args[++i];
                    break;
                case "--to":
                    toDate = args[++i];
                    break;
                case "--from":
                    fromDate = args[++i];
                    break;
                default:
                    LOGGER.info("Wrong command \n" +
                        "\"Usage: java -jar nginx-log-stats.jar --path <log_file_path> [--from <start_date>] [--to <end_date>] [--format <output_format>]\"");
            }
        }
        return new ParsedArguments(logPath, fromDate, toDate, outputFormat);
    }
}
