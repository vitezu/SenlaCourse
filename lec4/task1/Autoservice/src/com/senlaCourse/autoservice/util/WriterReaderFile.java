package com.senlaCourse.autoservice.util;

import com.danco.training.TextFileWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterReaderFile {

    private String TEST_FILE;
    private Printer printer = new Printer();
    private TextFileWorker fileWorker;

    public WriterReaderFile(String file) {
        TEST_FILE = file;
    }

    public void writeToFile(String[] strings) {

        Path filePath = Paths.get(TEST_FILE);
        if (!Files.exists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fileWorker = new TextFileWorker(TEST_FILE);
        fileWorker.writeToFile(strings);
    }

    public void readFromFile() {
        Object[] readedValues = fileWorker.readFromFile();
        System.out.println("Readed values");
        for (Object object : readedValues) {
            printer.printObject(object);
        }
    }
}
