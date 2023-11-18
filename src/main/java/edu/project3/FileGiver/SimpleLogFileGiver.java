package edu.project3.FileGiver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleLogFileGiver {
    private final static Logger LOGGER = LogManager.getLogger();

    public List<String> getLogFiles(String path) {
        try {
            if (path.startsWith("http")) {
               getUrl(path);
            } else {
               getLocal(path);
            }
        } catch (Exception e) {
            LOGGER.info("Something goes wrong");
        }
        return List.of();
    }

    private List<String> getUrl(String path) throws MalformedURLException {
        URL url = new URL(path);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.info("Wrong url");
            return List.of();
        }
    }

    private List<String> getLocal(String path) {
        Path logPath = Paths.get(path);
        if (Files.exists(logPath)) {
            if (Files.isDirectory(logPath)) {
                try {
                    return Files.walk(logPath)
                        .filter(Files::isRegularFile)
                        .filter(p -> p.getFileName().toString().endsWith(".log"))
                        .map(Path::toString)
                        .collect(Collectors.toList());
                } catch (IOException e) {
                    LOGGER.info("Can't find logs");
                    return List.of();
                }
            } else {
                return List.of(path);
            }
        } else {
            LOGGER.info("File doesn`t exist");
            return List.of();
        }
    }
}
