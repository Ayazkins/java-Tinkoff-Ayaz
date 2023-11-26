package edu.project3.FileMaker;

import edu.project3.Exceptions.InvalidWriterException;
import edu.project3.LogReport;

public interface FileCreator {
    void generateFile(LogReport logReport, String dir, String fileName) throws InvalidWriterException;
}
