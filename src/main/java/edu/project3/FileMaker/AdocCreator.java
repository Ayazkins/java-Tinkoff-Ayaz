package edu.project3.FileMaker;

import edu.project3.Exceptions.InvalidWriterException;
import edu.project3.LogReport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class AdocCreator implements FileCreator {
    @Override
    public void generateFile(LogReport logReport, String dir, String fileName) throws InvalidWriterException {
        StringBuilder adocContent = new StringBuilder();

        adocContent.append("= Log Report\n\n");

        adocContent.append("== Statistics\n\n");
        adocContent.append("* Total Requests: ").append(logReport.getAmountOfRequests()).append("\n");
        adocContent.append("* Most Busy Day: ").append(logReport.getMostBusyDay()).append("\n");
        adocContent.append("* Most Active User: ").append(logReport.getMostActiveUser()).append("\n");
        adocContent.append("* Average Response Size: ").append(logReport.getAverageResponseSize()).append("\n\n");

        adocContent.append("== Resources\n\n");
        for (Map.Entry<String, Integer> resource : logReport.getResources().entrySet()) {
            adocContent.append("* ").append(resource.getKey()).append(": ").append(resource.getValue()).append("\n");
        }
        adocContent.append("\n");

        adocContent.append("== Response Codes\n\n");
        for (Map.Entry<String, Integer> responseCode : logReport.getAnswersCodes().entrySet()) {
            adocContent.append("* ")
                .append(responseCode.getKey()).append(": ")
                .append(responseCode.getValue()).append("\n");
        }

        Path outputPath = Paths.get(dir, fileName + ".adoc");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath.toFile()))) {
            writer.write(adocContent.toString());
        } catch (IOException e) {
            throw new InvalidWriterException("Can`t write into file");
        }
    }
}
