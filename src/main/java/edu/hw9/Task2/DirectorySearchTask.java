package edu.hw9.Task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirectorySearchTask extends RecursiveTask<List<File>> {
    private static final int THRESHOLD = 1000;

    private final File directory;

    public DirectorySearchTask(File directory) {
        this.directory = directory;
    }

    @Override
    protected List<File> compute() {
        List<File> result = new ArrayList<>();
        List<DirectorySearchTask> subTasks = new ArrayList<>();

        File[] files = directory.listFiles();
        if (files != null) {
            if (files.length > THRESHOLD) {
                result.add(directory);
            }

            for (File file : files) {
                if (file.isDirectory()) {
                    DirectorySearchTask subTask = new DirectorySearchTask(file);
                    subTasks.add(subTask);
                    subTask.fork();
                }
            }
        }

        for (DirectorySearchTask subTask : subTasks) {
            result.addAll(subTask.join());
        }

        return result;
    }
}
