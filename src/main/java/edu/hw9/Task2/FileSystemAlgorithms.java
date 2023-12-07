package edu.hw9.Task2;

import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import static org.apache.logging.log4j.core.util.FileUtils.getFileExtension;

public final class FileSystemAlgorithms {
    private FileSystemAlgorithms() {

    }

    public static List<File> findDirectoriesWithMoreThan1000Files(File file) {
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            DirectorySearchTask task = new DirectorySearchTask(file);
            return forkJoinPool.invoke(task);
        }
    }

    public static List<File> findFilesWithPredicate(File file, long size, String extension) {
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            FileSearchTask task = new FileSearchTask(file, pred -> {
                long fileSize = pred.length();
                String fileExtension = getFileExtension(pred);
                return fileSize > size && fileExtension.equals(extension);
            });
            return forkJoinPool.invoke(task);
        }
    }
}
