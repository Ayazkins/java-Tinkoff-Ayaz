package edu.project3;

import edu.project3.CommandLIneParser.SimpleCommandParser;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Project3Test {
    @Test
    public void logRecordTest() {
        String log = "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"";
        LogRecord logRecord = LogRecord.parse(log);
        assertEquals(304, logRecord.getStatus());
        assertEquals(0, logRecord.getBodyBytesSent());
        assertNull(logRecord.getRemoteUser());
        assertEquals("93.180.71.3", logRecord.getRemoteAddress());
        assertEquals("2015-05-17T08:05:32", logRecord.getTimestamp().toString());
        assertEquals("GET /downloads/product_1 HTTP/1.1", logRecord.getRequest());
    }

    @Test
    public void logReportTest() {
        List<LogRecord> logRecords = List.of(
            LogRecord.parse("93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\""),
            LogRecord.parse("93.180.71.3 - - [17/May/2015:08:05:23 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\""),
            LogRecord.parse("80.91.33.133 - - [17/May/2015:08:05:24 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.17)\""),
            LogRecord.parse("217.168.17.5 - - [17/May/2015:08:05:34 +0000] \"GET /downloads/product_1 HTTP/1.1\" 200 490 \"-\" \"Debian APT-HTTP/1.3 (0.8.10.3)\""));
        LogReport logReport = new LogReport();
        logReport.countValues(logRecords);
        assertEquals(4, logReport.getAmountOfRequests());
        assertEquals("2015-05-17", logReport.getMostBusyDay().toString());
        assertEquals(122.5, logReport.getAverageResponseSize());
        assertEquals("93.180.71.3", logReport.getMostActiveUser());
        Map<String, Integer> resources = new HashMap<>();
        resources.put("GET /downloads/product_1 HTTP/1.1", 4);
        assertEquals(resources, logReport.getResources());
        Map<String, Integer> codes = new HashMap<>();
        codes.put("OK", 1);
        codes.put("Not modified", 3);
        assertEquals(codes, logReport.getAnswersCodes());
    }

    @Test
    public void parserTest() {
        String[] args = new String[] {"--path", "testPath", "--to", "2023-08-31", "--from", "2023-08-31", "--format", "markdown"};
        ParsedArguments parsedArguments = new SimpleCommandParser().parseCommand(args);
        assertEquals("testPath", parsedArguments.path());
        assertEquals("markdown", parsedArguments.format());
        assertEquals("2023-08-31", parsedArguments.to().toString());
        assertEquals("2023-08-31", parsedArguments.from().toString());
    }
}
