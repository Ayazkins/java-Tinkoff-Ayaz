package edu.project3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogReport {

    private int amountOfRequests;
    private LocalDate mostBusyDay;
    private String mostActiveUser;

    private double averageResponseSize;

    private Map<String, Integer> resources;

    private Map<String, Integer> answersCodes;

    public final static Map<Integer, String> CODES = Map.of(
        200, "OK",
        404, "Not Found",
        500, "Internal Server Error",
        304, "Not modified"
    );

    public void countValues(List<LogRecord> logStream) {
        int totalRequests = 0;
        Map<String, Integer> resourceCounts = new HashMap<>();
        Map<String, Integer> responseCodeCounts = new HashMap<>();
        Map<String, Integer> userRequestCounts = new HashMap<>();
        Map<String, Integer> datRequestCounts = new HashMap<>();
        LocalDate tempMostBusyDay = null;
        int maxRequestCountPerDay = 0;
        double totalResponseSize = 0;
        int responseCount = 0;

        for (LogRecord logRecord : logStream) {
            totalRequests++;

            String resource = logRecord.getRequest();
            resourceCounts.put(resource, resourceCounts.getOrDefault(resource, 0) + 1);

            int responseCode = logRecord.getStatus();
            String responseName = getResponseCodeName(responseCode);
            responseCodeCounts.put(responseName, responseCodeCounts.getOrDefault(responseName, 0) + 1);

            int responseSize = logRecord.getBodyBytesSent();
            totalResponseSize += responseSize;
            responseCount++;

            String user = logRecord.getRemoteAddress();
            userRequestCounts.put(user, userRequestCounts.getOrDefault(user, 0) + 1);

            LocalDate requestDate = logRecord.getTimestamp().toLocalDate();
            int requestCountPerDay = datRequestCounts.getOrDefault(requestDate.toString(), 0) + 1;
            datRequestCounts.put(requestDate.toString(), requestCountPerDay);
            if (requestCountPerDay > maxRequestCountPerDay) {
                maxRequestCountPerDay = requestCountPerDay;
                tempMostBusyDay = requestDate;
            }
        }

        double tempResponseSize = totalResponseSize / responseCount;

        this.amountOfRequests = totalRequests;
        this.mostBusyDay = tempMostBusyDay.atStartOfDay().toLocalDate();
        this.mostActiveUser = findMostActiveUser(userRequestCounts);
        this.averageResponseSize = tempResponseSize;
        this.resources = resourceCounts;
        this.answersCodes = responseCodeCounts;
    }

    private String getResponseCodeName(int responseCode) {
        return CODES.getOrDefault(responseCode, String.valueOf(responseCode));
    }

    private String findMostActiveUser(Map<String, Integer> userRequestCounts) {
        int maxRequests = 0;
        String tempMostActiveUser = null;
        for (Map.Entry<String, Integer> entry : userRequestCounts.entrySet()) {
            String user = entry.getKey();
            int requestCount = entry.getValue();
            if (requestCount > maxRequests) {
                maxRequests = requestCount;
                tempMostActiveUser = user;
            }
        }
        return tempMostActiveUser;
    }

    public LocalDate getMostBusyDay() {
        return mostBusyDay;
    }

    public String getMostActiveUser() {
        return mostActiveUser;
    }

    public double getAverageResponseSize() {
        return averageResponseSize;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public Map<String, Integer> getAnswersCodes() {
        return answersCodes;
    }

    public int getAmountOfRequests() {
        return amountOfRequests;
    }
}
