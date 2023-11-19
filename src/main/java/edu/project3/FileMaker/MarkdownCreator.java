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
        markdownContent.append("- Total Requests: ").append(logReport.getAmountOfRequests()).append("\n");
        markdownContent.append("- Most Busy Day: ").append(logReport.getMostBusyDay()).append("\n");
        markdownContent.append("- Most Active User: ").append(logReport.getMostActiveUser()).append("\n");
        markdownContent.append("- Average Response Size: ").append(logReport.getAverageResponseSize()).append("\n\n");

        markdownContent.append("## Resources\n\n");
        for (Map.Entry<String, Integer> resource : logReport.getResources().entrySet()) {
            markdownContent.append("- ")
                .append(resource.getKey()).append(": ")
                .append(resource.getValue()).append("\n");
        }
        markdownContent.append("\n");

        markdownContent.append("## Response Codes\n\n");
        for (Map.Entry<String, Integer> responseCode : logReport.getAnswersCodes().entrySet()) {
            markdownContent.append("- ")
                .append(responseCode.getKey()).append(": ")
                .append(responseCode.getValue()).append("\n");
        }
        Path outputPath = Paths.get(dir, fileName + ".md");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(markdownContent.toString());
        } catch (IOException e) {
            throw new InvalidWriterException("Can`t write into file");
        }
    }
}
