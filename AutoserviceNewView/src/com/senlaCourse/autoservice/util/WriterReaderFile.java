package com.senlaCourse.autoservice.util;

import com.danco.training.TextFileWorker;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterReaderFile {
    private final Logger logger = Logger.getLogger(WriterReaderFile.class);
    public void worker(String[] mas, String file) {

        final String TEST_FILE = file;
        final String[] testValues = mas;

        // Create new file
        Path filePath = Paths.get(TEST_FILE);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                logger.error("Can not create file", e);
            }
        }

        try {
            TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
            fileWorker.writeToFile(testValues);
            Object[] readedValues = fileWorker.readFromFile();
            // Check result
            for (int i = 0; i < testValues.length; i++) {

                if (!readedValues[i].equals(testValues[i])) {
                    throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
                }
            }
        } finally {
//            Files.deleteIfExists(filePath);
        }
    }
}
