package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class FileSearchTask extends RecursiveTask<List<File>> {

    private final File directory;
    private final Predicate<File> predicate;

    public FileSearchTask(File directory, Predicate<File> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();
        List<FileSearchTask> subTasks = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    FileSearchTask fileSearchTask = new FileSearchTask(file, predicate);
                    subTasks.add(fileSearchTask);
                    fileSearchTask.fork();
                } else if (predicate.test(file)) {
                    result.add(file);
                }
            }
        }
        for (FileSearchTask subTask : subTasks) {
            result.addAll(subTask.join());
        }
        return result;
    }
}
