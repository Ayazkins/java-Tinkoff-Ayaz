package edu.hw9;

import edu.hw9.Task2.DirectorySearchTask;
import edu.hw9.Task2.FileSystemAlgorithms;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import static org.apache.logging.log4j.core.util.FileUtils.getFileExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Task2Test {
    @Test
    public void findDirectoriesTest() {
        File mockFile = mock(File.class);
        when(mockFile.isDirectory()).thenReturn(false);
        File[] files = new File[1001];
        for (int i = 0; i < 1001; ++i) {
            files[i] = mockFile;
        }
        File mockDirectory = mock(File.class);
        when(mockDirectory.getName()).thenReturn("Name");
        when(mockDirectory.listFiles()).thenReturn(files);
        var test = FileSystemAlgorithms.findDirectoriesWithMoreThan1000Files(mockDirectory);
        assertEquals(1, test.size());
        assertEquals("Name", test.get(0).getName());
    }

    @Test
    public void findFilesTest() {

        File[] files = new File[1001];
        for (int i = 0; i < 500; ++i) {
            File mockFile = mock(File.class);
            when(mockFile.isDirectory()).thenReturn(false);
            when(mockFile.length()).thenReturn(10L);
            when(mockFile.getName()).thenReturn(i + ".txt");
            files[i] = mockFile;
        }

        for (int i = 500; i < 1001; ++i) {
            File mockFile = mock(File.class);
            when(mockFile.isDirectory()).thenReturn(false);
            when(mockFile.length()).thenReturn(5L);
            when(mockFile.getName()).thenReturn("som.ong");
            files[i] = mockFile;
        }
        File mockDirectory = mock(File.class);
        when(mockDirectory.getName()).thenReturn("Name");
        when(mockDirectory.listFiles()).thenReturn(files);
        var test = FileSystemAlgorithms.findFilesWithPredicate(mockDirectory, 9L, "txt");
        assertEquals(500, test.size());
        for (int i = 0; i < 500; ++i) {
            assertEquals(Integer.toString(i) + ".txt", test.get(i).getName());
        }
    }
}
