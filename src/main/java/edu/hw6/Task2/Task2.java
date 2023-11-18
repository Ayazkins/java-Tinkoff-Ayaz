package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public final class Task2 {
    private Task2() {

    }

    public static void cloneFile(Path path) throws IOException {
        String fileName = path.getFileName().toString();
        var ext = getExt(fileName);
        int copyNumber = 0;
        String copyFileName = fileName.replaceAll(ext, "");

        while (Files.exists(path.resolveSibling(copyFileName))) {
            copyNumber++;
            copyFileName = fileName + " — копия";
            if (copyNumber == 1) {
                copyFileName = copyFileName + ext;
                continue;
            }
            copyFileName = copyFileName + (copyNumber > 1 ? " (" + copyNumber + ")" : "") + ext;
        }
        Path copyPath = path.resolveSibling(copyFileName);
        Files.copy(path, copyPath);
    }

    private static String getExt(String file) {
        var ext = Optional.ofNullable(file)
            .filter(f -> f.contains("."))
            .map(f -> f.substring(file.lastIndexOf(".")));
        return ext.orElse("");
    }
}
