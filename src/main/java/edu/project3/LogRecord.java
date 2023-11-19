package edu.project3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRecord {
    public static final int REMOTE_ADDRESS_INDEX = 1;
    public static final int REMOTE_USER_INDEX = 3;
    public static final int TIME_INDEX = 4;
    public static final int COMMAND_INDEX = 5;
    public static final int RESOURCE_INDEX = 6;
    public static final int RESOURCE_INDEX_SECOND = 7;
    public static final int STATUS_INDEX = 8;
    public static final int BYTES_INDEX = 9;
    public static final int REFERER_INDEX = 10;
    public static final int AGENT_INDEX = 11;
    private String remoteAddress;
    private String remoteUser;
    private LocalDateTime timestamp;
    private String request;
    private int status;
    private int bodyBytesSent;
    private String referer;
    private String userAgent;

    private static final Pattern LOG_PATTERN = Pattern.compile(
        "(\\S+) (\\S+) (\\S+) \\[([^\\]]+)\\] \"(\\S+) (\\S+)\\s*(\\S+)?\" (\\d{3}) (\\d+) \"(.+)?\" \"(.+)\"");

    public static LogRecord parse(String line) {
        Matcher matcher = LOG_PATTERN.matcher(line);
        if (matcher.matches()) {
            LogRecord logState = new LogRecord();
            logState.remoteAddress = matcher.group(REMOTE_ADDRESS_INDEX);
            logState.remoteUser = matcher.group(REMOTE_USER_INDEX).equals("-") ? null
                : matcher.group(REMOTE_USER_INDEX);

            String timestampStr = matcher.group(TIME_INDEX);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
            logState.timestamp = LocalDateTime.parse(timestampStr, formatter);

            logState.request = matcher.group(COMMAND_INDEX) + " " + matcher.group(RESOURCE_INDEX) + " " + matcher.group(
                RESOURCE_INDEX_SECOND);
            logState.status = Integer.parseInt(matcher.group(STATUS_INDEX));
            logState.bodyBytesSent = Integer.parseInt(matcher.group(BYTES_INDEX));
            logState.referer = matcher.group(REFERER_INDEX).equals("-") ? null : matcher.group(REFERER_INDEX);
            logState.userAgent = matcher.group(AGENT_INDEX);
            return logState;
        } else {
            throw new IllegalArgumentException("Invalid log format: " + line);
        }
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public String getRemoteUser() {
        return remoteUser;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getRequest() {
        return request;
    }

    public int getStatus() {
        return status;
    }

    public int getBodyBytesSent() {
        return bodyBytesSent;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
