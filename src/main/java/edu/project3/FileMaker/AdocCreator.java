package edu.project3.FileMaker;

import edu.project3.Exceptions.InvalidWriterException;
import edu.project3.LogReport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdocCreator implements FileCreator {
    @Override
    public void generateFile(LogReport logReport, String dir, String fileName) throws InvalidWriterException {
        StringBuilder adocContent = new StringBuilder();

        adocContent.append("= Log Report\n\n");

        adocContent.append("== Statistics\n\n");
        adocContent.append(formatKeyValue("* Total Requests", logReport.getAmountOfRequests()));
        adocContent.append(formatKeyValue("* Most Busy Day", logReport.getMostBusyDay()));
        adocContent.append(formatKeyValue("* Most Active User", logReport.getMostActiveUser()));
        adocContent.append(formatKeyValue("* Average Response Size", logReport.getAverageResponseSize()));
        adocContent.append("\n");

        adocContent.append("== Resources\n\n");
        logReport.getResources().forEach((resource, count) ->
            adocContent.append(formatKeyValue("* " + resource, count)));
        adocContent.append("\n");

        adocContent.append("== Response Codes\n\n");
        logReport.getAnswersCodes().forEach((responseCode, count) ->
            adocContent.append(formatKeyValue("* " + responseCode, count)));

        Path outputPath = Paths.get(dir, fileName + ".adoc");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(adocContent.toString());
        } catch (IOException e) {
            throw new InvalidWriterException("Can't write to file");
        }
    }

    private String formatKeyValue(String key, Object value) {
        return String.format("%s: %s\n", key, value);
    }
}
