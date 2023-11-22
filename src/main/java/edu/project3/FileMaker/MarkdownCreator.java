package edu.project3.FileMaker;

import edu.project3.Exceptions.InvalidWriterException;
import edu.project3.LogReport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class MarkdownCreator implements FileCreator {
    @Override
    public void generateFile(LogReport logReport, String dir, String fileName) throws InvalidWriterException {
        StringBuilder markdownContent = new StringBuilder();

        markdownContent.append("# Log Report\n\n");

        markdownContent.append("## Statistics\n\n");
        markdownContent.append(formatKeyValue("- Total Requests", logReport.getAmountOfRequests()));
        markdownContent.append(formatKeyValue("- Most Busy Day", logReport.getMostBusyDay()));
        markdownContent.append(formatKeyValue("- Most Active User", logReport.getMostActiveUser()));
        markdownContent.append(formatKeyValue("- Average Response Size", logReport.getAverageResponseSize()));
        markdownContent.append("\n");

        markdownContent.append("## Resources\n\n");
        logReport.getResources().forEach((resource, count) ->
            markdownContent.append(formatKeyValue("- " + resource, count)));
        markdownContent.append("\n");

        markdownContent.append("## Response Codes\n\n");
        logReport.getAnswersCodes().forEach((responseCode, count) ->
            markdownContent.append(formatKeyValue("- " + responseCode, count)));

        Path outputPath = Paths.get(dir, fileName + ".md");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(markdownContent.toString());
        } catch (IOException e) {
            throw new InvalidWriterException("Can't write to file");
        }
    }

    private String formatKeyValue(String key, Object value) {
        return String.format("%s: %s  \n", key, value);
    }
}
